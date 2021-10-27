package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.member.MemberDto;
import com.caerang.sw_exhibition.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /* 팀별 팀원 리스트 */
    @GetMapping("/{team}")
    public String teamMemberList(@PathVariable("team") String team, Model model) {
        log.info("[Controller] uri=/team/{}", team);

        List<MemberDto> memberDtoList = memberService.teamMemberList(team);
        if(memberDtoList.isEmpty()){
            return "/error/404";
        }

        model.addAttribute("mem_list", memberDtoList);
        return "member";
    }
}
