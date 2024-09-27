package com.example.week3.board.repository;

import com.example.week3.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    Optional<Board> findById(Long id);
    List<Board> findAll();
}
