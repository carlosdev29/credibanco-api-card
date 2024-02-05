package com.credibanco.service.dto;

public class CardBalanceResponseDTO {
	
	private Integer balance;
	private StatusResponseDTO statusResponseDTO;
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public StatusResponseDTO getStatusResponseDTO() {
		return statusResponseDTO;
	}
	public void setStatusResponseDTO(StatusResponseDTO statusResponseDTO) {
		this.statusResponseDTO = statusResponseDTO;
	}
	
	

}
