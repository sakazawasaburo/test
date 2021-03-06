package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Controller;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.Valid;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



@Controller
@SpringBootApplication
public class Main{


	//@Autowired
	//UserService userService;

	@Autowired
    private UserRepository repository;


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	@RequestMapping({"/","/login"})
	public void signup(){
		User user = new User(5,"abcdefg","すいか太郎","行政システム","hijklmn","1","ADMIN");
	    repository.save(user);
	}




/*
	@RequestMapping("/signup")
	public void signup(){
		User user = new User(5,"abcdefg","すいか太郎","行政システム","hijklmn","1","ADMIN");
	    repository.save(user);
	}
*/

/*
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(Model model, @Valid SignupForm signupForm, BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "signup";
		}

		try {
			userService.registerUser(signupForm.getNo(),signupForm.getCustid(),signupForm.getCustname(),signupForm.getOrgname(),signupForm.getPassword(),signupForm.getRole(),signupForm.getReserve());
		} catch (DataIntegrityViolationException e) {
			return "signup";
		}

		return "signup";
	}

*/

}