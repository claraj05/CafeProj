package com.web.root.mybatis.cafe;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.EventViewDTO;
import com.web.root.cafe.upload.dto.UploadDTO;

public interface CafeMapper {

	public List<CafeDTO> searchEng(String searchKW);
	public List<CafeDTO> cafeAllList(@Param("s") int start, @Param("e") int end);
	
	public List<UploadDTO> cafeImageLoad();
	public String getImgRoot(int cafe_no);
	public String[] getImage(int cafe_no);

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
	
	public int checkLike(String id,int cafe_no);
	public int plusLike(String id, int cafe_no);
	public int minusLike(String id, int cafe_no);
	public int countplus(int cafe_no);
	public int countminus(int cafe_no);
	
	public CafeDTO cafeInfo(int cafe_no);
	
	
	public int writeSave(CafeDTO dto);
	
	public Integer selectNo(CafeDTO dto);
	
	public int writeSave2(String imgLocation, String imgName, String imgContent);
}
