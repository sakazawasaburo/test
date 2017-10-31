package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ElementCollection;
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
@Table(name="userdata")
public class User {

	private static final long serialVersionUID = 1L;


    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no",nullable = false)
    private int no;

    @Id
    @Column(name = "custid",nullable = false, unique = true)
    private String custid;

    @Column(name = "custname",nullable = false, unique = true)
    private String custname;

    @Column(name = "orgname",nullable = false, unique = true)
    private String orgname;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "reserve",nullable = false)
    private String reserve;


    // JPA requirement
    protected User() {}

    public User(int no,String custid, String custname, String orgname, String password ,String role,String reserve) {
    	this.no = no;
    	this.custid = custid;
    	this.custname = custname;
    	this.orgname = orgname;
        this.password = password;
        this.role = role;
        this.reserve = reserve;
    }


    //@Override
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

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

    //@Override
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //@Override
    public String getReserve() {
        return role;
    }
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

}