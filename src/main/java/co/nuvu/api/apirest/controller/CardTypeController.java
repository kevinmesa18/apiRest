package co.nuvu.api.apirest.controller;

import java.util.List;
import java.util.Optional;

import co.nuvu.api.apirest.model.CardType;
import co.nuvu.api.apirest.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardTypeController {
	
	@Autowired
	private CardTypeService cardTypeService;
	
	@GetMapping("api/cardTypes")
	public List<CardType> getCardTypes(){
		return cardTypeService.getCardTypes();
	}
	
	@GetMapping("api/cardTypes/{id}")
	public Optional<CardType> getCardType(@PathVariable("id") Integer id) {
		return cardTypeService.getCardType(id);
		
	}
	
	@PostMapping("api/cardTypes")
	public CardType saveCardType(@RequestBody CardType cardType) {
		return cardTypeService.saveCardType(cardType);
	}
	
	@PutMapping("api/cardTypes")
	public CardType updateCardType(@RequestBody CardType cardType) {
		return cardTypeService.updateCardType(cardType);
	}
	
	@DeleteMapping("api/cardTypes/{id}")
	public void deleteCardType(@PathVariable("id") Integer id){
		cardTypeService.deleteCardType(id);
	}
}
