package com.credibanco.service.dto;

public class CardBalanceResponseDTO {
	
	private Long balance;
	private StatusResponseDTO statusResponseDTO;
	
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public StatusResponseDTO getStatusResponseDTO() {
		return statusResponseDTO;
	}
	public void setStatusResponseDTO(StatusResponseDTO statusResponseDTO) {
		this.statusResponseDTO = statusResponseDTO;
	}
	
	

}
