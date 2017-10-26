package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User loadUserByUsername(String custname) throws UsernameNotFoundException {
        if (username == null || "".equals(custname)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        User user = repository.findByUsername(custname);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
    }


    @Transactional
    public void registerUser(int no,String custid,String custname,String orgname,String password,String role,String reserve) {
        User user = new User(no,custid,custname,orgname, passwordEncoder.encode(password),role,reserve);
        repository.save(user);
    }

}