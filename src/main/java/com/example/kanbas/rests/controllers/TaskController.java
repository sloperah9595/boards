package com.example.kanbas.rests.controllers;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.entities.TaskEntity;
import com.example.kanbas.rests.dtos.TaskDTO;
import com.example.kanbas.services.tasks.GetTaskByIdService;
import com.example.kanbas.services.tasks.SaveTaskService;
import com.example.kanbas.services.tasks.TaskExistByIdService;
import com.example.kanbas.services.tasks.UpdateTaskByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final SaveTaskService saveTaskService;
    private final GetTaskByIdService getTaskById;
    private final TaskExistByIdService taskExistByIdService;
    private final UpdateTaskByIdService updateTaskByIdService;

    @GetMapping("/{id}")
    ResponseEntity<TaskEntity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(getTaskById.execute(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> save(@RequestBody TaskDTO tasKDTO) {
        TaskEntity task = saveTaskService.execute(tasKDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardEntity> updateBoardById(@RequestBody TaskDTO tasKDTO, @PathVariable Long id) {
        if (taskExistByIdService.execute(id)) {
            return new ResponseEntity(updateTaskByIdService.execute(tasKDTO,id)
                    , HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
    }
}
