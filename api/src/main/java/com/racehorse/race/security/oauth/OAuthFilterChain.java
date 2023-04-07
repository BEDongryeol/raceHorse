package com.racehorse.race.security.oauth;

import com.racehorse.race.security.oauth.filter.OAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
@RequiredArgsConstructor
@Component
public class OAuthFilterChain implements SecurityFilterChain {

    private final OAuthFilter oAuthFilter;

    @Override
    public boolean matches(HttpServletRequest request) {
        return notServerResource(request);
    }

    @Override
    public List<Filter> getFilters() {
        return List.of(oAuthFilter);
    }

    private boolean notServerResource(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        List<String> resourceURI = List.of("/**", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/open-api/**");

        for (String uri : resourceURI) {
            if (requestURI.contains(uri)) return false;
        }

        return true;
    }
}
