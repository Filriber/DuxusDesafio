package br.com.duxusdesafio.service.impl;

import br.com.duxusdesafio.dto.*;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final IntegranteRepository integranteRepository;

    private final ComposicaoTimeRepository composicaoTimeRepository;

    private final TimeRepository timeRepository;

    private final ModelMapper modelMapper;


    @Override
    public TimeResponse timeDaData(LocalDate data) {
        Time timeDaData = timeRepository.findByData(data);
        return  TimeResponse.build(timeDaData);
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
    public void cadastrarTime(TimeRequest timeRequest) {
        //TODO implementar try {} catch() {}
        Time time= converteTimeParaEntidade(timeRequest);
        timeRepository.save(time);
    }
    @Override
    public TimeResponse buscarTimePorData(LocalDate data) {
        Time time = timeRepository.findByData(data);
        return TimeResponse.build(time);
    }

    @Override
    public void cadastrarIntegrantes(IntegrantesRequest integrantesRequest) {
        //TODO implementar try {} catch() {}
        Integrante integrante = converteIntegranteParaEntidade(integrantesRequest);
        integranteRepository.save(integrante);
    }

    @Override
    public void cadastrarComposicaoTime(ComposicaoTimeRequest composicaoTimeRequest) {
        //TODO implementar try {} catch() {}
        ComposicaoTime composicaoTime = converteCompTimeParaEntidade(composicaoTimeRequest);
        composicaoTimeRepository.save(composicaoTime);
    }

    @Override
    public List<IntegrantesResponse> buscarIntegrantes() {
        List<Integrante> integrante = integranteRepository.findAll();

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


    @Override
    public List<TimeResponse> buscarTimes() {
        List<Time> time = timeRepository.findAll();

        return time.stream().map(i -> {
            TimeResponse response = new TimeResponse();
            response.setData(i.getData());
            response.setNomeTime(i.getNomeTime());
            return response;
        }).toList();
    }




    public Integrante converteIntegranteParaEntidade(IntegrantesRequest integrantesRequest) {
        return modelMapper.map(integrantesRequest, Integrante.class);
    }

    public IntegrantesResponse converteParaDto(Integrante integrante) {
        return modelMapper.map(integrante, IntegrantesResponse.class);
    }

    public ComposicaoTime converteCompTimeParaEntidade(ComposicaoTimeRequest composicaoTimeRequest) {
        return modelMapper.map(composicaoTimeRequest, ComposicaoTime.class);
    }

    public ComposicaoTimeResponse converteCompTimeParaDto(ComposicaoTime composicaoTime) {
        return modelMapper.map(composicaoTime, ComposicaoTimeResponse.class);
    }

    public Time converteTimeParaEntidade(TimeRequest timeRequest) {
        return modelMapper.map(timeRequest, Time.class);
    }

    public TimeResponse converteTimeParaDto(Time time) {
        return modelMapper.map(time, TimeResponse.class);
    }




}
