<<<<<<< HEAD
package com.web.root.mybatis.board;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.web.root.board.dto.BoardDTO;
import com.web.root.board.dto.BoardImageDTO;

public interface BoardMapper {

	public void boardWrite(BoardDTO dto);
	
	public void boardWriteImage(String imageFileName1, String imageFileName2, String imageFileName3);
	
	public ArrayList<BoardDTO> boardList(@Param("s") int startLetter, @Param("e") int endLetter);
	
	public BoardDTO boardView(int write_no);
	
	public BoardImageDTO boardImageView(int write_no);
	
	public void boardModify(BoardDTO dto);
	
	public void boardDelete(int write_no);
	
	public void upHit(int write_no);
	
	public void seqDelete();
	
	public void seqCreate(@Param("start") int seqStart);
	
	public int boardCount();
	
	public int boardCountByTitle(@Param("title") String search);
	public int boardCountByContent(@Param("content") String search);
	public int boardCountById(@Param("id") String search);
	
	public int boardNoDown(int write_no);	
	public int boardImageNoDown(int write_no);
	public int boardLikeNoDown(int write_no);
	
	public void boardImageFkDrop();	
	public void boardImageFkAdd();
	
	public void boardLikeFkDrop();	
	public void boardLikeFkAdd();
	
	public ArrayList<BoardDTO> boardSearchByTitle(@Param("title") String search, @Param("s") int startLetter, @Param("e") int endLetter);
	public ArrayList<BoardDTO> boardSearchByContent(@Param("content") String search, @Param("s") int startLetter, @Param("e") int endLetter);
	public ArrayList<BoardDTO> boardSearchById(@Param("id") String search, @Param("s") int startLetter, @Param("e") int endLetter);
	
	public int likeCheck(int write_no, String id);
	
	public void likeMinus(int write_no, String id);
	public void likePlus(int write_no, String id);
	
	public void likeCountMinus(int write_no);
	public void likeCountPlus(int write_no);
}
















=======
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
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
