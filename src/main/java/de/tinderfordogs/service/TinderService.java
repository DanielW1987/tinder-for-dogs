package de.tinderfordogs.service;

import de.tinderfordogs.web.api.Dog;
import de.tinderfordogs.web.api.DogRatingRequest;

import java.util.List;

public interface TinderService {

  Dog fetchRandomDog();

  void likeDog(DogRatingRequest dog);

  void dislikeDog(DogRatingRequest dog);

  List<Dog> fetchAllLikedDogs();

}
