package com.example.kanbas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardModel {
    private Long bd_id;
    private String bd_name;
    private String bd_description;
    private StatusModel bd_status;

    public void changeBoardStatus(StatusModel status){
        //TODO: cambiar la logica del metodo , quitar el parametro que recibe , encapsular la logica interna del metodo,
        // para que el sea capaz de ver segun el # de tareas que tenga  si ya todas fueorn finalizadas, cambiar el status solo
        this.bd_status = status;

    }

    public static class Builder {
        private Long bd_id;
        private String bd_name;
        private String bd_description;
        private StatusModel bd_status;

        public Builder bd_id(Long bd_id) {
            this.bd_id = bd_id;
            return this;
        };
        public Builder bd_name(String bd_name) {
            this.bd_name = bd_name;
            return this;
        };
        public Builder bd_description(String bd_description) {
            this.bd_description = bd_description;
            return this;
        };
        public Builder bd_status(StatusModel bd_status) {
            this.bd_status = bd_status;
            return this;
        }
        public BoardModel build() {
            BoardModel boardModel = new BoardModel();
            boardModel.bd_id = this.bd_id;
            boardModel.bd_name = this.bd_name;
            boardModel.bd_description = this.bd_description;
            boardModel.bd_status = this.bd_status;
            return boardModel;
        }
    }
}


