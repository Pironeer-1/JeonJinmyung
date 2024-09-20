package com.example.week2.controller;

import com.example.week2.dto.request.CommentCreateRequest;
import com.example.week2.dto.request.CommentUpdateRequest;
import com.example.week2.dto.request.SubCommentCreateRequest;
import com.example.week2.dto.request.SubCommentUpdateRequest;
import com.example.week2.dto.response.CommentResponse;
import com.example.week2.dto.response.SubCommentResponse;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.service.CommentService;
import com.example.week2.service.SubCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "대댓글(SubComment)")
@RequestMapping("/api/subcomment")
public class SubCommentController {
    private final SubCommentService subcommentService;
    @PostMapping
    @Operation(summary = "대댓글 작성")
    public ResponseEntity<?> create(@RequestBody SubCommentCreateRequest request) {
        subcommentService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{subcommentId}")
    @Operation(summary = "대댓글 단건 조회")
    public ResponseEntity<SubCommentResponse> read(@PathVariable("subcommentId") Long id){
        SubCommentResponse response = subcommentService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Operation(summary = "대댓글 수정")
    public ResponseEntity<SubCommentResponse> update(@RequestBody SubCommentUpdateRequest request) {
        SubCommentResponse response = subcommentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{subcommentId}")
    @Operation(summary = "대댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable ("subcommentId") Long id){
        subcommentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
