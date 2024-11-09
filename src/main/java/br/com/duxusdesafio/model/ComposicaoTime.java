package br.com.duxusdesafio.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "composicao_time")
public class ComposicaoTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Time_id", nullable = false)
    private Time time;


    @ManyToOne
    @JoinColumn(name = "Integrante_id", nullable = false)
    private Integrante integrante;

}
