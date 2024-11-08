package br.com.duxusdesafio.model;


import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "composicao_time")
public class ComposicaoTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Time time;

	@ManyToOne
	private Integrante integrante;

}
