package br.com.duxusdesafio.dto;

import br.com.duxusdesafio.model.Integrante;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class IntegrantesResponse {

    private String franquia;

    private String nome;

    private String funcao;

    public static IntegrantesResponse build(Integrante integrante) {
        return IntegrantesResponse.builder()
                .franquia(integrante.getFranquia())
                .nome(integrante.getNome())
                .funcao(integrante.getFuncao())
                .build();
    }
}


