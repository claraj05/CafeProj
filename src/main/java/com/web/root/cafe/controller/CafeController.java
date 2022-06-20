package com.web.root.cafe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.session.name.MemberSession;

@Controller
@RequestMapping("cafe")
public class CafeController implements MemberSession{
	
	@Autowired
	CafeService cf;
	
	@RequestMapping("searchEng")
	public String searchEng(HttpServletRequest request, Model model,HttpServletResponse response) throws IOException {
		String searchKW = request.getParameter("searchKW");
		try {
			if(searchKW!=null) {
				cf.searchEng(searchKW, model);
			}
			return "cafe/searchKWResult";
		} catch (Exception e) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('검색어를 입력하세요');"+
						"location.href='" + request.getContextPath() + "/index'</script>");
				return "index";
		}
	}
	
	@GetMapping("searchView")
	public String searchView() {
		return "cafe/searchView";
	}
	
	@GetMapping("eventView")
	public String eventView(HttpServletRequest request, Model model) {
		cf.eventView(model);
		return "cafe/eventView";
	}
	
	@GetMapping("mycafe")
	public String mycafe() {
		return "cafe/mycafe";
	}
	
	@GetMapping("searchResult")
	public String searchResult(HttpServletRequest request, 
			@RequestParam("location1") String location1, 
			@RequestParam("kidszone") String kidszone, 
			@RequestParam("petzone") String petzone,
			@RequestParam("star")String star,Model model) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String [] locationList = request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		star = request.getParameter("star");
		if(locationList[0].contentEquals("0")) {
			String test[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
			cf.getlocationList(request,test, kidszone, petzone, star, model);
		}else {
			cf.getlocationList(request,locationList, kidszone, petzone, star, model);
		}
		return "cafe/searchResult";
	}
	
	@GetMapping("cafeAllList")
	public String test(HttpServletRequest request, Model model,HttpServletResponse response,
			@RequestParam(value = "num", required = false, defaultValue = "1") int num) throws Exception  {
		cf.cafeAllList(model,num);
		cf.uploadImage(model);
		return "cafe/cafeAllList";
	}
	@GetMapping("download")//사진 불러오기
	public void download(int cafe_no,HttpServletRequest request, HttpServletResponse response) throws Exception {
		cafe_no = Integer.parseInt(request.getParameter("cafe_no"));
		String root = cf.getImgRoot(cafe_no);
		String firstImageFileName = cf.getImgFirstName(cafe_no); //
		System.out.println("경로 : "+root);
		System.out.println("첫번째 파일 이름 : "+firstImageFileName);
		
		response.addHeader("Content-disposition", "attachment;fileName=" + firstImageFileName);
		
		File file = new File(root + "/" + firstImageFileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
	 @PostMapping("writeSave") 
	  public String writeSave(HttpServletResponse response,
			  				CafeDTO dto, @RequestParam("multiFile") List<MultipartFile> multiFileList, @RequestParam String imgContent, HttpServletRequest request
			  				,Model model) throws IOException {
	 
		  PrintWriter out = response.getWriter();
		  response.setContentType("text/html; charset=utf-8");
		
		// 받아온것 출력 확인
		  System.out.println("multiFileList : " + multiFileList);
		  System.out.println("fileContent : " + imgContent);
				  
		// path 가져오기
		  String path = request.getSession().getServletContext().getRealPath("resources");
		  String root = path + "\\" + "uploadFiles"+"\\";
		
		
		  File fileCheck = new File(root);
		
		  if(!fileCheck.exists()) fileCheck.mkdirs();
		
		
			List<Map<String, String>> fileList = new ArrayList<>();
			
			for(int i = 0; i < multiFileList.size(); i++) {
				String originFile = multiFileList.get(i).getOriginalFilename();
				String ext = originFile.substring(originFile.lastIndexOf("."));
				String changeFile = UUID.randomUUID().toString() + ext;
				
				
				Map<String, String> map = new HashMap<>();
				map.put("originFile", originFile);
				map.put("changeFile", changeFile);
				
				fileList.add(map);

			}
			
			
			 System.out.println(fileList);
			
			// 파일업로드
			try {
				for(int i = 0; i < multiFileList.size(); i++) {
					File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
					multiFileList.get(i).transferTo(uploadFile);
				}
				
				System.out.println("다중 파일 업로드 성공!");
				System.out.println("path : " + path);
				
			} catch (IllegalStateException | IOException e) {
				System.out.println("다중 파일 업로드 실패 ㅠㅠ");
				// 만약 업로드 실패하면 파일 삭제
				for(int i = 0; i < multiFileList.size(); i++) {
					new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
				}
				e.printStackTrace();
			}
			int result = 0;
			
			result = cf.writeSave(request, dto, multiFileList, imgContent, root); //카페정보
			if(result!=0) {
				return "result";
			}else {
				return "fail";
			}
	  }
	 
	  @GetMapping("cafemanager")
	  public String cafemanager() {
		  return "cafe/cafemanager";
	  }
	  
	  @RequestMapping("addFavorite")
	  public String addFavorite(HttpServletRequest request) {
		  
		  String id = request.getParameter("id");
		  System.out.println("id : "+id);
		  int cafe_no =Integer.parseInt(request.getParameter("cafe_no"));
		  int check = cf.checkLike(id,cafe_no); //이미 있는지 확인
		  try {
			  if(check==0) {
				  cf.plusLike(id, cafe_no);
				  cf.countplus(cafe_no);
			  }else {
				  cf.minusLike(id, cafe_no);
				  cf.countminus(cafe_no);
			  }
			  System.out.println("좋아요 성공");
		} catch (Exception e) {
			System.out.println("좋아요기능 실패...");
		}
		  return "cafe/addFavorite";
	  }

	
}





















