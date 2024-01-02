package com.prepot.web;

import com.prepot.argumentresolver.Login;
import com.prepot.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String homeLoginV3ArgumentResolver(@Login Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home로 이동
        if(loginMember == null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }
}
