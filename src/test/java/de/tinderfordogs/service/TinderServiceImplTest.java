package de.tinderfordogs.service;

import de.tinderfordogs.web.api.RandomDogResponse;
import de.tinderfordogs.persistence.dog.RatedDogEntity;
import de.tinderfordogs.persistence.dog.RatedDogRepository;
import de.tinderfordogs.persistence.dog.Rating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static de.tinderfordogs.service.TinderServiceImpl.RANDOM_DOG_IMAGE_API_URL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TinderServiceImplTest {

  @Mock
  private RatedDogRepository repository;

  @Mock
  private RestTemplate restTemplate;

  @Mock
  private RandomDogNameCreator randomDogNameCreator;

  @InjectMocks
  private TinderServiceImpl underTest;

  @Test
  @DisplayName("should call external API for a random dog image")
  void test_fetch_random_dog_image() {
    // given
    RandomDogResponse mockRandomDogResponse = new RandomDogResponse("dummy message", "dummy status");
    ResponseEntity<RandomDogResponse> mockResponseEntity = ResponseEntity.ok(mockRandomDogResponse);
    doReturn(mockResponseEntity).when(restTemplate).getForEntity(anyString(), any());

    // when
    underTest.fetchRandomDog();

    // then
    verify(restTemplate).getForEntity(RANDOM_DOG_IMAGE_API_URL, RandomDogResponse.class);
  }

  @Test
  @DisplayName("should call service to create a random dog name")
  void test_create_random_dog_name() {
    // given
    RandomDogResponse mockRandomDogResponse = new RandomDogResponse("dummy message", "dummy status");
    ResponseEntity<RandomDogResponse> mockResponseEntity = ResponseEntity.ok(mockRandomDogResponse);
    doReturn(mockResponseEntity).when(restTemplate).getForEntity(anyString(), any());

    // when
    underTest.fetchRandomDog();

    // then
    verify(randomDogNameCreator).randomDogName();
  }

  @Test
  @DisplayName("should save rated dog entity after fetching random image")
  void test_create_rated_dog_entity() {
    // given
    ArgumentCaptor<RatedDogEntity> captor = ArgumentCaptor.forClass(RatedDogEntity.class);
    RandomDogResponse mockRandomDogResponse = new RandomDogResponse("dummy message", "dummy status");
    ResponseEntity<RandomDogResponse> mockResponseEntity = ResponseEntity.ok(mockRandomDogResponse);
    doReturn(mockResponseEntity).when(restTemplate).getForEntity(anyString(), any());
    doReturn("dummy name").when(randomDogNameCreator).randomDogName();

    // when
    underTest.fetchRandomDog();

    // then
    verify(repository).save(captor.capture());
    assertEquals("dummy name", captor.getValue().getName());
    assertEquals(mockRandomDogResponse.getMessage(), captor.getValue().getImageUrl());
    assertEquals(Rating.UNRATED, captor.getValue().getRating());
  }
}