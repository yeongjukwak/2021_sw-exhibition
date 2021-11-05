package com.caerang.sw_exhibition.service.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectListDto;

import java.util.List;

public interface ProjectService {
    public List<ProjectListDto> projectList();
    public ProjectDto projectDetail(String title);
}
