package co.nuvu.api.apirest.repository;

import co.nuvu.api.apirest.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {

}
