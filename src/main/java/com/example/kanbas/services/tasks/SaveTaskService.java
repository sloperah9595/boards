package com.example.kanbas.services.tasks;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.entities.StatusEntity;
import com.example.kanbas.persistances.entities.TaskEntity;
import com.example.kanbas.persistances.repositories.TaskRepository;
import com.example.kanbas.rests.dtos.TaskDTO;
import com.example.kanbas.services.boards.GetBoardByIdService;
import com.example.kanbas.services.statuses.GetStatusByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SaveTaskService {
    private final  TaskRepository taskRepository;
    GetBoardByIdService getBoardByIdService;
    GetStatusByIdService getStatusById;
    @Transactional
    public TaskEntity execute(TaskDTO dtoTask) {
        StatusEntity status = getStatusById.execute(dtoTask.getStatus_id());
        BoardEntity board = getBoardByIdService.execute(dtoTask.getBd_id());
        TaskEntity task = new TaskEntity(dtoTask.getName(),dtoTask.getDescription(),status,board);
        taskRepository.save(task);
        return task;
    }
}
