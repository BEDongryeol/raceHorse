package com.racehorse.race.api.openapi;

import com.racehorse.race.domain.clinic.entity.RaceHorseClinic;
import com.racehorse.race.domain.clinic.entity.dto.RaceHorseClinicModel;
import com.racehorse.race.domain.clinic.service.RaceHorseClinicService;
import com.racehorse.race.domain.clinic.util.OpenApiURLProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
                .filter(getLoggingFilter())
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

    private ExchangeFilterFunction getLoggingFilter() {
        return ExchangeFilterFunction.ofRequestProcessor(
                clientRequest -> {
                    log.info("Request : {} {}", clientRequest.method(), clientRequest.url());
                    clientRequest.headers().forEach((name, value) ->
                            log.info("{} = {}", name, value));
                    return Mono.just(clientRequest);
                }
        );
    }


}
