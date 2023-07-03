package com.otree.douzone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otree.douzone.dto.OtreeUser;
import com.otree.douzone.service.MemberService;
import com.otree.douzone.service.WorkspaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberRestController {
    private final MemberService memberService;
    private final WorkspaceService workspaceService;
    private final HttpSession session;
    
    @GetMapping("")
    public ResponseEntity<OtreeUser> getMember() {
        int userId = (int) session.getAttribute("userId");
        OtreeUser otreeUser = memberService.getOtreeUserById(userId);
        return ResponseEntity.ok(otreeUser);
    }
}
