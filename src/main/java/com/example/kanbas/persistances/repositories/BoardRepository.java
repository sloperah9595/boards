package com.example.kanbas.persistances.repositories;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.persistances.entities.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>  {


}
