package de.tinderfordogs.web;

import de.tinderfordogs.web.api.DogRatingRequest;
import de.tinderfordogs.config.Endpoints;
import de.tinderfordogs.service.TinderService;
import de.tinderfordogs.web.api.Dog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TinderRestController {

  private final TinderService tinderService;

  public TinderRestController(TinderService tinderService) {
    this.tinderService = tinderService;
  }

  @GetMapping(path = Endpoints.Rest.DOGS)
  public ResponseEntity<Dog> getRandomDog() {
    var dogImage = tinderService.fetchRandomDog();
    return ResponseEntity.ok(dogImage);
  }

  @GetMapping(path = Endpoints.Rest.DOGS_LIKES)
  public ResponseEntity<List<Dog>> getAllLikedDogs() {
    var dogImages = tinderService.fetchAllLikedDogs();
    return ResponseEntity.ok(dogImages);
  }

  @PostMapping(path = Endpoints.Rest.DOGS_LIKES)
  public ResponseEntity<Void> likeDog(@RequestBody DogRatingRequest likedDog) {
    tinderService.likeDog(likedDog);
    return ResponseEntity.ok().build();
  }

  @PostMapping(path = Endpoints.Rest.DOGS_DISLIKES)
  public ResponseEntity<Void> dislikeDog(@RequestBody DogRatingRequest dislikedDog) {
    tinderService.dislikeDog(dislikedDog);
    return ResponseEntity.ok().build();
  }
}
