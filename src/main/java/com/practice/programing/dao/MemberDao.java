package com.practice.programing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practice.programing.bean.Member;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	@Value("#{sql['member.insert']}")
	private String insert;
	@Value("#{sql['member.delete']}")
	private String delete;
	@Value("#{sql['member.update']}")
	private String update;
	@Value("#{sql['member.get']}")
	private String get;

	public int insert(String m_id, String m_pass) {
		return jdbcTmp.update(insert, m_id, m_pass);
	}
	public int delete(Member member) {
		return jdbcTmp.update(delete, member.getM_id());
	}
	public int update(Member member, String id) {
		return jdbcTmp.update(update, member.getM_id(), member.getM_pass(), member.isM_availability(), id);
	}
	public Member get(String m_id) {
		return jdbcTmp.queryForObject(get, new Object[]{m_id}, new MemberMapper());
	}
	class MemberMapper implements RowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Member(rs.getString("m_id"), rs.getString("m_pass"), rs.getString("m_date"), rs.getBoolean("m_availability"));
		}
	}
}
