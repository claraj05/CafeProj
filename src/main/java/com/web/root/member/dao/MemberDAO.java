package com.web.root.member.dao;


import org.springframework.beans.factory.annotation.Autowired;

import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.member.MemberMapper;

public class MemberDAO {
	

	@Autowired
	private MemberMapper mapper;
	

	// id 중복 확인
	public int id_check(String id) {
		try {
			MemberDTO dto = mapper.id_check(id);
			if(dto==null) {
				return 0; //아이디 없을 때 0 사용 가능
			}else {
				return 1;//아이디 있을 떄 1 사용 불가
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2; //아예 작동 안할 때 2
	}
	

	
}















