package com.credibanco.service;

import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;
import com.credibanco.service.dto.CardStatusRequestDTO;

public interface ICardService {
	
	public CardNumberResponseDTO getCardNumber(String id);
	
	public CardStatusResponseDTO setStatusCard(CardStatusRequestDTO cardStatusRequestDTO);
	
	public CardBalanceResponseDTO updateBalance(String cardNumber, Integer ammount, String type);
	
	public CardBalanceResponseDTO getCardBalannce(Integer id);
	

}
