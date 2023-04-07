package com.demo.openapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */

/**
 * "response": {
 * "header": {
 * "resultCode": "00",
 * "resultMsg": "NORMAL SERVICE."
 * },
 * "body": {
 * "items": {
 * "item": [
 * {
 * "clinicDate": 20220101,
 * "hospiName": "선진경마장제",
 * "hrName": "그린질주",
 * "hrNo": "0045654",
 * "illName1": "-",
 * "illName2": "-",
 * "meet": "서울",
 * "part": 6
 * },
 */
@Getter @Setter @NoArgsConstructor
public class RaceHorseClinicModel {
    private ResponseDto response;

    public List<RaceHorseClinicDto> extractItems() {
        return this.response.body.items.item;
    }

    @Getter @Setter @NoArgsConstructor
    private static class ResponseDto {
        private BodyDto body;

        @Getter @Setter
        @NoArgsConstructor
        private static class BodyDto {
            private Integer totalCount;
            private Integer numOfRows;
            private Integer pageNo;
            private ItemWrapperDto items;

            @Getter @Setter @NoArgsConstructor
            private static class ItemWrapperDto {
                private List<RaceHorseClinicDto> item;

            }
        }
    }
}
