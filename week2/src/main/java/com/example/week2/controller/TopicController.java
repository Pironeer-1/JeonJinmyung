package com.example.week2.controller;

import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.dto.request.TopicUpdateRequest;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic")

public class TopicController {
    private final TopicService topicService;
    @PostMapping
    @Operation(summary = "게시물 작성")
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id){
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    //전체 조회
    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<TopicResponse>> readAll(){
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    //수정
    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    //삭제
    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<?> remove(@PathVariable("topicId") Long id){
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
