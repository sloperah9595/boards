package com.example.kanbas.mappers;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.models.StatusModel;
import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.rests.dtos.BoardDTO;
import java.util.List;

public class BoardMapper {

    public static BoardModel toModel(BoardEntity entity) {
        return null;
    }

    public static BoardDTO toDTO(BoardModel model) {
        return BoardDTO.builder()
                .name(model.getName())
                .description(model.getDescription())
                .statusId(model.getStatus().getCode())
                .build();
    }

    public static List<BoardModel> toModels(List<BoardEntity> entities) {
        return entities.stream().map(BoardMapper::toModel).toList();
    }

    public static List<BoardDTO> toDTOs(List<BoardModel> models) {
        return models.stream().map(BoardMapper::toDTO).toList();
    }
}
