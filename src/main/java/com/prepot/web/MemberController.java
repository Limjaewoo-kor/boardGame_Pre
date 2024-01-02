package com.prepot.web;


import com.prepot.domain.Member;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import com.prepot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String items(@ModelAttribute("memberSearch") MemberSearchCond memberSearch, Model model) {
        List<Member> members = memberService.findMembers(memberSearch);
        model.addAttribute("members", members);
        return "member/memberList";
    }

    @GetMapping("/{userId}")
    public String member(@PathVariable String userId, Model model) {
        Member member = memberService.findById(userId).get();
        model.addAttribute("member", member);
        return "member/member";
    }

    @GetMapping("/add")
    public String addForm() {
        return "member/addMemberForm";
    }

    @PostMapping("/add")
    public String memberAdd(Member member){
        Member save = memberService.save(member);
        System.out.println(save.getUserName());
        return "redirect:/members";
    }


    @GetMapping("/{userId}/edit")
    public String editForm(@PathVariable String userId, Model model) {
        Member member = memberService.findById(userId).get();
        model.addAttribute("member", member);
        return "member/editMemberForm";
    }


    @GetMapping("/{userId}/delete")
    public String deleteMember(@PathVariable String userId, Model model) {
        memberService.deleteMember(userId);
        return "redirect:/members";
    }

    @PostMapping("/{userId}/edit")
    public String edit(@PathVariable String userId, @ModelAttribute MemberUpdateDto updateParam) {
        memberService.update(userId, updateParam);
        return "redirect:/members/{userId}";
    }

}
