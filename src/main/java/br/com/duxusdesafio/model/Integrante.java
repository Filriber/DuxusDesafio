package br.com.duxusdesafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "integrante")
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String franquia;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column
    private String funcao;

    @OneToMany(mappedBy = "integrante")
    private List<ComposicaoTime> composicaoTime;

}