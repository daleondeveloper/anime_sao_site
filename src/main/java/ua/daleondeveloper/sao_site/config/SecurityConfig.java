package ua.daleondeveloper.sao_site.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ua.daleondeveloper.sao_site.security.jwt.JwtConfigurer;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/manga";
    private static final String LOGIN_ENDPOINT = "/api/v1/auth/**";
    private static final String USER_ENDPOINT = "/api/v1/user/**";
    private static final String ANIME_ENDPOINT = "/api/v1/publication/anime/**";
    private static final String PUBLICATION_ENDPOINT = "/api/v1/publication/**";
    private static final String LINK_ENDPOINT = "/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(USER_ENDPOINT,ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(ANIME_ENDPOINT).permitAll()
                .antMatchers(PUBLICATION_ENDPOINT).permitAll()
                .antMatchers(LINK_ENDPOINT).permitAll()
                .antMatchers("/css/**","/js/**","/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
