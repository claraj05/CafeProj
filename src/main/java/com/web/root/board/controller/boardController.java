package com.web.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class boardController {

	@Autowired
	BoardService bs;
	
	@GetMapping("boardList")
	public String boardList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		
		bs.boardList(model, currentPage);
		
		return "board/boardList";
	}
	
	@GetMapping("boardWriteForm")
	public String boardWriteForm() {
				
		return "board/boardWriteForm";
	}
	
	@PostMapping("boardWrite")
	public String boardWrite(MultipartHttpServletRequest mul) {
		
		bs.boardWrite(mul);
		
		return "redirect:boardList";
	}
	
	@GetMapping("boardView")
	public String boardView(Model model, HttpServletRequest request, @RequestParam(value="check", required=false, defaultValue="-1") int check) {
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
		
		bs.boardView(model, write_no);
		
		bs.upHit(write_no); //새로고침이나 좋아요 눌렀을 때 조회수 증가 안되게 할 수 없을까?
		
		if(check==-1) {
			check=bs.boardLike(request);//1:데이터o, 0:데이터x
		}
		System.out.println(check);
		
		model.addAttribute("check", check);
		
		return "board/boardView";
	}
	
	@GetMapping("boardModifyForm")
	public String boardModifyForm(Model model, @RequestParam int write_no) {
		
		bs.boardView(model, write_no);
		
		return "board/boardModifyForm";
	}
	
	@PostMapping("boardModify")
	public String boardModify(MultipartHttpServletRequest mul, @RequestParam int write_no) {
		
		bs.boardModify(mul, write_no);
		
		return "redirect:boardList";
	}
	
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam int write_no) {
		
		bs.boardDelete(write_no);
		
		return "redirect:boardList";
	}
	
	@GetMapping("download1")
	public void download1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String imageFileName1=request.getParameter("imageFileName1");
		
		response.setHeader("content-disposition", "attachment;fileName="+imageFileName1);
		
		File file=new File(BoardService.path+"/"+imageFileName1);
		
		FileInputStream in=new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());			
	}
	
	@GetMapping("download2")
	public void download2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String imageFileName2=request.getParameter("imageFileName2");
		
		response.setHeader("content-disposition", "attachment;fileName="+imageFileName2);
		
		File file=new File(BoardService.path+"/"+imageFileName2);
		
		FileInputStream in=new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());			
	}
	
	@GetMapping("download3")
	public void download3(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String imageFileName3=request.getParameter("imageFileName3");
		
		response.setHeader("content-disposition", "attachment;fileName="+imageFileName3);
		
		File file=new File(BoardService.path+"/"+imageFileName3);
		
		FileInputStream in=new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());		
	}
	
	@PostMapping("boardSearch")
	public String boardSearch(HttpServletRequest request, Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		
		String searchList=request.getParameter("searchList");
		String search=request.getParameter("search");
		
		bs.boardSearch(model, searchList, search, currentPage);
		
		return "board/boardList";
	}
	
	@GetMapping("boardLike")
	public String boardLike(HttpServletRequest request, RedirectAttributes ra) {
		
		int check=bs.boardLike(request); //1:데이터o, 0:데이터x
		
		if(check==1) {//데이터o->데이터 삭제(좋아요 체크 해제)
			bs.likeMinus(request);
			bs.likeCountMinus(request);
			check=0;
		}else {//데이터x->데이터 추가(좋아요 체크)
			bs.likePlus(request);
			bs.likeCountPlus(request);
			check=1;
		}
		
		ra.addAttribute("write_no", request.getParameter("write_no"));
		ra.addAttribute("check", check);
		
		System.out.println(request.getParameter("write_no"));
		System.out.println(request.getParameter("id"));
		
		return "redirect:boardView";
	}
}










