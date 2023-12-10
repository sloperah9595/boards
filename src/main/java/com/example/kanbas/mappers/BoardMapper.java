package com.example.kanbas.mappers;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.models.StatusModel;
import com.example.kanbas.persistances.entities.BoardEntity;

public class BoardMapper {

    public static BoardModel toModel(BoardEntity entity){
        BoardModel model = new BoardModel.Builder()
                .bd_id(entity.getBd_id())
                .bd_name(entity.getBd_name())
                .bd_description(entity.getBd_description())
                .bd_status(StatusMapper.toModel(entity.getBd_status())).build();
        return model;
    }

}
