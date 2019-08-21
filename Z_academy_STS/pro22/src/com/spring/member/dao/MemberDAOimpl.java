package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAOimpl implements MemberDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List selectAllMembers() throws DataAccessException {

		String sql = "SELECT id, pwd, name, email, joinDate FROM t_member ORDER BY joindate DESC";

		List memberlist = null;

		memberlist = jdbcTemplate.query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {

				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joindate"));

				return vo;

			}

		});

		return memberlist;
	}

	@Override
	public int addMember(MemberVO vo) throws DataAccessException {
		return 0;
	}

}
