package com.demo.api;

import com.demo.domain.clinic.entity.RaceHorseClinic;
import com.demo.domain.clinic.service.RaceHorseClinicService;
import com.demo.openapi.OpenApiURLProvider;
import com.demo.openapi.RaceHorseClinicModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@RestController
@RequestMapping("/open-api")
@Slf4j
public class OpenApiController {

    private final RaceHorseClinicService raceHorseClinicService;

    public OpenApiController(RaceHorseClinicService raceHorseClinicService) {
        this.raceHorseClinicService = raceHorseClinicService;
    }

    @GetMapping("/clinic")
    public List<RaceHorseClinic> requestHorseClinicModel(@RequestParam String pageNo,
                                                         @RequestParam String row,
                                                         @RequestParam String clinicDate) {



        Mono<RaceHorseClinicModel> clinicModel = WebClient.builder()
                .filter(ExchangeFilterFunction.ofRequestProcessor(
                        clientRequest -> {
                            log.info("Request : {} {}", clientRequest.method(), clientRequest.url());
                            clientRequest.headers().forEach((name, value) ->
                                    log.info("{} = {}", name, value));
                            return Mono.just(clientRequest);
                        }
                ))
                .build()
                .get()
                .uri(OpenApiURLProvider.getRequestRaceHorseClinicUrl(pageNo, row, clinicDate))
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(RaceHorseClinicModel.class);


        RaceHorseClinicModel block = clinicModel.share().block();
        if (block != null) return raceHorseClinicService.saveAll(block);

        return null;
    }



}
