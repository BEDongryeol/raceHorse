package com.racehorse.race.domain.user.respository;

import com.racehorse.race.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
