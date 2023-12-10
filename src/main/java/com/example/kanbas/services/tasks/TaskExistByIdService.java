package com.example.kanbas.services.tasks;

import com.example.kanbas.persistances.entities.TaskEntity;
import com.example.kanbas.persistances.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskExistByIdService {
    TaskRepository taskRepository;
    public Boolean execute(Long id) {
        Boolean exist =true;
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            exist= false;
        }
        return exist;
    }
}
