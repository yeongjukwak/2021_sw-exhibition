package com.caerang.sw_exhibition.mapper.project;

import com.caerang.sw_exhibition.dto.project.ProjectDto;
import com.caerang.sw_exhibition.dto.project.ProjectListDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
    public List<ProjectListDto> projectList();
    public ProjectDto projectDetail(String title);
}
