package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


/*
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
    }
*/


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
