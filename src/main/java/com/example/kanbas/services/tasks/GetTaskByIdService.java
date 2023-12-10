package com.example.kanbas.services.tasks;

import com.example.kanbas.persistances.entities.TaskEntity;
import com.example.kanbas.persistances.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetTaskByIdService {
    private final TaskRepository taskRepository;

    public TaskEntity execute(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found");
        }
        return task.get();
    }
}
