package com.credibanco.service;

import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;

public interface ICardService {
	
	public CardNumberResponseDTO getCardNumber(String id);
	
	public CardStatusResponseDTO setStatus(String cardNumber);
	
	public CardBalanceResponseDTO addCardMoney(String cardNumber, Long ammount);
	
	public CardBalanceResponseDTO getCardBalannce(String id);
	

}
