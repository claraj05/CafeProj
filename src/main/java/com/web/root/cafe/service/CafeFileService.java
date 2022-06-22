package com.web.root.cafe.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface CafeFileService {

	public void cafeImgSave(int cafe_no,String imgContent, List<MultipartFile> multiFiles) throws IllegalStateException, IOException;
}
