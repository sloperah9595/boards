package com.example.kanbas.repositories;

import com.example.kanbas.models.BoardModel;
import java.util.List;

public interface BoardRepository {
    BoardModel findById(Integer id);

    List<BoardModel> findAll();
}