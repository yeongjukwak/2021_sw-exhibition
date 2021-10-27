package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.member.MemberDto;
import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.service.member.MemberService;
import com.caerang.sw_exhibition.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final MemberService memberService;

    /* 개발 분야별 프로젝트 리스트 또는 프로젝트 상세보기 */
    @GetMapping("/{field}")
    public String project(@PathVariable("field") String field,
                         @RequestParam(value = "title", defaultValue = "", required = false) String title,
                         Model model){

        if(title.equals("")) { // 프로젝트 리스트
            log.info("[Controller] url=/project/{}", field);

            List<String> list = projectService.projectList(field);
            if(list.isEmpty()) {
                log.error("[ERROR_404] url=/project/{}", field);
                return "/error/404";
            }

            model.addAttribute("proj_list", list);
            return "project";

        }else { // 프로젝트 상세보기
            log.info("[Controller] url=/project/{}?title={}", field, title);

            ProjectDto projectDto = projectService.projectDetail(field, title);
            if(Objects.isNull(projectDto)) {
                log.error("[ERROR_404] url=/project/{}?title={}", field, title);
                return "/error/404";
            }

            List<MemberDto> memberDtoList = memberService.projectMemberList(title);
            model.addAttribute("proj_info", projectDto);
            model.addAttribute("proj_mem", memberDtoList);

            return "info";
        }
    }
}
