package com.example.kanbas.services.boards;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.models.StatusModel;
import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.entities.StatusEntity;
import com.example.kanbas.persistances.repositories.BoardRepository;
import com.example.kanbas.services.statuses.GetStatusByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateBoardByIdService {
    private final BoardRepository boardRepository;
    private final GetStatusByIdService getStatusByIdService;
    private final GetBoardByIdService getBoardByIdService;
    public BoardEntity execute(Long statusId, Long boardId){
        StatusEntity status = getStatusByIdService.execute(statusId);
        BoardEntity boardUpdated  = getBoardByIdService.execute(boardId);
        boardUpdated.setBd_status(status);
        boardRepository.save(boardUpdated);
        return boardUpdated;
    }

}
