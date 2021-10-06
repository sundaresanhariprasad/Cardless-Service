package com.service.layer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.layer.business.CardService;
import com.service.layer.model.Card;

@RestController
@CrossOrigin
@RequestMapping("/api/cards")
public class CardController {

	@Autowired
	private CardService cardService;
	
	
	@GetMapping(value = "/hello")
	public String HelloWorld() {
		return "Hello String";
	}
	
	@GetMapping("/getCards/{pan}")
	private Card getCards(@PathVariable("pan") String pan) {
		
		return cardService.getCards(pan);
		
	}
	
	
}
