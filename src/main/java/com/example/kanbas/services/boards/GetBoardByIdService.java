package com.example.kanbas.services.boards;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.repositories.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetBoardByIdService {
    private final BoardRepository boardRepository;

    public BoardModel execute(Integer id) {
        return boardRepository.findById(id);
    }
}
