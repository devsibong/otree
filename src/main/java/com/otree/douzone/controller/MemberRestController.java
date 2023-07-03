package com.otree.douzone.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.service.EmailService;
import com.otree.douzone.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberRestController {
    private final MemberService memberService;
    private final EmailService emailService;
    private final HttpSession session;
    
    @GetMapping("")
    public ResponseEntity<OtreeUser> getMember() {
        int userId = (int) session.getAttribute("userId");
        OtreeUser otreeUser = memberService.getOtreeUserById(userId);
        return ResponseEntity.ok(otreeUser);
    }
    
    @PostMapping("/email")
    public ResponseEntity<Integer> sendEmail(@RequestBody Map<String, String> requestBody) {
    	String email = requestBody.get("email");
    	return ResponseEntity.ok(emailService.sendEmail(email));
    }
}
