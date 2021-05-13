package de.tinderfordogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // Frontend pages
    registry.addViewController(Endpoints.Site.INDEX).setViewName(ViewNames.INDEX);
    registry.addViewController(Endpoints.Site.EMPTY_INDEX).setViewName(ViewNames.INDEX);
    registry.addViewController(Endpoints.Site.SLASH_INDEX).setViewName(ViewNames.INDEX);
    registry.addViewController(Endpoints.Site.LOGIN).setViewName(ViewNames.LOGIN);
    registry.addViewController(Endpoints.Site.GALLERY).setViewName(ViewNames.GALLERY);
    registry.addViewController(Endpoints.Site.TINDER).setViewName(ViewNames.TINDER);
  }

  @Bean
  LocaleResolver localeResolver() {
    return new FixedLocaleResolver(Locale.ENGLISH);
  }
}
