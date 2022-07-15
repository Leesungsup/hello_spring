package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemoryController {
    private final MemberService memberService;
    @Autowired
    private MemoryController(MemberService memberService){
        this.memberService=memberService;
    }
}