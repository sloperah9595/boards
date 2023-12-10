package com.example.kanbas.rests.controllers;

import com.example.kanbas.mappers.BoardMapper;
import com.example.kanbas.models.BoardModel;
import com.example.kanbas.models.StatusModel;
import com.example.kanbas.rests.dtos.BoardDTO;
import com.example.kanbas.persistances.entities.BoardEntity;
import com.example.kanbas.services.boards.BoardExistByIdService;
import com.example.kanbas.services.boards.GetBoardByIdService;
import com.example.kanbas.services.boards.SaveBoardService;
import com.example.kanbas.services.boards.UpdateBoardByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@AllArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final GetBoardByIdService getBoardByIdService;
    private final SaveBoardService saveBoardService;
    private final BoardExistByIdService boardExistById;
    private final UpdateBoardByIdService updateBoardById;

    @GetMapping
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>("Hello from controller  holaaaa", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    ResponseEntity<BoardModel> getById(@PathVariable Long id) {
        BoardEntity entity = getBoardByIdService.execute(id);
        BoardModel model =   BoardMapper.toModel(entity);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoardModel> save(@RequestBody BoardDTO kanbasDTO) {
        BoardEntity entity = saveBoardService.execute(kanbasDTO);
        BoardModel model =   BoardMapper.toModel(entity);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BoardModel> updateBoardById(@RequestBody StatusModel statusModel, @PathVariable Long id) {

        Long statusId =statusModel.getId_status();
        if (boardExistById.execute(id)) {
            BoardEntity entity =  updateBoardById.execute(statusId,id);
            BoardModel model =   BoardMapper.toModel(entity);
            return new ResponseEntity(model, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found");
    }
}
