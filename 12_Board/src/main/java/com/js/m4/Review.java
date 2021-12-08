package com.js.m4;

import java.sql.Date;

public class Review {

	private int no;
	private String title;
	private String txt;
	private Date date;
	
	public Review() {}

	public Review(int r_no, String r_title, String r_txt, Date r_date) {
		super();
		this.no = r_no;
		this.title = r_title;
		this.txt = r_txt;
		this.date = r_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int r_no) {
		this.no = r_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String r_title) {
		this.title = r_title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String r_txt) {
		this.txt = r_txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date r_date) {
		this.date = r_date;
	}
		
}
