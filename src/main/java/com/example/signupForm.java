package com.example;

import lombok.Data;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class signupForm{

	@Size(min=8, max=255)
    private String custid;

	@Size(min=3, max=32)
    private String username;

	@Size(min=8, max=255)
    private String orgname;

	@Size(min=8, max=255)
    private String password;

}
