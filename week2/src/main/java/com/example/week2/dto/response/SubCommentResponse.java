package com.example.week2.dto.response;

import com.example.week2.repository.domain.SubComment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record SubCommentResponse(
        @Schema(
                description = "대댓글 id",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,
        @Schema(
                description = "댓글 id",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long commentId,
        @Schema(
                description = "대댓글 내용",
                example = "대댓글 내용입니다",
                type = "String",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String content,
        @Schema(
                description = "대댓글 생성 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        LocalDateTime createdAt,
        @Schema(
                description = "대댓글 수정 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime updatedAt
        )
{
    public static SubCommentResponse of (SubComment subcomment) {
        return new SubCommentResponse(
                subcomment.getId(),
                subcomment.getCommentId(),
                subcomment.getContent(),
                subcomment.getCreatedAt(),
                subcomment.getUpdatedAt()
        );

    }
}
