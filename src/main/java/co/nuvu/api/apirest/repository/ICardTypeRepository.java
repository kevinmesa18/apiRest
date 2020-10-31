package co.nuvu.api.apirest.repository;

import co.nuvu.api.apirest.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardTypeRepository extends JpaRepository<CardType, Integer>{

}
