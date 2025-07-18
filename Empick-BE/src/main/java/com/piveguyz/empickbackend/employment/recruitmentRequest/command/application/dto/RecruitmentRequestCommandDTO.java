package com.piveguyz.empickbackend.employment.recruitmentRequest.command.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequestCommandDTO {
	private int headcount;
	private LocalDateTime startedAt;
	private LocalDateTime endedAt;
	private String qualification;
	private String preference;
	private String responsibility;
	private String employmentType;
	private String workLocation;
	private int departmentId;
	private int jobId;
}
