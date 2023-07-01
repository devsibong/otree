package com.otree.douzone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private HttpSession session;
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute OtreeUser otreeUser, Model model) {
    	String email = otreeUser.getEmail();
    	String password = otreeUser.getPassword();
        boolean isUser = memberService.login(email, password);
        if (isUser) {
        	session.setAttribute("userEmail", otreeUser.getEmail());
            return "redirect:/workspace";
        } else {
            model.addAttribute("errorMessage", "Invalid credentials");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout() {
    	session.invalidate();
        return "redirect:/login";
    }
}
