package com.example.kanbas.models;

import com.example.kanbas.exceptions.BoardException;
import com.example.kanbas.exceptions.InternalServerException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BoardModel {
    private static final String NAME_PATTERN = "^[a-zA-Z0-9 ]*$";
    private Integer id;
    private String name;
    private String description;
    private StatusModel status;

    public BoardModel(Integer id, String name, String description, Integer statusId) {
        if (Objects.isNull(id) || id <= 0) {
            throw new BoardException("Id is null");
        }

        if (Objects.isNull(name) || name.isEmpty() || !name.matches(NAME_PATTERN)) {
            throw new BoardException("Name is invalid");
        }

        if (Objects.isNull(description)|| description.isEmpty() || !description.matches(NAME_PATTERN))  {
            throw new BoardException("Description is invalid");
        }

        if (Objects.isNull(statusId)) {
            throw new BoardException("StatusId is null");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = StatusModel.findById(statusId);
    }
}


