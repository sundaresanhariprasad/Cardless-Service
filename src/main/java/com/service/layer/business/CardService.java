package com.service.layer.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.service.layer.Helper.RestTempleteHelper;
import com.service.layer.model.Card;

@Service
public class CardService {
	
	@Value("${new.service.url}")
	private String newPlatform;
	
	@Value("${old.service.url}")
	private String oldPlatform;
	
	@Autowired
	private RestTempleteHelper restTemplate;
	
	public Card getCards(String bin) {
		
		Card card=null;
		if(bin.charAt(0)=='4') {
			card = restTemplate.getForEntiry(Card.class, oldPlatform);
		}
		
		else {
			card = restTemplate.getForEntiry(Card.class, newPlatform);
		}
		return card;
	}
}
