/*package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "custid",nullable = false, unique = true)
    private String custid;

    @Column(name = "custname",nullable = false, unique = true)
    private String custname;

    @Column(name = "orgname",nullable = false, unique = true)
    private String orgname;

    @Column(name = "password",nullable = false)
    private String password;

/*
    // JPA requirement
    protected User() {}

    public User(String custid, String custname, String orgname,  String password ) {
    	this.custid = custid;
    	this.custname = custname;
    	this.orgname = orgname;
        this.password = password;
        //this.enabled = true;
        //this.authorities = EnumSet.of(Authority.ROLE_USER);
    }
*/
/*
    //@Override
    public String getCustid() {
        return custid;
    }
    public void setCustid(String custid) {
        this.custid = custid;
    }

    //@Override
    public String getCustname() {
        return custname;
    }
    public void setCustname(String custname) {
        this.custname = custname;
    }

    //@Override
    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    //@Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

*/
