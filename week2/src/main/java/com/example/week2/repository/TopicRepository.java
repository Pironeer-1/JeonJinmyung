package com.example.week2.repository;

import com.example.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong();
    private final Map<Long, Topic> topicMap = new HashMap<>();

    public void save(Topic topic) {
        Long id = topicIdxGenerator.incrementAndGet();
        topic.setId(id);
        topicMap.put(id, topic);
    }

    public Topic findById(long id) {
        return topicMap.get(id);
    }
}
