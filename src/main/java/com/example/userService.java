package com.example;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


//import com.example.UserRepository;
import com.example.User;

@Service
@Component
public class userService{

    //@Autowired
    //private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;



    //@Transactional
    //public void registerUser(String custid,String username,String orgname,String password) {
        //User user = new User(custid,username, orgname, passwordEncoder.encode(password));
        //repository.save(user);
    @RequestMapping("/db")
        String db(Map<String, Object> model){
	        try (Connection connection = dataSource.getConnection()) {
	  	      Statement stmt = connection.createStatement();
	  	      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
	  	      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	  	      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

	  	      ArrayList<String> output = new ArrayList<String>();
	  	      while (rs.next()) {
	  	        output.add("Read from DB: " + rs.getTimestamp("tick"));
	  	      }

	  	      model.put("records", output);
	  	      return "db";
	  	    } catch (Exception e) {
	  	      model.put("message", e.getMessage());
	  	      return "error";
	  	    }

        }




        /*@Bean
    	public DataSource dataSource() throws SQLException {
    		if (dbUrl == null || dbUrl.isEmpty()) {
    			return new HikariDataSource();
    		} else {
    			HikariConfig config = new HikariConfig();
    			config.setJdbcUrl(dbUrl);
    			return new HikariDataSource(config);
    		}
    	}
    	*/

}
