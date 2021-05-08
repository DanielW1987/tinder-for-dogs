package de.tinderfordogs.web.request;

public class RegistrationRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String bio;
  private String password;
  private boolean agreeToTermsAndConditions;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAgreeToTermsAndConditions() {
    return agreeToTermsAndConditions;
  }

  public void setAgreeToTermsAndConditions(boolean agreeToTermsAndConditions) {
    this.agreeToTermsAndConditions = agreeToTermsAndConditions;
  }

  @Override
  public String toString() {
    return "RegistrationRequest{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", bio='" + bio + '\'' +
           ", password='" + password + '\'' +
           ", agreeToTermsAndConditions=" + agreeToTermsAndConditions +
           '}';
  }
}
