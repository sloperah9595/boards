package com.example.kanbas.models;

import com.example.kanbas.exceptions.StatusException;
import java.util.Arrays;
import lombok.Builder;
import lombok.Getter;

@Getter
public enum StatusModel {
    TODO(1, 1, "TODO", "Tareas por hacer"),
    DOING(2, 2, "DOING", "Tareas en progreso"),
    DONE(3, 3, "DONE", "Tareas finalizadas"),
    INACTIVE(4, 0, "INACTIVE", "Tablero inactivo");

    private Integer id;
    private Integer code;
    private String name;
    private String description;

    StatusModel(Integer id, Integer code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public static StatusModel findById(Integer id) {
        return Arrays.stream(StatusModel.values()).filter(
                status -> status.getId().equals(id)
        ).findFirst().orElseThrow(() -> new StatusException("Invalid status id"));
    }
}
