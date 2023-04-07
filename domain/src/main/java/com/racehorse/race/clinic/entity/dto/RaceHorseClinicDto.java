package com.racehorse.race.clinic.entity.dto;

import com.racehorse.race.clinic.util.LocalDateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class RaceHorseClinicDto {

    private String clinicDate; // 진료 일자
    private String hospiName; // 병원 이름
    private String hrName; // 마명
    private String hrNo; // 마번
    private String illName1; // 병명
    private String illName2; // 상세
    private String meet; // 시행 경마장 구분
    private String part; //

    public LocalDate convertToDate(String clinicDate) {
        return LocalDateUtil.fromString(clinicDate);
    }
}
