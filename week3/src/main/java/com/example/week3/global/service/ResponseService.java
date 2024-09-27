package com.example.week3.global.service;

import com.example.week3.global.dto.response.result.SingleResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseService {

    // 단일 값을 감싸는 메서드
    public static <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

}
