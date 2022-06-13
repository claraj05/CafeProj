package com.web.root.mybatis.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.board.dto.BoardDTO;

public interface BoardMapper {
	
	public List<BoardDTO> boardAllList(@Param("s") int start, @Param("e") int end);
	public int writeSave(BoardDTO dto);
	
	public BoardDTO contentView(int writeNo);
	
	public void upHit(int writeNo);
	
	public int modify(BoardDTO dto);
	
	public int delete(int writeNo);
	
	public int selectBoardCount();
	
}
