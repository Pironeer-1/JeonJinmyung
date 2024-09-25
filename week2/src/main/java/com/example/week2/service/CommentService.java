package com.example.week2.service;

import com.example.week2.dto.request.CommentCreateRequest;
import com.example.week2.dto.request.CommentUpdateRequest;
import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.dto.request.TopicUpdateRequest;
import com.example.week2.dto.response.CommentResponse;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.mapper.CommentMapper;
import com.example.week2.mapper.TopicMapper;
import com.example.week2.repository.CommentRepository;
import com.example.week2.repository.TopicRepository;
import com.example.week2.repository.domain.Comment;
import com.example.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    public void save(CommentCreateRequest request){
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return CommentResponse.of(comment);
    }

    //전체조회
    public List<CommentResponse> findAllComments(){
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentResponse::of).toList();
    }

    //수정
    public CommentResponse update(CommentUpdateRequest request){
        Comment comment = commentRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Comment NOT FOUND"));
        commentRepository.save(comment.update(request));
        return CommentResponse.of(comment);
    }

    //삭제
    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
