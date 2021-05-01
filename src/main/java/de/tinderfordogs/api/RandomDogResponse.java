package de.tinderfordogs.api;

public class RandomDogResponse {

  private String message;
  private String status;

  public RandomDogResponse() {}

  public String getMessage() {
    return message;
  }

  public String getStatus() {
    return status;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
