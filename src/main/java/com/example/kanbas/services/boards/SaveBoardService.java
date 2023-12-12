package com.example.kanbas.services.boards;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.entities.StatusEntity;
import com.example.kanbas.repositories.BoardRepository;
import com.example.kanbas.rests.dtos.BoardDTO;
import com.example.kanbas.services.statuses.GetStatusByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveBoardService {
    private final BoardRepository boardRepository;
    private final GetStatusByIdService getStatusByIdService;
    public BoardEntity execute(BoardDTO dtoBoard) {
       /* StatusEntity status = getStatusByIdService.execute(dtoBoard.getStatus_id());
        BoardEntity board = new BoardEntity(dtoBoard.getName(), dtoBoard.getDescription(), status);
        boardRepository.save(board);
        return board;*/
        return null;
    }
}
