package com.example.kanbas;

import com.example.kanbas.models.BoardModel;

public class MakeUltis {

    public static BoardModel makeMockBoard() {
        return new BoardModel(1, "kanban", "tareas de desarrollo", 1);
    }
}
