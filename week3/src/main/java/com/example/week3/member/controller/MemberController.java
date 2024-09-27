package com.example.week3.member.controller;

import com.example.week3.global.dto.response.JwtTokenSet;
import com.example.week3.global.dto.response.SuccessResponse;
import com.example.week3.global.dto.response.result.SingleResult;
import com.example.week3.member.dto.request.MemberCreateReq;
import com.example.week3.member.dto.request.MemberLoginReq;
import com.example.week3.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberCreateReq req) {
        SingleResult<JwtTokenSet> result = memberService.register(req);
        return SuccessResponse.ok(result);
    }
}
