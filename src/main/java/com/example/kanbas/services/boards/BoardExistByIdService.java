package com.example.kanbas.services.boards;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.repositories.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardExistByIdService {

    private final BoardRepository boardRepository;

    public Boolean execute(Long id) {
      /*  Boolean exist =true;
        Optional<BoardEntity> board = boardRepository.findById(id);
        if (board.isEmpty()) {
            exist= false;
        }
        return exist;*/
        return null;
    }
}
