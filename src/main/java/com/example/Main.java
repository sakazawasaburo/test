
package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@SpringBootApplication
public class Main extends HttpServlet{

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	@RequestMapping({"/","/login"})
	String login() {
		return "login";
	}

	@RequestMapping("/Home")
	String Home() {
		return "Home";
	}



	//String db(Map<String, Object> model){
	@RequestMapping(value ="/signup", method = RequestMethod.POST)
	public Map<String, String> post(
			HttpServletRequest request) {
		/*Map<String, String> map = new HashMap<>();
		map.put("parameter1", request.getParameter("parameter1"));
		map.put("parameter2", request.getParameter("parameter2"));
		map.put("parameter3", request.getParameter("parameter3"));
		map.put("parameter4", request.getParameter("parameter4"));
		*/

		String CUSTID = request.getParameter("parameter1");
		String CUSTNAME = request.getParameter("parameter2");
		String ORGNAME = request.getParameter("parameter3");
		String PASSWORD = request.getParameter("parameter4");

		//String signup(){
		try (Connection connection = dataSource.getConnection()) {
			Statement stmt = connection.createStatement();
			//stmt.executeUpdate("INSERT INTO userdata (no,custid, custname,orgname,password,role,reserve) VALUES (3,'1234567','すいか太郎','行政システム' ,'password','1','ADMIN')");
			stmt.executeUpdate("INSERT INTO userdata (no,custid, custname,orgname,password,role,reserve) VALUES (3,'CUSTID','CUSTNAME','ORGNAME','PASSWORD','1','ADMIN')");
			//return "signup";
		} catch (Exception e) {
			//model.put("message", e.getMessage());
			//return "signup";
		}
		return "signup";
	}


	@RequestMapping("/Account")
	String Account() {
		return "Account";
	}


	@RequestMapping("/logview")
	String logview() {
		return "logview";
	}


	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}
}