package com.example.kanbas.rests.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BoardDTO {
    private String name;
    private String description;
    private Long status_id;
}
