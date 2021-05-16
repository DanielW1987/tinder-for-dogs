package de.tinderfordogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests(authorize -> {
        authorize
          // Pages
          .antMatchers(
            Endpoints.Site.INDEX,
            Endpoints.Site.SLASH_INDEX,
            Endpoints.Site.LOGIN,
            Endpoints.Site.REGISTER
          ).permitAll()
          // Static resources
          .antMatchers(
            "/css/**",
            "/images/**",
            "/js/**"
          ).permitAll();
      })
      .authorizeRequests().anyRequest().authenticated()
      .and()
      .formLogin()
        .loginPage(Endpoints.Site.LOGIN)
        .loginProcessingUrl(Endpoints.Site.LOGIN)
        .failureUrl(Endpoints.Site.LOGIN + "?badCredentials")
        .usernameParameter("email")
        //.failureHandler(new CustomAuthenticationFailureHandler()) // as an alternative
      .and()
      .httpBasic();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
