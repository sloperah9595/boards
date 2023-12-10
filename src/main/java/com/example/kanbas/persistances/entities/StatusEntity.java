package com.example.kanbas.persistances.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tsk_status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "id_status", nullable = false, unique = true)
    private Long id_status;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    public StatusEntity(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

}
