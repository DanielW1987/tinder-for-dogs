package de.tinderfordogs.service;

import de.tinderfordogs.web.request.RegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  Logger log = LoggerFactory.getLogger(RegistrationService.class);

  public void registerUser(RegistrationRequest request) {
    log.info("Register new user with the following data: {}", request);
  }
}
