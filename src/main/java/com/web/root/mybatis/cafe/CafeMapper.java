package com.web.root.mybatis.cafe;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.EventViewDTO;
import com.web.root.cafe.upload.dto.UploadDTO;

public interface CafeMapper {

	public List<CafeDTO> searchEng(String searchKW,@Param("s") int start, @Param("e") int end );
	public List<CafeDTO> searchEngS(String searchKW,@Param("s") int start, @Param("e") int end );
	public Integer searchEngCount(String searchKW);
	public List<CafeDTO> cafeAllList(@Param("s") int start, @Param("e") int end);
	public List<CafeDTO> cafeAllListS(@Param("s") int start, @Param("e") int end);

	public int cafeWrite(CafeDTO dto); //cafe table저장
	public int cafeImgSave(int cafe_no, String imgContent, String imgName, String imgLocation);
	public List<UploadDTO> findCafeImage(int cafe_no);
	public int selectcafeCount();

	public List<CafeDTO> getlocationList(@Param("locationList") String[] locationList,
			@Param("kidszone") String kidszone, @Param("petzone") String petzone, @Param("star") String star,
			@Param("s") int start, @Param("e") int end);
	public Integer searchCafeCount(@Param("locationList") String[] locationList,
			@Param("kidszone") String kidszone, @Param("petzone") String petzone, @Param("star") String star);

	public int[] eventCafe();

	public EventViewDTO eventView1();

	public EventViewDTO eventView2();

	public EventViewDTO eventView3();

	public EventViewDTO eventView4();

	public int selectCheck(int cafe_no, String id);

	public void selectMinus(int cafe_no, String id);

	public void selectPlus(int cafe_no, String id);

	public void selectCountMinus(int cafe_no);

	public void selectCountPlus(int cafe_no);

	public CafeDTO cafeInfo(Integer cafe_no);

	public int writeSave(CafeDTO dto);

	public Integer selectNo(CafeDTO dto);
	
	public List<CafeDTO> getSelectList(String id, @Param("s") int start, @Param("e") int end);
	public int selectLikeCount(String id);
	public int updateAvgStar(double avg,int cafe_no);
	
	public List<CafeDTO> recommandCafe();
}
