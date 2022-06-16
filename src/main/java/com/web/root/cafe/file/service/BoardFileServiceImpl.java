package com.web.root.cafe.file.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.board.dto.BoardDTO;
import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.img.ImageMapper;

@Service
public class BoardFileServiceImpl implements BoardFileService {
	
	
	@Autowired
	private ImageMapper cafeImageMapper;

	@Override
	public String getMessage(HttpServletRequest request, String msg, String url) {
		String message = null;
		String path = request.getContextPath();
		message = "<script>alert('" + msg + "');";
		message += "location.href='" + path + url + "';</script>";
		return message;
	}

	@Override
	public String saveFile(MultipartFile file) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();

		String sysFileName = sdf.format(calendar.getTime());
		sysFileName += file.getOriginalFilename();

		File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
		try {
			file.transferTo(saveFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}

	@Override
	public void deleteImage(String originFileName) {
		File file = new File(IMAGE_REPO + "/" + originFileName);
		file.delete();

	}
	
}
