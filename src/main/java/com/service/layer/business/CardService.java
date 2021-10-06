package com.service.layer.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.layer.model.Card;
import com.service.layer.model.DebitCards;

@Service
public class CardService {
	
	public Card getCards(String pan) {
		
		Card card= new Card();
		List<DebitCards> cardList= new ArrayList<>();
		DebitCards debitCard=  new DebitCards();
		
		debitCard.setTypeOfCard("1");
		debitCard.setBrand("L");
		debitCard.setNameOnCard("AUD L");
		debitCard.setCardNumber("4921839943792019");
		debitCard.setMaskedCardNumber("XXXX XXXX XXXX 2019");
		debitCard.setCardId(11222);
		debitCard.setReplacedBycardNumber("4921839943792045");
		debitCard.setReplacedCardNumber("");
		debitCard.setPlasticType("0412");
		debitCard.setBasePlasticType("0412");
		debitCard.setIssueDate("2015-03-01");
		debitCard.setCardStatus("0");
		debitCard.setCardDispatchDate("2015-03-07");
		debitCard.setCardCancellationDate("");
		debitCard.setCardExpiryDate("2021-12-28");
		debitCard.setSortCode(23424);
		debitCard.setAccountNumber(1313123123);
		debitCard.setProductName("");
		debitCard.setCustomerProductName("");
		debitCard.setPar("");
		
		
		cardList.add(debitCard);
		card.setViewPinDebitCards(cardList);
		return card;
	}

}
