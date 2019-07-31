package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

//1.action-mybatis.xml설정파일에서 만든 SqlSessionFactoryBean빈을?
//sqlSession속성에 주입하기 위해 setter메소드를 구현 합니다.
//2. SqlSessionFactoryBean빈의 메소드들을 이용해 매퍼 파일(member.xml)에 정의된 SQL문을 사용합니다.
public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;

	//속성 sqlSession에 SqlSessionFactoryBean빈을 주입하기 위해 setter를 구현 합니다.
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		//주입된 SqlSessionFactoryBean빈으로 selectList()메소드를 호출하면서 
		//member.xml에 작성되어 있는 실행할 SELECT문이 속해 있는 <select>태그의 id속성값을 전달 합니다.
		//검색후 결과를 ArrayList로 반환 받습니다.
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		//주입된 SqlSessionFactoryBean빈으로 insert()메소드를 호출하면서 
		//member.xml에 작성되어 있는 실행할 insert문이 속해 있는 <insert>태그의 id속성값과 , MemberVO객체를 전달하여
		//매칭된 insert구문 실행후 그결과를 반환 받습니다.
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
	//주입된 SqlSessionFactoryBean빈으로 delete()메소드를 호출하면서 
	//member.xml에 작성되어 있는 실행할 delete문이 속해 있는 <delete>태그의 id속성값과,
	//삭제할 회원 ID를 전달하여 매칭된 delete구문 실행후 그결과를 반환 받습니다.
		int result =  sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
	
}