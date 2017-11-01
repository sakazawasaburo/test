/*
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void registerUser(int no,String custid,String custname,String orgname,String password,String role,String reserve) {
        User user = new User(no,custid,custname,orgname, passwordEncoder.encode(password),role,reserve);
        repository.save(user);
    	//public void registerUser() {
    	//User user = new User(5,"abcdefg","すいか太郎","行政システム","hijklmn","1","ADMIN");

    }

}
*/