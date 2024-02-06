package com.credibanco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.service.ICardService;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardDTOOut;
import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;
import com.credibanco.service.dto.CardStatusRequestDTO;

@RestController
@RequestMapping(value = "/cards")
@CrossOrigin(origins = "http://localhost:4200/")
public class CardsController {
	
	@Autowired
	private ICardService cardService;
	
	
	@GetMapping(value = "/{productId}/number")
	public ResponseEntity<CardNumberResponseDTO>getCardNumber(@PathVariable String productId) {
		CardNumberResponseDTO response = this.cardService.getCardNumber(productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/enroll")
	public CardStatusResponseDTO setCardStatus(@RequestBody CardStatusRequestDTO cardStatusRequestDTO) {
		System.out.println("cardStatusRequestDTO  "+cardStatusRequestDTO.getIdCardStatus());
		CardStatusResponseDTO cardDTOStageResponse = this.cardService.setStatusCard(cardStatusRequestDTO);
		return cardDTOStageResponse;
	}
	
	@PostMapping(value = "/balance")
	public CardBalanceResponseDTO addMoneyCard(String cardNumber, Integer ammount) {
		CardBalanceResponseDTO cardBalanceResponseDTO = 
				this.cardService.addCardMoney(cardNumber, ammount);
		return cardBalanceResponseDTO;
	}
	
	
	@GetMapping(value = "/balance/{cardId}")
	public CardBalanceResponseDTO getCardBalance() {
		CardBalanceResponseDTO response = this.getCardBalance();
		return response;
	}
	

}
