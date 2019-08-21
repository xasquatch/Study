package com.spring.ex01;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

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

}
