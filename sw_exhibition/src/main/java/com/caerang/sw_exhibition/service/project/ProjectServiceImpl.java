package com.caerang.sw_exhibition.service.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectListDto;
import com.caerang.sw_exhibition.mapper.project.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectListDto> projectList() {
        List<ProjectListDto> projectListDtoList = projectMapper.projectList();
        return projectListDtoList;
    }

    @Override
    public ProjectDto projectDetail(String title) {
        ProjectDto projectDto = projectMapper.projectDetail(title);
        return projectDto;
    }


}
