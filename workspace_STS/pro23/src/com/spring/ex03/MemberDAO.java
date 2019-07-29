package com.spring.ex03;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
	SQLMapConfig.xml파일을 이용해 SQLMapper객체를 생성합니다.
	selectAllMemberList메소드를 호출하면서 인자로
	mapper.member.selectAllMemberList를 전달하여
	member.xml에 해당 네임스페이스와 id속성에 해당하는 태그의 SQL문을 실행	
*/
public class MemberDAO {

	private static SqlSessionFactory sqlMapper = null;
	
	private static SqlSessionFactory getInstance() {
		
		if (sqlMapper == null) {
			try {
/*
MemberDAO의 각메소드 호출시 src/mybatis/SqlMapConfig.xml에서
설정정보를 읽은 후 데이터베이스와 연동을 준비합니다
*/
				String resource = "mybatis/SqlMapConfig.xml";
				/* Reader:java.io패키지, Resources:아파치 ibatis패키지 */

				//마이바티스를 이용하는 SqlSessionFactory(sqlMapper)객체를 가져옵니다.
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
//				InputStream inputStream = Resources.getResourceAsStream(resource);
//				sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
				
			} catch (Exception e) {e.printStackTrace();}
		}
		return sqlMapper;
	}

	
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		List<MemberVO> memlist = null;
		//여러개의 레코드를 조회하므로 selectList()메소드에 실행하고자 하는 sql문의 id를 인자로 전달
		memlist = session.selectList("mapper.member.selectAllMemberList");
		
		return memlist;
	}
	
	public String selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		String name = session.selectOne("mapper.member.selectName");
		
		return name;
	}
	
	public int selectPwd() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		int pwd = session.selectOne("mapper.member.selectPwd");
		
		return pwd;
	}



	public MemberVO selectMemberById(String value) {
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		MemberVO vo = session.selectOne("mapper.member.selectMemberById",value);
		
		return vo;
	}
	
	public List<MemberVO> selectMemberByPwd(String value_) {
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		int value = Integer.parseInt(value_);
		
		List<MemberVO> memberList = session.selectList("mapper.member.selectMemberByPwd",value);
		
		return memberList;
	}

}
