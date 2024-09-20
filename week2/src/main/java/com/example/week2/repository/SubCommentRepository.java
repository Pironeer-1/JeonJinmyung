package com.example.week2.repository;

import com.example.week2.repository.domain.SubComment;
import com.example.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SubCommentRepository {
    private final AtomicLong subcommentIdxGenerator = new AtomicLong(0);
    private final Map<Long, SubComment> subcommentMap = new HashMap<Long, SubComment>();

    public void save(SubComment subcomment) {
        if (subcomment.getId() == null){
            Long id = subcommentIdxGenerator.incrementAndGet();
            subcomment.setId(id);
            subcommentMap.put(id, subcomment);
        } else {
            subcommentMap.replace(subcomment.getId(), subcomment); //수정
        }

    }

    public Optional<SubComment> findById(Long id){
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.of(subcommentMap.get(id));
    }


    //삭제
    public void deleteById(Long subcommentId){
        Assert.notNull(subcommentId, "SUBCOMMENT ID MUST NOT BE NULL");

        SubComment subcomment = subcommentMap.get(subcommentId);
        subcommentMap.remove(subcommentId);
    }

    //전체조회
    public List<SubComment> findAll() {
        return subcommentMap.values().stream().toList();
    }
}
