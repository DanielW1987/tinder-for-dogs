package de.tinderfordogs.persistence;

import de.tinderfordogs.persistence.dog.RatedDogEntity;
import de.tinderfordogs.persistence.dog.RatedDogRepository;
import de.tinderfordogs.persistence.dog.Rating;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RatedDogRepositoryIT {

  @Autowired
  private RatedDogRepository underTest;

  // Entities for Test
  private final RatedDogEntity dog1 = new RatedDogEntity("Rex", "imageurl-1", Rating.LIKE);
  private final RatedDogEntity dog2 = new RatedDogEntity("Max", "imageurl-2", Rating.DISLIKE);
  private final RatedDogEntity dog3 = new RatedDogEntity("Hasso", "imageurl-3", Rating.UNRATED);

  @BeforeEach
  void setUp() {
    underTest.save(dog1);
    underTest.save(dog2);
    underTest.save(dog3);
  }

  @AfterEach
  void tearDown() {
    underTest.deleteAll();
  }

  @Test
  @DisplayName("should find all entities")
  void test_find_all() {
    // when
    List<RatedDogEntity> dogEntities = underTest.findAll();

    // then
    assertEquals(3, dogEntities.size());
    assertEquals(dog1, dogEntities.get(0));
    assertEquals(dog2, dogEntities.get(1));
    assertEquals(dog3, dogEntities.get(2));
  }

  @Test
  @DisplayName("should set id for created rated dog entity")
  void test_create() {
    // given
    RatedDogEntity givenRatedDogEntity = new RatedDogEntity("test-dog", "https://image.url", Rating.LIKE);

    // when
    RatedDogEntity entity = underTest.save(givenRatedDogEntity);

    // then
    assertNotNull(entity.getId());
  }

  @Test
  @DisplayName("should return all liked dogs")
  void test_find_all_liked_dogs() {
    // when
    List<RatedDogEntity> dogEntities = underTest.findAllByRatingEquals(Rating.LIKE);

    // then
    assertEquals(1, dogEntities.size());
    assertEquals("Rex", dogEntities.get(0).getName());
  }
}