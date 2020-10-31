package co.nuvu.api.apirest.service;

import java.util.List;
import java.util.Optional;

import co.nuvu.api.apirest.model.CardType;
import co.nuvu.api.apirest.repository.ICardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTypeService {
	
	@Autowired
	private ICardTypeRepository cardTypeRepository;
	
	public List<CardType> getCardTypes(){
		return cardTypeRepository.findAll();
	}
	
	public CardType saveCardType(CardType cardType) {
		return cardTypeRepository.save(cardType);
	}
	
	public Optional<CardType> getCardType(Integer id) {
		return cardTypeRepository.findById(id);
	}
	
	public CardType updateCardType(CardType cardType) {
		if (cardTypeRepository.findById(cardType.getId()) != null) {
			return cardTypeRepository.save(cardType);			
		} else {
			return null;
		}
	}
	
	public void deleteCardType(Integer id) {
		cardTypeRepository.deleteById(id);
	}

}
