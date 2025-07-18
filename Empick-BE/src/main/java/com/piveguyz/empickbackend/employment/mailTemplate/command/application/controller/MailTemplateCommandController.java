package com.piveguyz.empickbackend.employment.mailTemplate.command.application.controller;

import com.piveguyz.empickbackend.common.response.CustomApiResponse;
import com.piveguyz.empickbackend.common.response.ResponseCode;
import com.piveguyz.empickbackend.employment.mailTemplate.command.application.dto.MailTemplateCommandDTO;
import com.piveguyz.empickbackend.employment.mailTemplate.command.application.service.MailTemplateCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "안내 메일 템플릿 API", description = "안내 메일 템플릿 관리")
@RestController
@RequestMapping("/api/v1/employment/mail-template")
public class MailTemplateCommandController {
    private final MailTemplateCommandService mailTemplateCommandService;

    @Autowired
    public MailTemplateCommandController(MailTemplateCommandService mailTemplateCommandService) {
        this.mailTemplateCommandService = mailTemplateCommandService;
    }

    @Operation(
            summary = "안내 메일 템플릿 등록",
            description = """
    - 안내 메일 템플릿을 등록합니다.
    """
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2600", description = "이름이 중복된 템플릿이 존재합니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2601", description = "제목을 입력하지 않았습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2602", description = "내용을 입력하지 않았습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2603", description = "존재하지 않는 템플릿입니다.")
    })
    @PostMapping
    public ResponseEntity<CustomApiResponse<MailTemplateCommandDTO>> createTemplate(@RequestBody MailTemplateCommandDTO mailTemplateCommandDTO) {
        MailTemplateCommandDTO createdMailTemplateCommandDTO = mailTemplateCommandService.createTemplate(mailTemplateCommandDTO);
        ResponseCode result = ResponseCode.SUCCESS;
        return ResponseEntity.status(result.getHttpStatus())
                .body(CustomApiResponse.of(result, createdMailTemplateCommandDTO));
    }

    @Operation(
            summary = "안내 메일 템플릿 수정",
            description = """
    - 안내 메일 템플릿을 수정합니다.
    """
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2600", description = "이름이 중복된 템플릿이 존재합니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2601", description = "제목을 입력하지 않았습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2602", description = "내용을 입력하지 않았습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2603", description = "존재하지 않는 템플릿입니다.")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CustomApiResponse<MailTemplateCommandDTO>> updateTemplate(@PathVariable("id") Integer id,
                                                                                    @RequestBody MailTemplateCommandDTO mailTemplateCommandDTO) {
        MailTemplateCommandDTO updatedMailTemplateCommandDTO = mailTemplateCommandService.updateTemplate(id, mailTemplateCommandDTO);
        ResponseCode result = ResponseCode.SUCCESS;
        return ResponseEntity.status(result.getHttpStatus())
                .body(CustomApiResponse.of(result, updatedMailTemplateCommandDTO));
    }

    @Operation(
            summary = "안내 메일 템플릿 삭제",
            description = """
    - 안내 메일 템플릿을 삭제합니다.
    """
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "2603", description = "존재하지 않는 템플릿입니다.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<MailTemplateCommandDTO>> deleteTemplate(@PathVariable("id") Integer id) {
        MailTemplateCommandDTO deletedMailTemplateCommandDTO = mailTemplateCommandService.deleteTemplate(id);
        ResponseCode result = ResponseCode.SUCCESS;
        return ResponseEntity.status(result.getHttpStatus())
                .body(CustomApiResponse.of(result, deletedMailTemplateCommandDTO));
    }
}
