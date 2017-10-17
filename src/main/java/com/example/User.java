package com.example;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class User {

	 @Id
	 @Column(nullable = false)
	   private String custid;

	 @Column(nullable = false)
	   private String username;

	 @Column(nullable = false)
	   private String orgname;

	 @Column(nullable = false)
	   private String orgname;

	 @Column(nullable = false)
	   private String password;


}