package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.IntegrantesRequest;
import br.com.duxusdesafio.dto.IntegrantesResponse;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */

public interface ApiService {

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
    Time timeDaData(LocalDate data, List<Time> todosOsTimes);

    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);


    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes);


    void cadastrarIntegrantes(IntegrantesRequest integrantesRequest);

    List<IntegrantesResponse> buscarIntegrantes();

    IntegrantesResponse buscarIntegrantePorNome(String nome);


}