package com.example.week2.mapper;

import com.example.week2.dto.request.CommentCreateRequest;
import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.repository.domain.Comment;
import com.example.week2.repository.domain.Topic;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .topicId(request.topicId())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
