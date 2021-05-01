package de.tinderfordogs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatedDogRepository extends JpaRepository<RatedDogEntity, Long> {

}
