package com.example.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SubCommentUpdateRequest(
        @Schema(
                description = "수정할 대댓글 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        Long id,
        @Schema(
                description = "수정할 대댓글 내용",
                example = "대댓글 내용을 수정합니다",
                type = "string",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String content
) {
}
