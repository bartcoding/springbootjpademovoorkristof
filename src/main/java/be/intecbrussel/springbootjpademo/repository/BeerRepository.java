package be.intecbrussel.springbootjpademo.repository;

import be.intecbrussel.springbootjpademo.entities.BeersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("beerrepo")
public interface BeerRepository extends JpaRepository<BeersEntity,Integer> {
}
