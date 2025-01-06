package org.koreait.member.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/join")
    public void joinPs(@RequestBody RequestJoin form) {
        System.out.println(form);
    }
}
