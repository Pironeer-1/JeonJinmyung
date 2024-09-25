package com.example.week2.repository;

import com.example.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.example.week2.repository.domain.Comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<Long, Comment>();

    public void save(Comment comment) {
        if (comment.getId() == null){
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getId(), comment); //수정
        }

    }

    public Optional<Comment> findById(Long id){
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.of(commentMap.get(id));
    }

    //전체조회
    public List<Comment> findAll(){
        return commentMap.values().stream().toList();
    }

    //삭제
    public void deleteById(Long id){
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentMap.remove(id);
    }
}
