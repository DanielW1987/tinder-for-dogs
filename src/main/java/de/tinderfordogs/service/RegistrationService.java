package de.tinderfordogs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  Logger log = LoggerFactory.getLogger(RegistrationService.class);

  public void registerUser() {
    log.info("Register new user...");
  }
}
