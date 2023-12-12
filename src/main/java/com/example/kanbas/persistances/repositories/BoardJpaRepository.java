package com.example.kanbas.persistances.repositories;

import com.example.kanbas.persistances.entities.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<BoardEntity, Integer> {
}
