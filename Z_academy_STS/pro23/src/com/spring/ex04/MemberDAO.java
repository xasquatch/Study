package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
	SQLMapConfig.xml������ �̿��� SQLMapper��ü�� �����մϴ�.
	selectAllMemberList�޼ҵ带 ȣ���ϸ鼭 ���ڷ�
	mapper.member.selectAllMemberList�� �����Ͽ�
	member.xml�� �ش� ���ӽ����̽��� id�Ӽ��� �ش��ϴ� �±��� SQL���� ����	
*/
public class MemberDAO {

	private static SqlSessionFactory sqlMapper = null;
	
	private static SqlSessionFactory getInstance() {
		
		if (sqlMapper == null) {
			try {
/*
MemberDAO�� ���޼ҵ� ȣ��� src/mybatis/SqlMapConfig.xml����
���������� ���� �� �����ͺ��̽��� ������ �غ��մϴ�
*/
				String resource = "mybatis/SqlMapConfig.xml";
				/* Reader:java.io��Ű��, Resources:����ġ ibatis��Ű�� */

				//���̹�Ƽ���� �̿��ϴ� SqlSessionFactory(sqlMapper)��ü�� �����ɴϴ�.
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
		//�������� ���ڵ带 ��ȸ�ϹǷ� selectList()�޼ҵ忡 �����ϰ��� �ϴ� sql���� id�� ���ڷ� ����
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

	public int insertMember(MemberVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		int result = session.insert("mapper.member.insertMember",vo);
		
		//insert�� Ŀ�� �ʼ�
		session.commit();
		
		return result;
	}

	public int insertMember2(Map<String, String> memberMap) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession(); 
		
		int result = session.insert("mapper.member.insertMember2",memberMap);
		
		session.commit();
		
		return result;
	}

	public int updateMember(MemberVO vo) {
		int result = 0;		
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.update("mapper.member.updateMember",vo);
		
		session.commit();
		
		return result;
	}

	public int deleteMember(String id) {
		int result = 0;		
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.delete("mapper.member.deleteMember", id);

		session.commit();
		
		return result;
	}

	public List searchMember(MemberVO vo) {
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List list = session.selectList("mapper.member.searchMember",vo);
		
		return list;
	}

	public List<MemberVO> foreachSelect(String name) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<MemberVO> list = session.selectList("mapper.member.foreachSelect", name);
		
		return list;
		
	}

	public int foreachInsert(List<MemberVO> memList) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.insert("mapper.member.foreachInsert",memList);
		
		session.commit();
		
		return result;
	}

}
