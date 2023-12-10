package com.example.kanbas.services.boards;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.repositories.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetBoardByIdService {
    private final BoardRepository boardRepository;

    public BoardEntity execute(Long id) {
        Optional<BoardEntity> board = boardRepository.findById(id);
        if (board.isEmpty()) {
           throw new RuntimeException("board not found");
        }
        return board.get();
    }
}
