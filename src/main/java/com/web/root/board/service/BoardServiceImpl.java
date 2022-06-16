package com.web.root.board.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.board.dto.BoardDTO;
import com.web.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public void boardWrite(MultipartHttpServletRequest mul) {
		
		String id=mul.getParameter("id");
		String title=mul.getParameter("title");
		String content=mul.getParameter("content");
		MultipartFile mf1=mul.getFile("file1");
		MultipartFile mf2=mul.getFile("file2");
		MultipartFile mf3=mul.getFile("file3");
		String imageFileName1=mf1.getOriginalFilename();
		String imageFileName2=mf2.getOriginalFilename();
		String imageFileName3=mf3.getOriginalFilename();
		
		BoardDTO dto=new BoardDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		mapper.boardWrite(dto);
		mapper.boardWriteImage(imageFileName1, imageFileName2, imageFileName3);
		
		File file1=new File(path+"/"+imageFileName1);
		File file2=new File(path+"/"+imageFileName2);
		File file3=new File(path+"/"+imageFileName3);
		try {
			mf1.transferTo(file1);
			mf2.transferTo(file2);
			mf3.transferTo(file3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void boardList(Model model, int currentPage) {
		
		int pageLetter=3; //페이지당 글수
		int totalLetter=mapper.boardCount(); //총 글수
		int totalPage=(totalLetter-1)/pageLetter+1; //총 페이지수
		
		int endLetter=pageLetter*currentPage; //현재 페이지의 마지막 글번호
		int startLetter=endLetter-pageLetter+1; //현재 페이지의 첫번째 글번호
		
		int block=3; //넘기는 페이지 단위
		int startPage=((currentPage-1)/block)*block+1;
		int endPage=startPage+block-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);		
		model.addAttribute("list", mapper.boardList(startLetter, endLetter));
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	}

	@Override
	public void boardView(Model model, int write_no) {
		
		model.addAttribute("board", mapper.boardView(write_no));
		
		model.addAttribute("boardImage", mapper.boardImageView(write_no));
	}

	@Override
	public void boardModify(MultipartHttpServletRequest mul, int write_no) {
		
		String title=mul.getParameter("title");
		String content=mul.getParameter("content");
		
		BoardDTO dto=new BoardDTO();
		dto.setWrite_no(write_no);
		dto.setTitle(title);
		dto.setContent(content);
		
		mapper.boardModify(dto);
		//파일 폴더에 저장하기
	}

	@Override
	public void boardDelete(int write_no) {
		
		mapper.boardDelete(write_no);
		
		mapper.seqDelete();
		
		int seqStart=mapper.boardCount()+1;
		
		mapper.seqCreate(seqStart);
		
		mapper.boardImageFkDrop();
		mapper.boardLikeFkDrop();
		
		mapper.boardNoDown(write_no);		
		mapper.boardImageNoDown(write_no);
		mapper.boardLikeNoDown(write_no);
		
		mapper.boardImageFkAdd();
		mapper.boardLikeFkAdd();
	}

	@Override
	public void upHit(int write_no) {
		
		mapper.upHit(write_no);
	}

	@Override
	public void boardSearch(Model model, String searchList, String search, int currentPage) {
		
		int pageLetter=3; //페이지당 글수		 
		
		int endLetter=pageLetter*currentPage; //현재 페이지의 마지막 글번호
		int startLetter=endLetter-pageLetter+1; //현재 페이지의 첫번째 글번호		
		
		int totalLetter=0;
		if(searchList.equals("title")) {
			totalLetter=mapper.boardCountByTitle(search);
			model.addAttribute("list", mapper.boardSearchByTitle(search, startLetter, endLetter));
		}else if(searchList.equals("content")) {
			totalLetter=mapper.boardCountByContent(search);
			model.addAttribute("list", mapper.boardSearchByContent(search, startLetter, endLetter));			
		}else if(searchList.equals("id")) {
			totalLetter=mapper.boardCountById(search);
			model.addAttribute("list", mapper.boardSearchById(search, startLetter, endLetter));			
		}
		
		int totalPage=(totalLetter-1)/pageLetter+1; //총 페이지수
		
		int block=3; //넘기는 페이지 단위
		int startPage=((currentPage-1)/block)*block+1;
		int endPage=startPage+block-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	}

	@Override
	public int boardLike(HttpServletRequest request) {
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
		String id=request.getParameter("id");
		
		int check=mapper.likeCheck(write_no, id); //1:데이터o, 0:데이터x
		
		return check;
	}

	@Override
	public void likeMinus(HttpServletRequest request) { //데이터 삭제
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
		String id=request.getParameter("id");
		
		mapper.likeMinus(write_no, id);
	}

	@Override
	public void likePlus(HttpServletRequest request) {//데이터 추가
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
		String id=request.getParameter("id");
		
		mapper.likePlus(write_no, id);
	}

	@Override
	public void likeCountMinus(HttpServletRequest request) {
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
		
		mapper.likeCountMinus(write_no);
	}

	@Override
	public void likeCountPlus(HttpServletRequest request) {
		
		int write_no=Integer.parseInt(request.getParameter("write_no"));
			
		mapper.likeCountPlus(write_no);		
	}

}












