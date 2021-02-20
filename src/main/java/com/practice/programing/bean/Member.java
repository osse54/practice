package com.practice.programing.bean;

public class Member {
	private String m_id;
	private String m_pass;
	private String m_date;
	private boolean m_availability;
	public Member() {}
	public Member(String m_id, String m_pass) {
		setM_id(m_id);
		setM_pass(m_pass);
	}
	public Member(String m_id, String m_pass, String m_date) {
		setM_id(m_id);
		setM_pass(m_pass);
		setM_date(m_date);
	}
	public Member(String m_id, String m_pass, String m_date, boolean m_availability) {
		setM_id(m_id);
		setM_pass(m_pass);
		setM_date(m_date);
		setM_availability(m_availability);
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public boolean isM_availability() {
		return m_availability;
	}
	public void setM_availability(boolean m_availability) {
		this.m_availability = m_availability;
	}
}
