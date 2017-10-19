package com.example;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Service
@Component
public class userService  {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;





    @Transactional
    public void registerAdmin(String custid,String username, String orgname,String password) {
        User user = new User(custid,username,orgname, passwordEncoder.encode(password));
        //user.setAdmin(true);
        repository.save(user);
    }

    @Transactional
    public void registerUser(String custid,String username,String orgname,String password) {
        User user = new User(custid,username, orgname, passwordEncoder.encode(password));
        repository.save(user);
    }

}