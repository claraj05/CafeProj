package com.web.root.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class boardController {

	@GetMapping("boardList")
	public String boardList() {
		return "board/boardList";
	}
}
