package com.racehorse.race.domain.clinic.service;

import com.racehorse.race.domain.clinic.entity.RaceHorseClinic;
import com.racehorse.race.domain.clinic.entity.dto.RaceHorseClinicModel;
import com.racehorse.race.domain.clinic.repository.RaceHorseClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Service
public class RaceHorseClinicService {

    private final RaceHorseClinicRepository repository;

    public RaceHorseClinicService(RaceHorseClinicRepository repository) {
        this.repository = repository;
    }

    public List<RaceHorseClinic> saveAll(RaceHorseClinicModel model) {
        List<RaceHorseClinic> collect = model.extractItems().stream().map(RaceHorseClinic::valueOf).collect(Collectors.toList());
        collect.forEach(System.out::println);
        return repository.saveAll(collect);
    }
}
