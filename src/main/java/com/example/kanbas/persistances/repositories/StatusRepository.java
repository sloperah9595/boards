package com.example.kanbas.persistances.repositories;

import com.example.kanbas.persistances.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {




}
