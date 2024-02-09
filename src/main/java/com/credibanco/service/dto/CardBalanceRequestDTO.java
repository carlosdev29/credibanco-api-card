package com.credibanco.service.dto;

public class CardBalanceRequestDTO {
	
	private String cardNumber;
	private Integer ammount;
	private String typeTrans;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public String getTypeTrans() {
		return typeTrans;
	}
	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}
	
	
	
	
	

}
