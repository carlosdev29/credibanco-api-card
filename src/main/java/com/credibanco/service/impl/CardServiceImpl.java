package com.credibanco.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.db.repository.ICardRepository;
import com.credibanco.db.repository.entity.CardEntity;
import com.credibanco.service.ICardService;
import com.credibanco.service.dto.CardStatusResponseDTO;
import com.credibanco.service.dto.CardBalanceResponseDTO;
import com.credibanco.service.dto.CardNumberResponseDTO;
import com.credibanco.service.dto.StatusResponseDTO;
import com.credibanco.util.CardUtil;


@Service
public class CardServiceImpl implements ICardService {
	
	private static final String TEST_ID = "123456";
	private static final String TEST_COMPLEMENT_NUMBER ="0123456789";
	
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
			cardNumberResponse.setCardNumber(
					String.valueOf(cardEntity.getId()).concat(complementNumberCard));
			statusResponseDTO.setCode("200");
			statusResponseDTO.setMessage("ok");
			cardNumberResponse.setStatusResponseDTO(statusResponseDTO);
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
	public CardStatusResponseDTO setStatus(String cardNumberParam) {
		cardNumberParam = "1234560123456789";
		String cardNumberDB = "";
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		CardStatusResponseDTO cardDTOStageResponse =  new CardStatusResponseDTO();
		try {
			cardNumberDB = TEST_ID.concat(TEST_COMPLEMENT_NUMBER);
			//Validamos si fue emitida la tarjeta
			if (!cardNumberDB.equals(cardNumberParam)) {
				statusResponseDTO.setCode("203");
				statusResponseDTO.setMessage("Data not Authorized - card not issued");
				cardDTOStageResponse.setStatusResponseDTO(statusResponseDTO);
			}
			cardDTOStageResponse.setStatusCard(true);
			statusResponseDTO.setCode("201");
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
	public CardBalanceResponseDTO getCardBalannce(String id) {
		CardBalanceResponseDTO cardBalanceResponseDTO = new CardBalanceResponseDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		Long balanceDB = 1000L; 
		statusResponseDTO.setCode("200");
		statusResponseDTO.setMessage("Consulta Exitoso");
		cardBalanceResponseDTO.setBalance(balanceDB);
		cardBalanceResponseDTO.setStatusResponseDTO(statusResponseDTO);
		return cardBalanceResponseDTO;
	}
	
	
	/**
	 * Este método se encarga de recargar la tarjeta debito o credito devolviendo el nuevo saldo
	 * @author Carlos Sanz
	 * @param String cardNumber para identificar el producto a recargar
	 * @param Long ammount valor de recargar la cuenta
	 * @return el nuevo valor de saldo de la tarjeta
	*/
	@Override
	public CardBalanceResponseDTO addCardMoney(String cardNumber, Long ammount) {
		CardBalanceResponseDTO cardBalanceResponseDTO = new CardBalanceResponseDTO();
		return cardBalanceResponseDTO;
	}
	
	

}
