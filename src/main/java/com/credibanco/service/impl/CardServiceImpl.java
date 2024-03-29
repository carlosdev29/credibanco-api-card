package com.credibanco.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.db.repository.ICardRepository;
import com.credibanco.db.repository.entity.CardEntity;
import com.credibanco.db.repository.entity.StatusCardEntity;
import com.credibanco.service.ICardService;
import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;
import com.credibanco.service.dto.CardStatusRequestDTO;
import com.credibanco.service.dto.StatusResponseDTO;
import com.credibanco.util.CardUtil;


@Service
public class CardServiceImpl implements ICardService {
	
	
	private static final Integer COD_ACTIVADA_DB = 100002;
	private static final String ACTIVADA = "Activada";
	
	
	
	@Autowired
	private ICardRepository repository;
	
	
	/**
	 * Este método se encarga de obtener el numero de la tarjeta a partir del id
	 * @author Carlos Sanz
	 * @param String id con que fue emitida la tarjeta
	 * @return El numero de la tarjeta
	*/
	@Override
	public CardNumberResponseDTO getCardNumber(String id) {
		CardNumberResponseDTO cardNumberResponse = new CardNumberResponseDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		CardUtil util = new CardUtil();
		String idDB = "";
		String complementNumberCard = "";
		
		
		try {
			Optional<String>idValue = Optional.ofNullable(id);
			if (!idValue.isPresent()) {
				statusResponseDTO.setCode("203");
				statusResponseDTO.setMessage("Data not Authorized - parameter null");
				cardNumberResponse.setStatusResponseDTO(statusResponseDTO);
				return cardNumberResponse;
			}
			CardEntity cardEntity = 
					this.repository.findById(Integer.valueOf(id)).orElse(null);
			System.out.println("cardEntity  "+cardEntity);
			complementNumberCard = util.generateComplementNumber();
			cardEntity.setCardNumber(String.valueOf(cardEntity.getId()).concat(complementNumberCard));
			CardEntity cardEntityUpdated = this.repository.save(cardEntity);
			System.out.println("cardEntityUpdated "+cardEntityUpdated);
			statusResponseDTO.setCode("200");
			statusResponseDTO.setMessage("ok");
			cardNumberResponse.setStatusResponseDTO(statusResponseDTO);
			cardNumberResponse.setCardNumber(cardEntityUpdated.getCardNumber());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cardNumberResponse;
	}
	
	
	
	/**
	 * Este método se encarga de activar la tarjeta y devolver el estado de la activacion
	 * @author Carlos Sanz
	 * @param String cardNumberParam para saber cual es la tarjeta que se va a activar
	 * @return El estado de la activacion
	*/
	@Override
	public CardStatusResponseDTO setStatusCard(CardStatusRequestDTO cardStatusRequestDTO) {
		
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		CardStatusResponseDTO cardDTOStageResponse =  new CardStatusResponseDTO();
		try {
			CardEntity cardEntity = this.repository.findById(
					cardStatusRequestDTO.getIdCardStatus()).orElse(null);
			
			System.out.println("1->"+cardEntity.getCardNumber());
			System.out.println("2->"+cardStatusRequestDTO.getCardNumber());
			//Validamos si fue emitida la tarjeta
			if (!cardEntity.getCardNumber().equals(cardStatusRequestDTO.getCardNumber())) {
				statusResponseDTO.setCode("203");
				statusResponseDTO.setMessage("Data not Authorized - card not issued");
				cardDTOStageResponse.setStatusResponseDTO(statusResponseDTO);
			}
			StatusCardEntity status =new StatusCardEntity();
			status.setId(COD_ACTIVADA_DB);
			cardEntity.setStatusCard(status);
			CardEntity respDM = this.repository.save(cardEntity);
			statusResponseDTO.setCode("201");
			statusResponseDTO.setMessage("OK");
			System.out.println(respDM.getStatusCard());
			/*cardEntity.setStatusCard(respDM.getStatusCard());
			System.out.println(cardEntity);*/
			if (!respDM.getStatusCard().getId().equals(COD_ACTIVADA_DB)) {
				statusResponseDTO.setCode("203");
				statusResponseDTO.setMessage("Card not Activated");
				cardDTOStageResponse.setStatusResponseDTO(statusResponseDTO);
			}
			respDM.getStatusCard().setStatusName(ACTIVADA);
			System.out.println(respDM.getStatusCard().getStatusName());
			cardDTOStageResponse.setStatusCard(
					respDM.getStatusCard().getStatusName());
			cardDTOStageResponse.setStatusResponseDTO(statusResponseDTO);
		} catch (Exception e) {
			// TODO: handle exceptio
		}
		
		return cardDTOStageResponse;
	}
	
	
	
	/**
	 * Este método se encarga de obetener el saldo de la tarjeta
	 * @author Carlos Sanz
	 * @param String id para saber de cual tarjeta se va a hacer la consulta
	 * @return 
	*/
	@Override
	public CardBalanceResponseDTO getCardBalannce(Integer id) {
		CardBalanceResponseDTO cardBalanceResponseDTO = new CardBalanceResponseDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		CardEntity cardBalance = this.repository.findById(id).orElse(null);
		statusResponseDTO.setCode("200");
		statusResponseDTO.setMessage("Consulta Exitoso");
		cardBalanceResponseDTO.setBalance(cardBalance.getBalance());
		cardBalanceResponseDTO.setStatusResponseDTO(statusResponseDTO);
		return cardBalanceResponseDTO;
	}
	
	
	/**
	 * Este método se encarga de recargar la tarjeta debito o credito devolviendo el nuevo saldo
	 * @author Carlos Sanz
	 * @param String cardNumber para identificar el producto a recargar
	 * @param Integer ammount valor de recargar la cuenta
	 * @return el nuevo valor de saldo de la tarjeta
	*/
	@Override
	public CardBalanceResponseDTO updateBalance(String cardNumber, Integer ammount, String type) {
		CardBalanceResponseDTO cardBalanceResponseDTO = new CardBalanceResponseDTO();
		StatusResponseDTO statusBought = new StatusResponseDTO();
		Integer balanceAfterAdd = 0;
		String cardId = cardNumber.substring(0,6);
		CardEntity cardBalanceAfterAdd = this.repository.findById(Integer.valueOf(cardId))
				.orElse(null);
		
		if (type.equals("c")) {
			balanceAfterAdd = cardBalanceAfterAdd.getBalance()-ammount;
		}else {
			balanceAfterAdd = cardBalanceAfterAdd.getBalance()+ammount;
		}
		cardBalanceAfterAdd.setBalance(balanceAfterAdd);
		cardBalanceAfterAdd = this.repository.save(cardBalanceAfterAdd);
		cardBalanceResponseDTO.setBalance(cardBalanceAfterAdd.getBalance());
		statusBought.setCode("200");
		statusBought.setMessage("OK");
		cardBalanceResponseDTO.setStatusResponseDTO(statusBought);
		return cardBalanceResponseDTO;
	}
	
	

}
