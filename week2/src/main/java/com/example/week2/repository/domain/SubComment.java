package com.example.week2.repository.domain;

import com.example.week2.dto.request.SubCommentUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubComment {
    private Long id;
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public SubComment(
            Long id,
            Long commentId,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt){
        this.id = id;
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SubComment update(SubCommentUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
