/*package com.example;

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
    UserService userService;

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


}
*/
