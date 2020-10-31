package co.nuvu.api.apirest.controller;

import java.util.List;
import java.util.Optional;

import co.nuvu.api.apirest.model.Card;
import co.nuvu.api.apirest.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("api/cards")
	public List<Card> getCards(){
		return cardService.getCards();
	}
	
	@GetMapping("api/cards/{id}")
	public Optional<Card> getCard(@PathVariable("id") Integer id) {
		return cardService.getCard(id);
	}
	
	@PostMapping("api/cards")
	public Card saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
	
	@PutMapping("api/cards")
	public Card updateCard(@RequestBody Card card) {
		return cardService.updateCard(card);
	}
	
	@DeleteMapping("api/cards/{id}")
	public void deleteCard(@PathVariable("id") Integer id){
		cardService.deleteCard(id);
	}
}
