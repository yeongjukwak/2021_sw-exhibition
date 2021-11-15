package com.caerang.sw_exhibition.controller;

import com.caerang.sw_exhibition.dto.member.MemberOfProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectListDto;
import com.caerang.sw_exhibition.service.guestbook.GuestbookService;
import com.caerang.sw_exhibition.service.member.MemberService;
import com.caerang.sw_exhibition.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final MemberService memberService;
    private final GuestbookService guestbookService;

    /* 메인 페이지 */
    @GetMapping("/")
    public String home() {
        log.info("[GET] URI = /");
        return "index";
    }

    /* 팀 리스트 페이지 */
    @GetMapping("/team")
    public String teamList() {
        log.info("[GET] URI = /team");
        return "team";
    }

    /* 방명록 페이지 */
    @GetMapping("/guestbook")
    public String guestbook() {
        log.info("[GET] URI = /guestbook");
        return "guestbook";
    }

    /* 개발 분야별 프로젝트 리스트 또는 프로젝트 상세보기 */
    @GetMapping("/project")
    public String projectList(@RequestParam(value = "title", defaultValue = "", required = false) String title, Model model) {
        if(title.equals("")) { // 프로젝트 리스트
            log.info("[GET] URI = /project");

            List<ProjectListDto> projectListDtoList = projectService.projectList();

            // 프로젝트 리스트가 존재하지 않는 경우 (not found)
            if(projectListDtoList.isEmpty()) {
                log.error("[404] URI = /project");
                return "/error/404";
            }

            model.addAttribute("proj_list", projectListDtoList);
            return "project";

        }else { // 프로젝트 상세보기
            log.info("[GET] URI = /project?title={}", title);

            ProjectDto projectDto = projectService.projectDetail(title);

            // 프로젝트 상세정보가 없는 경우 (not found)
            if(Objects.isNull(projectDto)) {
                log.error("[404] URI = /project?title={}", title);
                return "/error/404";
            }

            // 해당 프로젝트에 참여한 인원
            List<MemberOfProjectDto> memberOfProjectDtoList = memberService.memberListOfProject(title);

            model.addAttribute("proj_desc", projectDto);
            model.addAttribute("mem_list", memberOfProjectDtoList);

            return "project_description";
        }
    }
}
