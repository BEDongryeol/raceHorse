package com.racehorse.race.domain.clinic.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Component
public class OpenApiURLProvider {

    private static final String VALUE = "{value}";
    private static final String PAGE_NO = "&pageNo={value}";
    private static final String NUM_OF_ROWS = "&numOfRows={value}";
    private static final String CLINIC_DATE = "&clinic_date={value}";
    private static String baseUrl;
    private static String raceHorseClinicUrl;

    public static URI getRequestRaceHorseClinicUrl(String pageNo, String numberOfRows, String clinicDate) {
        return URI.create(raceHorseClinicUrl + convertPageNo(pageNo) + convertNumberOfRows(numberOfRows) + convertClinicDate(clinicDate));
    }

    private static String convertPageNo(String pageNo) {
        return PAGE_NO.replace(VALUE, pageNo);
    }

    private static String convertNumberOfRows(String numberOfRows) {
        return NUM_OF_ROWS.replace(VALUE, numberOfRows);
    }

    private static String convertClinicDate(String clinicDate) {
        return CLINIC_DATE.replace(VALUE, clinicDate);
    }

    @Value("${dataGo.kra.baseUrl}")
    private void setBaseUrl(String baseUrl) {
        OpenApiURLProvider.baseUrl = baseUrl;
    }

    @Value("${dataGo.kra.path.clinic}")
    private void setRequestRaceHorseClinicUrl(String requestRaceHorseClinicUrl) {
        OpenApiURLProvider.raceHorseClinicUrl = baseUrl+requestRaceHorseClinicUrl;
    }
}
