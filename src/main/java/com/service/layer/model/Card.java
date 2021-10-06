package com.service.layer.model;

import java.util.List;

public class Card {
	
	private Integer cardCount;
	
	private Cvv cvv;

	private List<DebitCards> viewPinDebitCards;


	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public Cvv getCvv() {
		return cvv;
	}

	public void setCvv(Cvv cvv) {
		this.cvv = cvv;
	}

	public List<DebitCards> getViewPinDebitCards() {
		return viewPinDebitCards;
	}

	public void setViewPinDebitCards(List<DebitCards> viewPinDebitCards) {
		this.viewPinDebitCards = viewPinDebitCards;
	}
	
}
