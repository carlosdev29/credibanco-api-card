package com.credibanco.service.dto;



public class CardStatusRequestDTO {
	
	private Integer idCardStatus;
	private String cardNumber;
	
	public Integer getIdCustomer() {
		return idCardStatus;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCardStatus = idCustomer;
	}
	public String getDocumentNumber() {
		return cardNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.cardNumber = documentNumber;
	}
	
	

}
