package com.web.root.mybatis.cafe;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeMapper {

	public List<CafeDTO> cafeAllList();
	 
	public List<CafeDTO> getlocationList(@Param("locationList") String [] locationList,
			@Param("kidszone")String kidszone,
			@Param("petzone") String petzone,
			@Param("star")String star);

	public List<CafeDTO> getlocationListA(int all,			
			@Param("kidszone")String kidszone,
			@Param("petzone") String petzone,
			@Param("star")String star);

}
