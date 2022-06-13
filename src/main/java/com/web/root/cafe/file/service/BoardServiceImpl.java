package com.web.root.cafe.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.board.dto.BoardDTO;
import com.web.root.cafe.dto.CafeDTO;
import com.web.root.mybatis.board.BoardMapper;
import com.web.root.mybatis.cafe.CafeMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardFileService bfs;

	
	@Override
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		
		CafeDTO dto  = new CafeDTO();
		
		dto.setCafe_no("cafe_no");
		dto.setCafe_name("cafe_name");
		dto.setLocation1("location1");
		dto.setLocation2("location2");
		dto.setCafe_tel("cafe_tel");
		dto.setMenu("menu");
		dto.setKidszone("kidszone");
		dto.setPetzone("petzone");
		dto.setUse_time("use_time");
		dto.setImageFileName("imageFileName");
		dto.setAvg_star("avg_star");
		dto.setLogtime("logtime");
		MultipartFile file = mul.getFile("imageFileName");
		
		if(file.getSize() != 0) { // 이미지 파일이 있을때
			dto.setImageFileName(bfs.saveFile(file));
		} else {
			dto.setImageFileName("nan");
		}
		
		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String msg, url;
		if(result == 1) {
			msg = "새글이 등록 되었습니다..";
			url = "/board/boardAllList";
		} else {
			msg = "문제가 발생했습니다..";
			url = "/cafe/cafemanager";
		}
		return bfs.getMessage(request, msg, url);
		
	}


	public void boardAllList(Model model, int num) {
		int pageLetter = 3; // 한 페이지당 글 목록수
		int allCount = mapper.selectBoardCount(); // 전체 글수
		// 마지막 페이지 번호
		int repeat = allCount / pageLetter;
		if(allCount % pageLetter != 0)
			repeat += 1;
		
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		
		model.addAttribute("repeat", repeat);
		model.addAttribute("boardList", mapper.boardAllList(start, end));
	}


	@Override
	public void contentView(int cafe_no, Model model) {
		model.addAttribute("data", mapper.contentView(cafe_no));
		upHit(cafe_no);
	}

	private void upHit(int cafe_no) {
		mapper.upHit(cafe_no);
	}

	@Override
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setWrite_no(Integer.parseInt(mul.getParameter("cafe_no")));
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		
		MultipartFile file = mul.getFile("imageFileName");
		if(file.getSize()!=0) { // 이미지 변경시
			dto.setImageFileName(bfs.saveFile(file));
			bfs.deleteImage(mul.getParameter("originFileName"));
		} else {
			dto.setImageFileName(mul.getParameter("originFileName"));
		}

		int result = mapper.modify(dto);
		
		String msg, url;
		if(result == 1) {
			msg = "내용이 변경 되었습니다...";
			url = "/board/boardAllList";
		} else {
			msg = "수정 오류입니다...";
			url = "/board/modify_form?cafe_no="+dto.getWrite_no();
		}
		return bfs.getMessage(request, msg, url);
	}

	@Override
	public String boardDelete(int writeNo, String imageFileName, HttpServletRequest request) {
		int result = mapper.delete(writeNo);
		String msg, url;
		if(result == 1) {
			msg="삭제 되었습니다..";
			url="/board/boardAllList";
			bfs.deleteImage(imageFileName);
		} else {
			msg = "삭제 오류~";
			url = "/board/contentView?writeNo="+writeNo;
		}
		return bfs.getMessage(request, msg, url);
	}
}
