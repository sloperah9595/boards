package com.example.kanbas.mappers;

import com.example.kanbas.models.StatusModel;
import com.example.kanbas.persistances.entities.StatusEntity;

public class StatusMapper {
    public static StatusModel toModel(StatusEntity entity){
        StatusModel status = new StatusModel.Builder()
                .id_status(entity.getId_status())
                .st_code(entity.getCode())
                .st_name(entity.getName())
                .st_description(entity.getDescription()).build();
        return status;

    }
}
