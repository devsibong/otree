package com.otree.douzone.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.dto.Workspace;
import com.otree.douzone.service.MemberService;
import com.otree.douzone.service.WorkspaceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final WorkspaceService workspaceService;
    private final HttpSession session;
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute OtreeUser otreeUser, Model model) {
    	String path = "login";
    	String email = otreeUser.getEmail();
    	String password = otreeUser.getPassword();
        int isUser = memberService.login(email, password);
        if (isUser != -1) {
        	session.setAttribute("userId", isUser);
        	List<Workspace> workspaceList =  workspaceService.getWorkspaceList(isUser);
        	if (workspaceList != null && !workspaceList.isEmpty()) path = "redirect:/workspace/" + workspaceList.get(0).getWorkspaceId();
            else path = "redirect:/workspace/empty";
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
            path = "login";
        }
        
        
        return path;
    }
    
    @GetMapping("/logout")
    public String logout() {
    	session.invalidate();
        return "redirect:/login";
    }
}
