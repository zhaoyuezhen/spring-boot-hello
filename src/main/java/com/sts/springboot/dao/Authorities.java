package com.sts.springboot.dao;

public class Authorities {
	private String user_id;
	private String authority;
	private String permission_flag;
	private String create_user;
	private String create_date_time;
	private String update_date_time;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getPermission_flag() {
		return permission_flag;
	}
	public void setPermission_flag(String permission_flag) {
		this.permission_flag = permission_flag;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(String create_date_time) {
		this.create_date_time = create_date_time;
	}
	public String getUpdate_date_time() {
		return update_date_time;
	}
	public void setUpdate_date_time(String update_date_time) {
		this.update_date_time = update_date_time;
	}
}
