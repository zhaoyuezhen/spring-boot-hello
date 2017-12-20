package com.sts.springboot.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sts.springboot.dao.Users;

public class AuthUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String loginId;
	private String password;
	private String authorityKind;
	public AuthUser(Users users) {
		super();
		this.userId = users.getUserId();
		this.loginId = users.getLoginId();
		this.password = users.getPassword();
		this.authorityKind = users.getAuthorityKind();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority(authorityKind));
		return list;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
