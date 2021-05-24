package de.tinderfordogs.web;

import de.tinderfordogs.config.Endpoints;
import de.tinderfordogs.config.ViewNames;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

  @GetMapping(value = {Endpoints.Site.INDEX, Endpoints.Site.SLASH_INDEX})
  public ModelAndView getCurrentUser(@AuthenticationPrincipal OidcUser user) {
    Map<String, String> viewModel = new HashMap<>();
    if (user != null) {
      viewModel.put("name", user.getGivenName() + " " + user.getFamilyName());
    }
    return new ModelAndView(ViewNames.INDEX, viewModel);
  }
}
