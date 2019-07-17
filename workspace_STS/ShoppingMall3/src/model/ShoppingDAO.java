package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

//클래스 역할 : 미리 연결된 데이터베이스에 쿼리를 실행하여 결과를 반환받아주는 클래스 
public class ShoppingDAO {

	//SQL문을 쉽게 실행시킬수 있는 메소드를 가지고 있는 스프링 프레임워크에서 제공해주는 객체를 
	//저장할 변수 
	SimpleJdbcTemplate template;
		
	//설명 : 
	//shopping-servlet.xml에 의존관계를 이용하여..
	//<bean id="shoppingDao" 
//			class="model.ShoppingDAO" 
//			p:dataSource-ref="dataSource">
	//라고..등록 해 놓았기 때문에..
	//커넥션풀 객체를 저장할 변수 선언 한것이다.
	DataSource dataSource;
	//참고 : 변수 선언시.. p:dataSoruce-ref 문장중에서.. 
	//      dataSource이름과 같은 변수이름으로 선언해야함	
	//setter메소드 
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		
		this.template = new SimpleJdbcTemplate(dataSource);		
	}
	
	//수작업공구 번호를 전달받아 검색하여 반환할 메소드 
	public SuBean getOneSutool(int suno) {
		
		String sql = "select * from sutool where suno=?";
		
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		//template객체를 이용하여 SELECT구문을 실행할떄..
		//queryForObject메소드에 실행할 SELECT문과, 
		//DB의 SUTOOL테이블의 컬럼명과 매칭한 객체를 전달,
		//?값 전달 하여...
		//검색한 결과는 SuBean객체를 반환 받는데 조상 Object타입으로 반환받는다.	
		return template.queryForObject(sql, rm, suno);
	}

	
	//SujakLeft.jsp 왼쪽 메뉴 화면에서  하나의 메뉴를 선택하여 전달받는 num에 해당하는
	//수작업 공구들을 모두 검색 하여 반환
	public List<SuBean> getSelectSutool(String num) {
		
		//SQL준비
		String sql = "select * from sutool where sucate=?";
		
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		return template.query(sql, rm, num);
	}
	
	
	//DB로부터 모든 수작업공구 검색 메소드 
	public List<SuBean> getAllSutool() {
		String sql = "select * from sutool";
		
		//BeanPropertyRowMapper클래스 역할 : 
		//SuBean클래스의 변수명과 DB의 SUTOOL테이블의 컬럼명을 매칭하는 역할을 하는 클래스 
		RowMapper<SuBean> rm = new BeanPropertyRowMapper<SuBean>(SuBean.class);
		
		//templeate객체를 이용하여 쿼리를 실행시킬때..
		//query()메소드에 실행할 SELECT문과 , DB의 SUTOOL테이블의 컬럼명과 매칭한 객체를 전달하여..
		//검색한 결과 레코드 갯수만큼 list에담아.. list자체를 리턴해준다..
		//또한  리턴받은 list를 또다시 getAllSutool()메소드를 호출할 곳으로 반환함.
		return template.query(sql, rm);
	}


	
	//DB로부터 모든 수작업공구 검색 메소드 
/*	
	public List<SuBean> getAllSutool() {		
		String sql = "select * from sutool";	
		List list = new ArrayList();	
		//SimpleJdbcTemplate클래스의 query()메소드 호출시..
		//인자로 select문을 전달해 조회한 레코드의 갯수만큼 SuBean객체를 생성함.
		//각 레코드의 값을 SuBean객체의 각 변수에 저장하고  다시 ArrayList에 추가합니다.
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
	}//getAllSutool()메소드끝		
	
	*/
}//ShoppingDAO클래스 끝





