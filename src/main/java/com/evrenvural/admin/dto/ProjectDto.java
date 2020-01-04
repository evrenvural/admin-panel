package com.evrenvural.admin.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectCode;
}
