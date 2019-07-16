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

	/* SQL���� ���� �����ų �� �ִ� �޼ҵ带 ������ �ִ� ������ �����ӿ�ũ���� �������ִ� ��ü�� ������ ���� */
	SimpleJdbcTemplate template;

	/*
	 * ����: shopping-servlet.xml�� �������踦 �̿��Ͽ� <bean id="shoppingDAO"
	 * class="model.ShoppingDAO" p:dataSource-ref="dataSource"/>��� ����� �س��ұ� ������ Ŀ�ؼ�Ǯ
	 * ��ü�� ������ ������ ���� �� ���̴�.
	 */

	/*
	 * private DriverManagerDataSource datasource;
	 * 
	 * public DriverManagerDataSource getDatasource() { return datasource; }
	 * 
	 * public void setDatasource(DriverManagerDataSource datasource) {
	 * this.datasource = datasource; }
	 */

	/* ���� : ��������� p:dataSource-ref �����߿��� dataSource�̸��� ���� �����̸����� �����ؾ��� */
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		template = new SimpleJdbcTemplate(dataSource);

	}
/*
	// DB�κ��� ��� ���۾����� �˻� �޼ҵ�
	public List<SuBean> getAllSutool() {

		
//		������ ���
//		1. ��� ���۾����� �˻��� SQL���� �����
		
		String sql = "SELECT * FROM sutool";
		
		
		
		List list = new ArrayList();
		
//		SimplejdbcTemplateŬ������ query()�޼ҵ� ȣ���
//		���ڷ� SELECT���� ������ ��ȸ�� ���ڵ��� ������ŭ SuBean��ü�� ������
		list = template.query(sql, new RowMapper() {
		
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				SuBean suBean = new SuBean();

				suBean.setSuno(rs.getInt("SUNO"));
				suBean.setSuname(rs.getString("SUNAME"));
				suBean.setSuinfo(rs.getString("SUINFO"));
				suBean.setSuimg(rs.getString("SUIMG"));
				suBean.setSuprice(rs.getInt("SUPRICE"));
				suBean.setSudate(rs.getDate("SUDATE"));
				suBean.setSutemp(rs.getString("SUTEMP"));
				suBean.setSucategory(rs.getString("SUCATEGORY"));
				
				
				
				return suBean;
			}
			
		});
		
		setDataSource(dataSource);

		return list;
	}
*/
	//�ٸ� ���
	public List<SuBean> getAllSutool() {

		String sql = "SELECT * FROM sutool";
		
		//BeanPropertyRowMapper����
		//SuBeanŬ������ ������� DB�� SUTOOL���̺��� �÷����� ��Ī�ϴ� ������ �ϴ� Ŭ����
		
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		//template��ü�� �̿��Ͽ� ������ �����ų ��
		//query()�޼ҵ忡 ������ SELECT������ DB�� SUTOOL���̺��� �÷���� ��Ī�� ��ü�� �����Ͽ�
		//�˻��� ����� ���ڵ� ������ŭ list�� ��Ƽ� list��ü�� ��������
		//���� ���Ϲ��� list�� �Ǵٽ� getAllSutool()�޼ҵ带 ȣ���� ������ ��ȯ��
		return template.query(sql, rm);
	}
}
