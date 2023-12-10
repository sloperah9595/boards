package com.example.kanbas.persistances.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tsk_task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "id_task", nullable = false, unique = true)
    private Long id_task;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusEntity id_status;
    @OneToOne
    @JoinColumn(name = "id_board")
    private BoardEntity id_board;

    public TaskEntity(String name, String description, StatusEntity id_status, BoardEntity id_board) {
        this.name = name;
        this.description = description;
        this.id_status = id_status;
        this.id_board = id_board;
    }
}
