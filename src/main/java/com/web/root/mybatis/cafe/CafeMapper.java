package com.web.root.mybatis.cafe;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.EventViewDTO;

public interface CafeMapper {

//	public List<CafeDTO> cafeAllList();
	public List<CafeDTO> cafeAllList(@Param("s") int start, @Param("e") int end);
	public int selectcafeCount();
	public List<CafeDTO> getlocationList(@Param("locationList") String [] locationList,
			@Param("kidszone")String kidszone,
			@Param("petzone") String petzone,
			@Param("star")String star);
	public int[] eventCafe();
	public List<EventViewDTO> eventView1();
	public List<EventViewDTO> eventView2();
	public List<EventViewDTO> eventView3();
	public List<EventViewDTO> eventView4();
	
	public CafeDTO cafeInfo(int cafe_no);
	public int writeSave(CafeDTO dto);
	
	public int selectNo(CafeDTO dto);
	
	public int writeSave2(int cafe_no, String imgLoaction, String imgName, String fileContent);
}
