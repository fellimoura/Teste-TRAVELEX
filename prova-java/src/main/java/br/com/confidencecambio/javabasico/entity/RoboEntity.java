package br.com.confidencecambio.javabasico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoboEntity {
    private Long id;
    private String nome;
}
