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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import org.springframework.ui.Model;


@Controller
@SpringBootApplication
public class Main {

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

	/*@RequestMapping("/signup")
	String signup() {
		return "signup";
	}
	 */

/*
	@RequestMapping("/signup")
	//String signup(Map<String, Object> model){
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

			HttpSession session = request.getSession();
			/*String CUSTID = session.getAttribute("custid");
			String CUSTNAME = session.getAttribute("custname");
			String ORGNAME = session.getAttribute("orgname");
			String PASSWORD = session.getAttribute("password");
			 */
			//try (Connection connection = dataSource.getConnection()) {

				//Statement stmt = connection.createStatement();
				//stmt.executeUpdate("INSERT INTO userdata (no,custid, custname,orgname,password,role,reserve) VALUES (3,CUSTID,CUSTNAME,ORGNAME,PASSWORD,'1','ADMIN')");
				//session.invalidate();

				/*ResultSet rs = stmt.executeQuery("SELECT custid FROM userdata");
			ArrayList<String> output = new ArrayList<String>();
			while (rs.next()) {
				output.add("Read from DB: "+ rs.getString("orgname"));
			}

			model.put("records", output);*/

				//return "signup";
			/*} catch (Exception e) {
				//model.put("message", e.getMessage());
				//return "signup";
			}
		}*/
	//}

	@RequestMapping("/Account")
	String Account() {
		return "Account";
	}

	/*@RequestMapping("/db")
	String index() {
		return "db";
	}
	 */

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