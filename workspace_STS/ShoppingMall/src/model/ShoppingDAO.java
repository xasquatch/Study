package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

//클래스 역할 : 미리 연결된 데이터베이스의 쿼리를 실행하여 결과를 반환받아주는 클래스
public class ShoppingDAO {

	/* SQL문을 쉽게 실행시킬 수 있는 메소드를 가지고 있는 스프링 프레임워크에서 제공해주는 객체를 저장할 변수 */
	SimpleJdbcTemplate template;

	/*
	 * 설명: shopping-servlet.xml에 의존관계를 이용하여 <bean id="shoppingDAO"
	 * class="model.ShoppingDAO" p:dataSource-ref="dataSource"/>라고 등록을 해놓았기 때문에 커넥션풀
	 * 객체를 저장할 변수를 선언 한 것이다.
	 */

	/*
	 * private DriverManagerDataSource datasource;
	 * 
	 * public DriverManagerDataSource getDatasource() { return datasource; }
	 * 
	 * public void setDatasource(DriverManagerDataSource datasource) {
	 * this.datasource = datasource; }
	 */

	/* 참고 : 변수선언시 p:dataSource-ref 문장중에서 dataSource이름과 같은 변수이름으로 선언해야함 */
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		template = new SimpleJdbcTemplate(dataSource);

	}

	/*
	 * // DB로부터 모든 수작업공구 검색 메소드 public List<SuBean> getAllSutool() {
	 * 
	 * 
	 * // 스프링 방식 // 1. 모든 수작업공구 검색할 SQL문장 만들기
	 * 
	 * String sql = "SELECT * FROM sutool";
	 * 
	 * 
	 * 
	 * List list = new ArrayList();
	 * 
	 * // SimplejdbcTemplate클래스의 query()메소드 호출시 // 인자로 SELECT문을 전달해 조회한 레코드의 갯수만큼
	 * SuBean객체를 생성함 list = template.query(sql, new RowMapper() {
	 * 
	 * @Override public Object mapRow(ResultSet rs, int rowNum) throws SQLException
	 * {
	 * 
	 * SuBean suBean = new SuBean();
	 * 
	 * suBean.setSuno(rs.getInt("SUNO")); suBean.setSuname(rs.getString("SUNAME"));
	 * suBean.setSuinfo(rs.getString("SUINFO"));
	 * suBean.setSuimg(rs.getString("SUIMG"));
	 * suBean.setSuprice(rs.getInt("SUPRICE"));
	 * suBean.setSudate(rs.getDate("SUDATE"));
	 * suBean.setSutemp(rs.getString("SUTEMP"));
	 * suBean.setSucategory(rs.getString("SUCATEGORY"));
	 * 
	 * 
	 * 
	 * return suBean; }
	 * 
	 * });
	 * 
	 * setDataSource(dataSource);
	 * 
	 * return list; }
	 */
	// 다른 방법
	public List<SuBean> getAllSutool() {

		String sql = "SELECT * FROM sutool";

		// BeanPropertyRowMapper역할
		// SuBean클래스의 변수명과 DB의 SUTOOL테이블의 컬럼명을 매칭하는 역할을 하는 클래스

		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);

		// template객체를 이요하여 쿼리를 실행시킬 때
		// query()메소드에 실행할 SELECT구문과 DB의 SUTOOL테이블의 컬럼명과 매칭한 객체를 전달하여
		// 검색한 결과를 레코드 갯수만큼 list에 담아서 list자체를 리턴해줌
		// 또한 리턴받은 list를 또다시 getAllSutool()메소드를 호출할 곳으로 반환함
		return template.query(sql, rm);
	}

	// 수작업공구 번호를 전달받아 검색하여 반환할 메소드
	public SuBean getOneSutool(int suno) {

		String sql = "select * from sutool where suno=?";

		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);

		// template객체를 이용하여 SELECT구문을 실행할떄..
		// queryForObject메소드에 실행할 SELECT문과,
		// DB의 SUTOOL테이블의 컬럼명과 매칭한 객체를 전달,
		// ?값 전달 하여...
		// 검색한 결과는 SuBean객체를 반환 받는데 조상 Object타입으로 반환받는다.
		return template.queryForObject(sql, rm, suno);
	}

	public List<SuBean> getSelectSutool(String num) {

		String sql = "SELECT * FROM sutool WHERE sucategory = ?";

//		List list = new ArrayList();
//		
//		list = template.query(sql, new RowMapper() {
//
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//				SuBean suBean = new SuBean();
//
//				suBean.setSuno(rs.getInt("SUNO"));
//				suBean.setSuname(rs.getString("SUNAME"));
//				suBean.setSuinfo(rs.getString("SUINFO"));
//				suBean.setSuimg(rs.getString("SUIMG"));
//				suBean.setSuprice(rs.getInt("SUPRICE"));
//				suBean.setSudate(rs.getDate("SUDATE"));
//				suBean.setSutemp(rs.getString("SUTEMP"));
//				suBean.setSucategory(rs.getString("SUCATEGORY"));
//				
//				
//				
//				return suBean;
//
//			}
//			
//			
//		});

		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);

		return template.query(sql, rm, num);
	}

	public int getLogin(MemberBean mbean) {

		String sql = "SELECT COUNT(*) FROM member WHERE memid = ?";
/*
 * SELECT의 결과값으로 레코드 개수가 검색되며 1을 리턴하여 다시 getlogin()메소드를 호출한 곳으로 1을 리턴 그러나
 * select의 결과값으로 레코드 갯수가 검색되지 않으면 0을 리턴하여 다시 getlogin()메소드를 호출한 곳으로 0을 리턴
 */
		return template.queryForInt(sql, mbean.getMemid());
	}

	public void insertMember(MemberBean mbean) {
		
		String sql = "INSERT INTO member VALUES (:memid, :mempasswd1, :mempasswd2,"
											+ " :memname, :memphone, :memdate)";
		
		SqlParameterSource sqlSource = new BeanPropertySqlParameterSource(mbean);
		
		template.update(sql, sqlSource);
		
		
	}

	
	//loginForm.jsp페이지에서 작성한 아이디와 패스워드를 담은 memberbean객체를 매개변수로 전달받아
	//아이디와 패스워드에 해당하는 회원수를 검색하는데
	//검색에 성공하면 1, 실패하면 0을 반환
	public int getloginproc(MemberBean mbean) {
		
		String sql = "SELECT * FROM MEMBER WHRER memid = ?";
		
		return template.queryForInt(sql, mbean.getMemid(), mbean.getMempasswd1());
	}

}
