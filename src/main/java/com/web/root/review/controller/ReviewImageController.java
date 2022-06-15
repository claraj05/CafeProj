package com.web.root.review.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewImageController {

	
	@GetMapping("/img/{id}")
	public Resource resource() {
		
		
		return new FileSystemResource("");
	}
}
