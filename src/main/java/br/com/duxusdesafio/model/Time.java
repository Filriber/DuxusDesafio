package br.com.duxusdesafio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
    private LocalDate data;
	
	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
	private List<ComposicaoTime> composicaoTime;

}
