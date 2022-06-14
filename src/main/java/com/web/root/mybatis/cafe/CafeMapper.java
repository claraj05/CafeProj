package com.web.root.mybatis.cafe;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.web.root.cafe.dto.CafeDTO;

public interface CafeMapper {

	public List<CafeDTO> cafeAllList();
	 
	public List<CafeDTO> getlocationList(@Param("locationList") String [] locationList,
			@Param("kidszone")String kidszone,
			@Param("petzone") String petzone,
			@Param("star")String star);
<<<<<<< HEAD

	public List<CafeDTO> getlocationListA(int all,			
			@Param("kidszone")String kidszone,
			@Param("petzone") String petzone,
			@Param("star")String star);

=======
	 
	public List<CafeDTO> cafeAllList();
	
	public int writeSave(CafeDTO dto);
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
}
