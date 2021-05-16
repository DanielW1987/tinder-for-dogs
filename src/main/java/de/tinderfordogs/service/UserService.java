package de.tinderfordogs.service;

import de.tinderfordogs.persistence.user.UserEntity;
import de.tinderfordogs.persistence.user.UserRepository;
import de.tinderfordogs.web.request.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public void createUser(RegistrationRequest registrationRequest) {
    UserEntity userEntity = new UserEntity(
      registrationRequest.getFirstName(),
      registrationRequest.getLastName(),
      registrationRequest.getEmail(),
      registrationRequest.getBio(),
      bCryptPasswordEncoder.encode(registrationRequest.getPassword())
    );
    userRepository.save(userEntity);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
      .findByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException("User with name '" + username + "' not found."));
  }
}
