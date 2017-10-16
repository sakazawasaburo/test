package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    public enum Authority {ROLE_USER, ROLE_ADMIN}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false, unique = true)
    private String custid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String orgname;

    @Column(nullable = false)
    private String password;



    @Column(nullable = false)
    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<Authority> authorities;

    // JPA requirement
    protected User() {}

    public User(String custid, String username, String orgname,  String password ) {
    	this.custid = custid;
    	this.username = username;
    	this.orgname = orgname;
        this.password = password;

        this.enabled = true;
        this.authorities = EnumSet.of(Authority.ROLE_USER);
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    public boolean isAdmin() {
        return this.authorities.contains(Authority.ROLE_ADMIN);
    }

    public void setAdmin(boolean isAdmin) {
        if (isAdmin) {
            this.authorities.add(Authority.ROLE_ADMIN);
        } else {
            this.authorities.remove(Authority.ROLE_ADMIN);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : this.authorities) {
            authorities.add(new SimpleGrantedAuthority(authority.toString()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }




    @Override
    public String getCustid() {
        return custid;
    }
    public void setCustid(String custid) {
        this.custid = custid;
    }

    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }



    public Date getCreatedAt() {
        return createdAt;
    }

}
