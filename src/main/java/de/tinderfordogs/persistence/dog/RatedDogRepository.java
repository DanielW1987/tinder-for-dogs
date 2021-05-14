package de.tinderfordogs.persistence.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatedDogRepository extends JpaRepository<RatedDogEntity, Long> {

  List<RatedDogEntity> findAllByRatingEquals(Rating rating);
}
