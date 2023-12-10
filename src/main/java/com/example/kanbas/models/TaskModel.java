package com.example.kanbas.models;

import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.entities.StatusEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    private Long id_task;
    private String name;
    private String description;
    private StatusModel id_status;
    private BoardModel id_board;

    public static class Builder {
        private Long id_task;
        private String name;
        private String description;
        private StatusModel id_status;
        private BoardModel id_board;

        public Builder id_task(Long id_task) {
            this.id_task = id_task;
            return this;
        };
        public Builder name(String name) {
            this.name = name;
            return this;
        };
        public Builder description(String description) {
            this.description = description;
            return this;
        };
        public Builder id_status(StatusModel id_status) {
            this.id_status = id_status;
            return this;
        }
        public Builder id_board(BoardModel id_board) {
            this.id_board = id_board;
            return this;
        }
        public TaskModel build() {
            TaskModel taskModel = new TaskModel();
            taskModel.id_task = this.id_task;
            taskModel.name = this.name;
            taskModel.description = this.description;
            taskModel.id_status = this.id_status;
            taskModel.id_board = this.id_board;
            return taskModel;
        }
    }
}
