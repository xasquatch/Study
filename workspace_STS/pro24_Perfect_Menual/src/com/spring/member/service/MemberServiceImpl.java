package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

/*@Transactional(propagation=Propagation.REQUIRED) */
public class MemberServiceImpl  implements MemberService{
	   
	private MemberDAO memberDAO;
	   
	   //위속성 memberDAO에 MemberDAOImpl빈을 주입하기 위해 setter메소드를 구현 함.
	   public void setMemberDAO(MemberDAO memberDAO){
	      this.memberDAO = memberDAO;
	   }

	   @Override
	   public List listMembers() throws DataAccessException {
	      List membersList = null;
	      membersList = memberDAO.selectAllMemberList();
	      return membersList;
	   }

	   @Override
	   public int addMember(MemberVO memberVO) throws DataAccessException {
	     return memberDAO.insertMember(memberVO);
	   }


	   @Override
	   public int removeMember(String id) throws DataAccessException {
	      return memberDAO.deleteMember(id);
	   }
}
