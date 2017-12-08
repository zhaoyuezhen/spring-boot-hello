package com.sts.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sts.springboot.AuthUser;
import com.sts.springboot.dao.Users;
import com.sts.springboot.mapper.UsersMapper;

@Service
public class AuthUserService implements UserDetailsService{

	@Autowired
	UsersMapper usersMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users =usersMapper.selectByPrimaryKey(username);
		if(users == null) {
			throw new UsernameNotFoundException("User not found for name:"+username);
		}
		return new AuthUser(users);
	}
		
}
