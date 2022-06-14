package com.web.root.mybatis.board;


import com.web.root.cafe.dto.CafeDTO;



public interface BoardMapper {
	
	/*
	 * public List<BoardDTO> boardAllList(@Param("s") int start, @Param("e") int
	 * end);
	 */
	public int writeSave(CafeDTO dto);
	/*
	 * public BoardDTO contentView(int writeNo);
	 * 
	 * public void upHit(int writeNo);
	 * 
	 * public int modify(BoardDTO dto);
	 * 
	 * public int delete(int writeNo);
	 * 
	 * public int selectBoardCount();
	 */
	
}
