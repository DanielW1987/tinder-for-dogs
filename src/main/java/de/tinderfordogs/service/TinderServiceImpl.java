package de.tinderfordogs.service;

import de.tinderfordogs.api.Dog;
import de.tinderfordogs.api.DogRatingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TinderServiceImpl implements TinderService {

  private static final String RANDOM_DOG_IMAGE_API_URL = "https://dog.ceo/api/breeds/image/random";
  private final Map<String, RatedDog> ratedDogs;
  private final RestTemplate restTemplate;

  public TinderServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    ratedDogs = new HashMap<>();
  }

  @Override
  public Dog fetchRandomDog() {
    // TODO: Do error handling, remote api not reachable or no response body etc.
    ResponseEntity<RandomDogResponse> entity = restTemplate.getForEntity(RANDOM_DOG_IMAGE_API_URL, RandomDogResponse.class);
    String id = UUID.randomUUID().toString();
    String name = createName();
    String imageUrl = entity.getBody().getMessage();
    ratedDogs.put(id, new RatedDog(id, name, imageUrl, Rating.UNRATED));
    return new Dog(id, name, imageUrl);
  }

  @Override
  public void likeDog(DogRatingRequest request) {
    RatedDog ratedDog = ratedDogs.get(request.getId());
    ratedDog.setRating(Rating.LIKE);
    ratedDogs.put(request.getId(), ratedDog);
  }

  @Override
  public void dislikeDog(DogRatingRequest request) {
    RatedDog ratedDog = ratedDogs.get(request.getId());
    ratedDog.setRating(Rating.DISLIKE);
    ratedDogs.put(request.getId(), ratedDog);
  }

  @Override
  public List<Dog> fetchAllLikedDogs() {
    return ratedDogs.values()
      .stream()
      .filter(ratedDog -> ratedDog.getRating() == Rating.LIKE)
      .map(ratedDog -> new Dog(ratedDog.getId(), ratedDog.getName(), ratedDog.getImageUrl()))
      .collect(Collectors.toList());
  }

  private String createName() {
    // TODO: create random names (via API?)
    return "Rex";
  }
}
