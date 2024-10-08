package com.example.week2.service;

import com.example.week2.dto.request.TopicCreateRequest;
import com.example.week2.dto.request.TopicUpdateRequest;
import com.example.week2.dto.response.TopicResponse;
import com.example.week2.mapper.TopicMapper;
import com.example.week2.repository.TopicRepository;
import com.example.week2.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request){
        topicRepository.save(TopicMapper.from(request));
    }

    public TopicResponse findById(Long id){
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);
    }

    //전체조회
    public List<TopicResponse> findAll(){
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    //수정
    public TopicResponse update(TopicUpdateRequest request){
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        topicRepository.save(topic.update(request));
        return TopicResponse.of(topic);
    }

    //삭제
    public void deleteById(Long id){
        topicRepository.deleteById(id);
    }
}
