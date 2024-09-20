package com.example.week2.dto.response;

import com.example.week2.repository.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record CommentResponse (
        @Schema(
                description = "댓글 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(
                description = "게시글 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long topicId,
        @Schema(
                description = "댓글 내용",
                example = "댓글 내용입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String content,
        @Schema(
                description = "댓글 생성 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime createdAt,
        @Schema(
                description = "댓글 수정 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime updatedAt
){
    public static CommentResponse of (Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getTopicId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );

    }
}
