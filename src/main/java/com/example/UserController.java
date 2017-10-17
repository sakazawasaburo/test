package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    userService userservice;


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupform", new signupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(Model model, @Valid signupForm signupform, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            userservice.registerUser(signupform.getCustid(),signupform.getUsername(), signupform.getOrgname(),signupform.getPassword());
        }catch (DataIntegrityViolationException e) {
            //model.addAttribute("signupError", true);
        	e.printStackTrace();
            return "signup";
         }

        return "signup";
    }




}

