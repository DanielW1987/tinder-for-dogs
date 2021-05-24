package de.tinderfordogs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      // public pages
      .antMatchers(
        HttpMethod.GET,
        Endpoints.Site.INDEX,
        Endpoints.Site.SLASH_INDEX,
        Endpoints.Site.LOGIN,
        Endpoints.Site.REGISTER
      ).permitAll()
      // static resources
      .antMatchers(
        "/css/**",
        "/images/**",
        "/js/**"
      ).permitAll()
      .anyRequest().authenticated()

      // send the user back to the root page when they logout
      .and()
      .logout().logoutSuccessUrl("/?logout")

      .and()
      .oauth2Client()
      .and()
      .oauth2Login();
  }
}
