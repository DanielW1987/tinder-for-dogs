package de.tinderfordogs.service;

import de.tinderfordogs.persistence.user.UserEntity;
import de.tinderfordogs.persistence.user.UserRepository;
import de.tinderfordogs.web.request.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void createUser(RegistrationRequest registrationRequest) {
    UserEntity userEntity = new UserEntity(
      registrationRequest.getFirstName(),
      registrationRequest.getLastName(),
      registrationRequest.getEmail(),
      registrationRequest.getBio(),
      registrationRequest.getPassword()
    );
    userRepository.save(userEntity);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return null;
  }
}
