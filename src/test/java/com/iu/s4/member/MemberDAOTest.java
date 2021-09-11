package com.iu.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.MyJunitTest;


public class MemberDAOTest extends MyJunitTest{

	@Autowired
	private MemberDAO memberDAO;
	
	
	@Test
	public void setJoin() throws Exception{
		MemberDTO dto = new MemberDTO();
		dto.setId("t11");
		dto.setPw("t11");
		dto.setName("t11");
		dto.setPhone("010-101");
		dto.setEmail("asd@asd");
		
		int result = memberDAO.setJoin(dto);
		
		assertNotEquals(0, result);
		
		
	}
	
	
	
	
	
	
	//@Test
	public void getIdCheckTest() throws Exception {
		
		MemberDTO dto = new MemberDTO();
		dto.setId("t1");
		
		dto = memberDAO.getIdCheck(dto);
		
		assertNotNull(dto);
		
		
		
	}

}
