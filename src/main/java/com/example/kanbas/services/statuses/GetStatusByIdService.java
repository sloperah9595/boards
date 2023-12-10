package com.example.kanbas.services.statuses;

import com.example.kanbas.models.StatusModel;
import com.example.kanbas.persistances.entities.StatusEntity;
import com.example.kanbas.persistances.repositories.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetStatusByIdService {
    private StatusRepository statusRepository;

    public StatusEntity execute(Long id) {
        Optional<StatusEntity> status=  statusRepository.findById(id);
        if (status.isPresent()) {
            return status.get();
        }
        return null;
    }

}
