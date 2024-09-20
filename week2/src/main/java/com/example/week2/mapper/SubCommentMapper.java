package com.example.week2.mapper;

import com.example.week2.dto.request.SubCommentCreateRequest;
import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.repository.domain.SubComment;
import com.example.week2.repository.domain.Topic;

import java.time.LocalDateTime;

public class SubCommentMapper {
    public static SubComment from(SubCommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return SubComment.builder()
                .commentId(request.commentId())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
