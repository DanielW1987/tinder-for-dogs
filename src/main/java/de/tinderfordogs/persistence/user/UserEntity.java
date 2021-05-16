package de.tinderfordogs.persistence.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "bio")
  private String bio;

  @Column(name = "encrypted_password", nullable = false, length = 60)
  private String encryptedPassword;

  protected UserEntity() {}

  public UserEntity(String firstName, String lastName, String email, String bio, String encryptedPassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.bio = bio;
    this.encryptedPassword = encryptedPassword;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return encryptedPassword;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
