package com.example.week3.board.service;

import com.example.week3.board.dto.request.BoardCreateRequest;
import com.example.week3.board.dto.response.BoardResponse;
import com.example.week3.board.entity.Board;
import com.example.week3.board.mapper.BoardMapper;
import com.example.week3.board.repository.BoardRepository;
import com.example.week3.board.repository.BoardMemoryRepository;
import com.example.week3.global.dto.response.result.SingleResult;
import com.example.week3.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<Long> save(BoardCreateRequest request) {
        Board savedBoard = boardRepository.save(BoardMapper.from(request));
        return ResponseService.getSingleResult(savedBoard.getId());
    }
    public SingleResult<BoardResponse> findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));

        BoardResponse boardResponse = BoardResponse.of(board);
        return ResponseService.getSingleResult(boardResponse);
    }

}
