package com.otree.douzone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final HttpSession session;
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute OtreeUser otreeUser, Model model) {
    	String email = otreeUser.getEmail();
    	String password = otreeUser.getPassword();
        int isUser = memberService.login(email, password);
        if (isUser != -1) {
        	session.setAttribute("userId", isUser);
            return "redirect:/workspace";
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout() {
    	session.invalidate();
        return "redirect:/login";
    }
}
