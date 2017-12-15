package com.sts.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sts.springboot.dao.AuthUser;
import com.sts.springboot.dao.Users;
import com.sts.springboot.mapper.MstUsersMapper;
import com.sts.springboot.mapper.UsersMapper;

@Service
public class AuthUserService implements UserDetailsService{

	@Autowired
	UsersMapper usersMapper;
	@Autowired
	MstUsersMapper mstUsersMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users =mstUsersMapper.selectByPrimaryKey(username);
		if(users == null) {
			throw new UsernameNotFoundException("User not found for name:"+username);
		}
		return new AuthUser(users);
	}
	public String getAllAuthority(String loginId ){
		//Map<String,String> authKindMap = new HashMap<String,String>();
		String auth = usersMapper.selectAllAuthority(loginId); 
		return auth;
	}
		
}
