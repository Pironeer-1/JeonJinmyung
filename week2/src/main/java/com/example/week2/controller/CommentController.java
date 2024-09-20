package com.example.week2.controller;

import com.example.week2.dto.request.CommentCreateRequest;
import com.example.week2.dto.request.CommentUpdateRequest;
import com.example.week2.dto.request.TopicUpdateRequest;
import com.example.week2.dto.response.CommentResponse;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(Comment)")
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 조회")
    public ResponseEntity<CommentResponse> read(@PathVariable("commentId") Long id){
        CommentResponse response = commentService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "댓글 전체 조회")
    public ResponseEntity<List<CommentResponse>> readAll() {
        List<CommentResponse> responses = commentService.findAllComments();
        return ResponseEntity.ok(responses);
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> update(@RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable("commentId") Long id){
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
