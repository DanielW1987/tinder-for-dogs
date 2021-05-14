package de.tinderfordogs.persistence.dog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "rated_dogs")
public class RatedDogEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(name = "rating", nullable = false)
  @Enumerated(value = EnumType.STRING)
  private Rating rating;

  protected RatedDogEntity() {}

  public RatedDogEntity(String name, String imageUrl, Rating rating) {
    this.name = name;
    this.imageUrl = imageUrl;
    this.rating = rating;
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

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }
}
