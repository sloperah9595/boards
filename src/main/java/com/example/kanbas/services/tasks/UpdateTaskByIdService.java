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

@Service
@AllArgsConstructor
public class UpdateTaskByIdService {

    private final TaskRepository taskRepository;
    GetBoardByIdService getBoardByIdService;
    GetStatusByIdService getStatusByIdService;
    public TaskEntity execute(TaskDTO taskDTO, Long id){
        StatusEntity status = getStatusByIdService.execute(taskDTO.getStatus_id());
        BoardEntity boaard= getBoardByIdService.execute(taskDTO.getBd_id());
        TaskEntity taskUpdated = new TaskEntity(id,taskDTO.getName(), taskDTO.getDescription(), status,boaard);
        taskRepository.save(taskUpdated);
        return taskUpdated;
    }
}
