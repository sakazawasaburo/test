package com.example;

import javax.validation.constraints.Size;


public class SignupForm {

	@Size(min=1, max=300)
	private int no;

	@Size(min=3, max=30)
    private String custid;

    @Size(min=3, max=30)
    private String custname;

    @Size(min=5, max=255)
    private String orgname;

    @Size(min=8, max=255)
    private String password;

    @Size(min=1, max=5)
    private String role;

    @Size(min=3, max=10)
    private String reserve;


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }


}