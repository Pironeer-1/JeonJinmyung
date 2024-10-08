package com.example.week3.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record BoardCreateRequest(
        @NotBlank
        @Schema(description = "게시물 제목", example = "제목입니다")
        String title,
        @Schema(description = "게시물 내용", example = "내용입니다")
        String content) {
}
