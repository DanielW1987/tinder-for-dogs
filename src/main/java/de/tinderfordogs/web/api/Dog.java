package de.tinderfordogs.web.api;

public class Dog {

  private final Long id;
  private final String name;
  private final String imageUrl;

  public Dog(Long id, String name, String imageUrl) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
