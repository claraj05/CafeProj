package com.web.root.cafe.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;

@Controller
@RequestMapping("cafe")
public class CafeController {
	
	@Autowired
	CafeService cf;
	
	
	
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
	public String test(HttpServletRequest request, Model model,
			@RequestParam(value = "num", required = false, defaultValue = "1") int num) {
		cf.cafeAllList(model,num);
		return "cafe/cafeAllList";
	}
	
	@PostMapping("writeSave") 
    public String writeSave(HttpServletResponse response,
                      CafeDTO dto, @RequestParam("multiFile") List<MultipartFile> multiFileList, @RequestParam String imgContent, HttpServletRequest request
                      ,Model model) throws IOException {
      // multiFileList 안에 들어있는게 : changeFile
       /*
              response.addHeader("Content-disposition", "attachment;fileName=" + imageFileName);

     File file = new File(BoardFileService.IMAGE_REPO + "/" + imageFileName);
     FileInputStream in = new FileInputStream(file);
     FileCopyUtils.copy(in, response.getOutputStream());
     in.close();
         
        */
       PrintWriter out = response.getWriter();
       response.setContentType("text/html; charset=utf-8");
     
     // 받아온것 출력 확인
       System.out.println("multiFileList : " + multiFileList);
       System.out.println("fileContent : " + imgContent);
       
             
     // path 가져오기
       String path = request.getSession().getServletContext().getRealPath("resources");
       String root = path + "\\" + "uploadFiles"+"\\"+dto.getCafe_no();
     
     
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

	  
	/* @RequestMapping("test")
	 public String test() {
		 return "cafe/test";
	 }*/


	
}





















