package com.credibanco.service;

import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;
import com.credibanco.service.dto.CardStatusRequestDTO;

public interface ICardService {
	
	public CardNumberResponseDTO getCardNumber(String id);
	
	public CardStatusResponseDTO setStatusCard(CardStatusRequestDTO cardStatusRequestDTO);
	
	public CardBalanceResponseDTO addCardMoney(String cardNumber, Integer ammount);
	
	public CardBalanceResponseDTO getCardBalannce(Integer id);
	

}
