package com.DoAn.DoAnTotNghiep.Security.service;

import com.DoAn.DoAnTotNghiep.Entity.Account;
import com.DoAn.DoAnTotNghiep.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	AccountRepository accReposity;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Account> user = accReposity.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found "+ email));
		return user.map(MyUserDetails::new).get();
	}
	
}
