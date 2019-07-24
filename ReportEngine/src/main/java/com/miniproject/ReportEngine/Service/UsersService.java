package com.miniproject.ReportEngine.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miniproject.ReportEngine.Model.Users;
import com.miniproject.ReportEngine.Repo.RepoUser;



@Service
public class UsersService implements UserDetailsService{
	
	@Autowired
	RepoUser repoUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user = repoUser.findByUsername(username);
		
		if (user != null) {

			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

			return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));

		}else {

			throw new UsernameNotFoundException("User not found");

		}
	}

}
