package com.example.week3.member.repository;

import com.example.week3.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import io.jsonwebtoken.lang.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class MemberRepository {

    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();

    // 저장
    public Member save(Member member) {
        if (member.getMemberId() == null) { // 새로운 회원인 경우
            Long id = memberIdxGenerator.incrementAndGet();  // 새로운 ID 생성
            member.setId(id);
            memberMap.put(id, member);  // 새로운 회원 추가
            log.info("New member saved.");
        } else { // 기존 회원인 경우
            log.info("Existing member updated.");
            Long id = memberIdxGenerator.incrementAndGet();  // 새로운 ID 생성
            member.setId(id);
            memberMap.put(member.getId(),member);
            for (Long l : memberMap.keySet()) {
                log.info(String.valueOf(memberMap.get(l)));
            }
            // 기존 회원의 ID를 그대로 사용하고 정보를 업데이트
            //memberMap.replace(Long.valueOf(member.getMemberId()), member);  // 기존 회원 정보 수정
        }

        // 저장된 회원 정보를 로그로 출력

        return member;
    }

    // id로 Member 조회
    public Optional<Member> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(memberMap.get(id));
    }

    // memberId로 Member 조회
    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();
    }

    // memberId로 Member가 존재하는지 검사
    public Boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }
}
