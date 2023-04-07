package com.demo.domain.clinic.service;

import com.demo.domain.clinic.entity.RaceHorseClinic;
import com.demo.domain.clinic.repository.RaceHorseClinicRepository;
import com.demo.openapi.RaceHorseClinicModel;
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
