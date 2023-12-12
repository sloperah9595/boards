package com.example.kanbas.persistances.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boards")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "bd_id", nullable = false, unique = true)
    private Integer bd_id;


    @Column(name = "bd_name", length = 100, unique = true)
    private String bd_name;

    @Column(name = "bd_description", length = 100)
    private String bd_description;

    @ManyToOne
    @JoinColumn(name = "id_status") //No necesario para el ejemplo del curso pero se puede explicar
    private StatusEntity bd_status;

    public BoardEntity(String bd_name, String bd_description, StatusEntity bd_status) {
        this.bd_name = bd_name;
        this.bd_description = bd_description;
        this.bd_status = bd_status;
    }

}