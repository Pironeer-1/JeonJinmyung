package com.example.week3.member.service;

import com.example.week3.global.dto.response.JwtTokenSet;
import com.example.week3.global.dto.response.result.SingleResult;
import com.example.week3.global.exception.CustomException;
import com.example.week3.global.exception.ErrorCode;
import com.example.week3.global.service.AuthService;
import com.example.week3.global.service.ResponseService;
import com.example.week3.member.dto.request.MemberCreateReq;
import com.example.week3.member.dto.request.MemberLoginReq;
import com.example.week3.member.entity.Member;
import com.example.week3.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberCreateReq req) {
        // 아이디 중복 체크
        if (memberRepository.existByMemberId(req.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = Member.builder()
                .memberId(req.memberId())
                .password(req.password())
                .name(req.name())
                .build();
        newMember = memberRepository.save(newMember);

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }
}
