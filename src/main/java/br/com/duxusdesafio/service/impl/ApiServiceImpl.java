package br.com.duxusdesafio.service.impl;

import br.com.duxusdesafio.dto.IntegrantesRequest;
import br.com.duxusdesafio.dto.IntegrantesResponse;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final IntegranteRepository integranteRepository;

    private final ModelMapper modelMapper;


    @Override
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {
        return null;
    }

    @Override
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return null;
    }

    @Override
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return null;
    }

    @Override
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return "";
    }

    @Override
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return "";
    }

    @Override
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return null;
    }

    @Override
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        return null;
    }

    @Override
    public void cadastrarIntegrantes(IntegrantesRequest integrantesRequest) {
        //TODO implementar try {} catch() {}
        Integrante integrante = converteParaEntidade(integrantesRequest);
        integranteRepository.save(integrante);
    }

    @Override
    public List<IntegrantesResponse> buscarIntegrantes() {
        List<Integrante> integrante =  integranteRepository.findAll();

        return integrante.stream().map(i -> {
            IntegrantesResponse response = new IntegrantesResponse();
            response.setFranquia(i.getFranquia());
            response.setNome(i.getNome());
            response.setFuncao(i.getFuncao());
            return response;
        }).toList();
    }

    @Override
    public IntegrantesResponse buscarIntegrantePorNome(String nome) {
        Integrante integrante = integranteRepository.findByNome(nome);
        return IntegrantesResponse.build(integrante);
    }



    public Integrante converteParaEntidade(IntegrantesRequest integrantesRequest){
        return modelMapper.map(integrantesRequest, Integrante.class);
    }

    public IntegrantesResponse converteParaDto(Integrante integrante){
        return modelMapper.map(integrante, IntegrantesResponse.class);
    }
}
