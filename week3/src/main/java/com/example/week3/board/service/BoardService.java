package com.example.week3.board.service;

import com.example.week3.board.dto.request.BoardCreateRequest;
import com.example.week3.board.dto.request.BoardUpdateRequest;
import com.example.week3.board.dto.response.BoardResponse;
import com.example.week3.board.entity.Board;
import com.example.week3.board.mapper.BoardMapper;
import com.example.week3.board.repository.BoardRepository;
import com.example.week3.board.repository.BoardMemoryRepository;
import com.example.week3.global.dto.response.result.ListResult;
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

    public ListResult<BoardResponse> findAll() {
        List<Board> topics = boardRepository.findAll();
        List<BoardResponse> list = topics.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        boardRepository.save(board.update(request));
        return BoardResponse.of(board);
    }

    public Long deleteById(Long id) {
        Long deleteId = boardRepository.deleteById(id);
        return deleteId;
    }

}
