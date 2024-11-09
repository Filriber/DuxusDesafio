package br.com.duxusdesafio.dto;

import br.com.duxusdesafio.model.Time;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TimeResponse {

    private LocalDate data;

    private String nomeTime;

    public static TimeResponse build(Time time) {
        return TimeResponse.builder()
                .data(time.getData())
                .nomeTime(time.getNomeTime())
                .build();

    }

}
