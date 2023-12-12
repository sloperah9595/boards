package com.example.kanbas.persistances.impl;

import com.example.kanbas.exceptions.NotFoundException;
import com.example.kanbas.mappers.BoardMapper;
import com.example.kanbas.models.BoardModel;
import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.persistances.repositories.BoardJpaRepository;
import com.example.kanbas.repositories.BoardRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BoardImpl implements BoardRepository {

    private final BoardJpaRepository jpaRepository;

    @Override
    public BoardModel findById(Integer id) {
        Optional<BoardEntity> entity = this.jpaRepository.findById(id);

        if(entity.isEmpty()){
            throw new NotFoundException("Board not found");
        }

        return BoardMapper.toModel(entity.get());
    }

    @Override
    public List<BoardModel> findAll() {
        return BoardMapper.toModels(this.jpaRepository.findAll());
    }
}
