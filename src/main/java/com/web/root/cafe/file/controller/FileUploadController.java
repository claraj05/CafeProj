package com.web.root.cafe.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("cafe")
public class FileUploadController {
	
	

	@GetMapping("cafefile")
	public String cafefile() {
		return "cafe/cafefile";
	}

	@PostMapping("/multi-file")
	public String multiFileUpload(@RequestParam("multiFile") List<MultipartFile> multiFileList, @RequestParam String fileContent, HttpServletRequest request) {
		
		// 받아온것 출력 확인
		System.out.println("multiFileList : " + multiFileList);
		System.out.println("fileContent : " + fileContent);
		
		// path 가져오기
		String path = request.getSession().getServletContext().getRealPath("resources");
		String root = path + "\\" + "uploadFiles";
		
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
		
		
		
		return "result";
	}
}























