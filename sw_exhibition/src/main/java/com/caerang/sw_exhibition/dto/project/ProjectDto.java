package com.caerang.sw_exhibition.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Alias("ProjectDto")
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    @NotNull private String proj_name;
    @NotNull private String proj_content;
    private String proj_videoUrl;
    private String proj_github;
    @NotNull private String proj_developField;
}
