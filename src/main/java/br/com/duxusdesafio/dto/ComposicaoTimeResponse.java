package br.com.duxusdesafio.dto;


import br.com.duxusdesafio.model.ComposicaoTime;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ComposicaoTimeResponse {

    private String integranteNome;

    private Long timeNome;

    public static ComposicaoTimeResponse build(ComposicaoTime composicaoTime) {
        return ComposicaoTimeResponse.builder()
                .integranteNome(composicaoTime.getIntegrante().getNome())
                .timeNome(composicaoTime.getTime().getId())
                .build();
    }
}
