package com.example.week2.service;

import com.example.week2.dto.request.CommentCreateRequest;
import com.example.week2.dto.request.CommentUpdateRequest;
import com.example.week2.dto.request.SubCommentCreateRequest;
import com.example.week2.dto.request.SubCommentUpdateRequest;
import com.example.week2.dto.response.CommentResponse;
import com.example.week2.dto.response.SubCommentResponse;
import com.example.week2.mapper.SubCommentMapper;
import com.example.week2.repository.CommentRepository;
import com.example.week2.repository.SubCommentRepository;
import com.example.week2.repository.TopicRepository;
import com.example.week2.repository.domain.SubComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCommentService {
    private final SubCommentRepository subcommentRepository;
    private final CommentRepository commentRepository;

    public void save(SubCommentCreateRequest request){
        subcommentRepository.save(SubCommentMapper.from(request));
    }

    public SubCommentResponse findById(Long id){
        SubComment subcomment = subcommentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SUBCOMMENT NOT FOUND"));
        return SubCommentResponse.of(subcomment);
    }


    //수정
    public SubCommentResponse update(SubCommentUpdateRequest request){
        SubComment subcomment = subcommentRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("SUBComment NOT FOUND"));
        subcommentRepository.save(subcomment.update(request));
        return SubCommentResponse.of(subcomment);
    }

    //삭제
    public void deleteById(Long id){
        subcommentRepository.deleteById(id);
    }

    //전체조회
    public List<SubCommentResponse> findAllSubComments() {
        List<SubComment> subComments = subcommentRepository.findAll();
        return subComments.stream()
                .map(SubCommentResponse::of)
                .toList();
    }
}
