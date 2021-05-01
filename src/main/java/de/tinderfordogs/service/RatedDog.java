package de.tinderfordogs.service;

public class RatedDog {

  private final String id;
  private final String name;
  private final String imageUrl;
  private Rating rating;

  public RatedDog(String id, String name, String imageUrl, Rating rating) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.rating = rating;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }
}
