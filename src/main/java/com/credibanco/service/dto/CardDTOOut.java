package com.credibanco.service.dto;

public class CardDTOOut {
	
	private String cardNumber;
    private String documentNumberClient;
    private String documentTypeClient;
    private String expirationDate;
    private String balance;
    
    
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDocumentNumberClient() {
		return documentNumberClient;
	}
	public void setDocumentNumberClient(String documentNumberClient) {
		this.documentNumberClient = documentNumberClient;
	}
	public String getDocumentTypeClient() {
		return documentTypeClient;
	}
	public void setDocumentTypeClient(String documentTypeClient) {
		this.documentTypeClient = documentTypeClient;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
    
    

}
