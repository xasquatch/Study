package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

//Ŭ���� ���� : �̸� ����� �����ͺ��̽��� ������ �����Ͽ� ����� ��ȯ�޾��ִ� Ŭ���� 
public class ShoppingDAO {

	//SQL���� ���� �����ų�� �ִ� �޼ҵ带 ������ �ִ� ������ �����ӿ�ũ���� �������ִ� ��ü�� 
	//������ ���� 
	SimpleJdbcTemplate template;
		
	//���� : 
	//shopping-servlet.xml�� �������踦 �̿��Ͽ�..
	//<bean id="shoppingDao" 
//			class="model.ShoppingDAO" 
//			p:dataSource-ref="dataSource">
	//���..��� �� ���ұ� ������..
	//Ŀ�ؼ�Ǯ ��ü�� ������ ���� ���� �Ѱ��̴�.
	DataSource dataSource;
	//���� : ���� �����.. p:dataSoruce-ref �����߿���.. 
	//      dataSource�̸��� ���� �����̸����� �����ؾ���	
	//setter�޼ҵ� 
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		
		this.template = new SimpleJdbcTemplate(dataSource);		
	}
	
	//���۾����� ��ȣ�� ���޹޾� �˻��Ͽ� ��ȯ�� �޼ҵ� 
	public SuBean getOneSutool(int suno) {
		
		String sql = "select * from sutool where suno=?";
		
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		//template��ü�� �̿��Ͽ� SELECT������ �����ҋ�..
		//queryForObject�޼ҵ忡 ������ SELECT����, 
		//DB�� SUTOOL���̺��� �÷���� ��Ī�� ��ü�� ����,
		//?�� ���� �Ͽ�...
		//�˻��� ����� SuBean��ü�� ��ȯ �޴µ� ���� ObjectŸ������ ��ȯ�޴´�.	
		return template.queryForObject(sql, rm, suno);
	}

	
	//SujakLeft.jsp ���� �޴� ȭ�鿡��  �ϳ��� �޴��� �����Ͽ� ���޹޴� num�� �ش��ϴ�
	//���۾� �������� ��� �˻� �Ͽ� ��ȯ
	public List<SuBean> getSelectSutool(String num) {
		
		//SQL�غ�
		String sql = "select * from sutool where sucate=?";
		
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm, num);
	}
	
	
	//DB�κ��� ��� ���۾����� �˻� �޼ҵ� 
	public List<SuBean> getAllSutool() {
		String sql = "select * from sutool";
		
		//BeanPropertyRowMapperŬ���� ���� : 
		//SuBeanŬ������ ������� DB�� SUTOOL���̺��� �÷����� ��Ī�ϴ� ������ �ϴ� Ŭ���� 
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		//templeate��ü�� �̿��Ͽ� ������ �����ų��..
		//query()�޼ҵ忡 ������ SELECT���� , DB�� SUTOOL���̺��� �÷���� ��Ī�� ��ü�� �����Ͽ�..
		//�˻��� ��� ���ڵ� ������ŭ list�����.. list��ü�� �������ش�..
		//����  ���Ϲ��� list�� �Ǵٽ� getAllSutool()�޼ҵ带 ȣ���� ������ ��ȯ��.
		return template.query(sql, rm);
	}


	
	//DB�κ��� ��� ���۾����� �˻� �޼ҵ� 
/*	
	public List<SuBean> getAllSutool() {		
		String sql = "select * from sutool";	
		List list = new ArrayList();	
		//SimpleJdbcTemplateŬ������ query()�޼ҵ� ȣ���..
		//���ڷ� select���� ������ ��ȸ�� ���ڵ��� ������ŭ SuBean��ü�� ������.
		//�� ���ڵ��� ���� SuBean��ü�� �� ������ �����ϰ�  �ٽ� ArrayList�� �߰��մϴ�.
	   list = this.template.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {				
				SuBean suBean = new SuBean();
				suBean.setSucate(rs.getString("SUCATEGORY"));
				suBean.setSudate(rs.getDate("SUDATE"));
				suBean.setSuimg(rs.getString("SUIMG"));
				suBean.setSuinfo(rs.getString("SUINFO"));
				suBean.setSuname(rs.getString("SUNAME"));
				suBean.setSuno(rs.getInt("SUNO"));
				suBean.setSuprice(rs.getInt("SUPRICE"));
				suBean.setSutemp(rs.getString("SUTEMP"));			
				return suBean;
			}		
		});	
		return list;
	}//getAllSutool()�޼ҵ峡		
	
	*/
}//ShoppingDAOŬ���� ��





