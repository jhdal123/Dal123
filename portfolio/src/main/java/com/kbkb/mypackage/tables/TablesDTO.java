package com.kbkb.mypackage.tables;

public class TablesDTO {

	private int idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "TablesDTO [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + "]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
