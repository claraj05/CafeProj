package com.web.root.cafe.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.mybatis.cafe.CafeMapper;

@Service
public class CafeFileServiceImpl implements CafeFileService{
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private CafeMapper mapper; 
	
	private static String DEFAULT_PATH = "C:\\"+"img"+File.separator;
	
	@Override
	public void cafeImgSave(int cafe_no, String imgContent, List<MultipartFile> multiFiles) throws IllegalStateException, IOException {
		String path = DEFAULT_PATH + cafe_no + File.separator; 
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		for(int i=0; i<multiFiles.size(); i++) {
			file = new File(path, multiFiles.get(i).getOriginalFilename());
			multiFiles.get(i).transferTo(file);
			mapper.cafeImgSave(cafe_no,imgContent, multiFiles.get(i).getOriginalFilename(),path);
		}
	}

	
}
