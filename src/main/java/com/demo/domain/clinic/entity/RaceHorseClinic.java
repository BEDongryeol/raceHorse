package com.demo.domain.clinic.entity;

import com.demo.openapi.RaceHorseClinicDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class RaceHorseClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clinicDate; // 진료 일자
    private String hospiName; // 병원 이름
    private String hrName; // 마명
    private String hrNo; // 마번
    private String illName1; // 병명
    private String illName2; // 상세
    private String meet; // 시행 경마장 구분
    private String part; //

    @Builder
    private RaceHorseClinic(String clinicDate, String hospiName, String hrName, String hrNo, String illName1, String illName2, String meet, String part) {
        this.clinicDate = clinicDate;
        this.hospiName = hospiName;
        this.hrName = hrName;
        this.hrNo = hrNo;
        this.illName1 = illName1;
        this.illName2 = illName2;
        this.meet = meet;
        this.part = part;
    }

    public static RaceHorseClinic valueOf(RaceHorseClinicDto dto) {
        return RaceHorseClinic.builder()
                .clinicDate(dto.getClinicDate())
                .hospiName(dto.getHospiName())
                .hrName(dto.getHrName())
                .hrNo(dto.getHrNo())
                .illName1(dto.getIllName1())
                .illName2(dto.getIllName2())
                .meet(dto.getMeet())
                .part(dto.getPart())
                .build();
    }
}
