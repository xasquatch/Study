package com.spring.myapp.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.myapp.member.vo.MemberVO;


public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 

}
