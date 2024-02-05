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
	public CardStatusResponseDTO setCard(@RequestBody CardStatusRequestDTO cardStatusRequestDTO) {
		System.out.println("cardStatusRequestDTO  "+cardStatusRequestDTO);
		CardStatusResponseDTO cardDTOStageResponse = this.cardService.setStatus(cardStatusRequestDTO);
		return cardDTOStageResponse;
	}
	
	@PostMapping(value = "/balance")
	public CardBalanceResponseDTO addMoneyCard(String cardNumber, Long ammount) {
		CardBalanceResponseDTO cardBalanceResponseDTO = 
				this.cardService.addCardMoney(cardNumber, ammount);
		return cardBalanceResponseDTO;
	}
	
	
	@GetMapping(value = "/balance/{cardId}")
	public CardBalanceResponseDTO getCardBalance() {
		CardBalanceResponseDTO response = this.getCardBalance();
		return response;
	}
	
	
	
	@GetMapping(value = "/getCards")
	public List<CardDTOOut> getCards() {
		
		List<CardDTOOut>listCards = new ArrayList<>();
		
		CardDTOOut cardDTOOut = new CardDTOOut();
		cardDTOOut.setCardNumber("54123554");
		cardDTOOut.setExpirationDate("28/11/2025");
		cardDTOOut.setDocumentNumberClient("1015402");
		cardDTOOut.setDocumentTypeClient("CC");
		cardDTOOut.setBalance("10000");
		
		CardDTOOut cardDTOOut2 = new CardDTOOut();
		cardDTOOut2.setCardNumber("541111111");
		cardDTOOut2.setExpirationDate("28/11/2029");
		cardDTOOut2.setDocumentNumberClient("1020521");
		cardDTOOut2.setDocumentTypeClient("CC");
		cardDTOOut2.setBalance("250000");
		
		CardDTOOut cardDTOOut3 = new CardDTOOut();
		cardDTOOut3.setCardNumber("542222222");
		cardDTOOut3.setExpirationDate("11/11/2026");
		cardDTOOut3.setDocumentNumberClient("1015402");
		cardDTOOut3.setDocumentTypeClient("CC");
		cardDTOOut3.setBalance("900000");
		
		listCards.add(cardDTOOut);
		listCards.add(cardDTOOut2);
		listCards.add(cardDTOOut3);
		
		return listCards;
	}
	
	
	

}
