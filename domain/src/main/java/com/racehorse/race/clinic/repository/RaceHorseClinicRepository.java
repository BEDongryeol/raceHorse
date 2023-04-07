package com.racehorse.race.clinic.repository;

import com.racehorse.race.clinic.entity.RaceHorseClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Repository
public interface RaceHorseClinicRepository extends JpaRepository<RaceHorseClinic, Long> {
}
