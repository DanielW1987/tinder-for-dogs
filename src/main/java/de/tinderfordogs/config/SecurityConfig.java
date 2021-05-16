package de.tinderfordogs.config;

import de.tinderfordogs.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserService userService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public SecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userService = userService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

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

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
  }
}
