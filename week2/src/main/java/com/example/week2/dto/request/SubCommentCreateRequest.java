package com.example.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SubCommentCreateRequest (
        @Schema(
                description = "댓글 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        Long commentId,
        @Schema(
                description = "대댓글 내용",
                example = "대댓글 내용입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String content
){
}
