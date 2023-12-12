package com.example.kanbas.services.boards;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.repositories.BoardRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetBoardAllService {
    private final BoardRepository boardRepository;

    public List<BoardModel> execute() {
        return boardRepository.findAll();
    }
}
