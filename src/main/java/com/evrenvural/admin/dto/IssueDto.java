package com.evrenvural.admin.dto;

import com.evrenvural.admin.entity.IssueStatus;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assigne;
    private ProjectDto project;
}
