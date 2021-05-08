package de.tinderfordogs.web;

import de.tinderfordogs.config.Endpoints;
import de.tinderfordogs.config.ViewNames;
import de.tinderfordogs.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

  private final RegistrationService registrationService;

  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @GetMapping(path = Endpoints.Site.REGISTER)
  public ModelAndView showRegistrationPage() {
    return new ModelAndView(ViewNames.REGISTER);
  }
}
