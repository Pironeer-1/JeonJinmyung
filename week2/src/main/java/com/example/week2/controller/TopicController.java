package com.example.week2.controller;

import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TopicController {
    private final TopicService topicService;
    @PostMapping("/api/topic")
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/topic/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id){
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }
}
