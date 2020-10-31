package co.nuvu.api.apirest.service;

import java.util.List;
import java.util.Optional;

import co.nuvu.api.apirest.model.Card;
import co.nuvu.api.apirest.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
	
	@Autowired
	private ICardRepository cardRepository;
	
	public List<Card> getCards(){
		return cardRepository.findAll();
	}
	
	public Card saveCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Optional<Card> getCard(Integer id) {
		return cardRepository.findById(id);
	}
	
	public Card updateCard(Card card) {
		if(cardRepository.findById(card.getId()) != null) {
			return cardRepository.save(card);			
		} else {
			return null;
		}
	}
	
	public void deleteCard(Integer id) {
		cardRepository.deleteById(id);
	}
}
