package com.credibanco.db.repository.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_card")
public class CardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_card")
	private Integer id;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "creation_date")
	private Date creationCard;
	
	@Column(name = "expiration_date")
	private Date expirationCard;
	
	private String balance;
	
	@ManyToOne
	@JoinColumn(name = "id_card_status")
	private StatusCardEntity statusCard;
	
	@ManyToOne
	@JoinColumn(name = "id_card_type")
	private CardTypeEntity cardType;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private CardClientEntity cardClient;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getCreationCard() {
		return creationCard;
	}
	public void setCreationCard(Date creationCard) {
		this.creationCard = creationCard;
	}
	public Date getExpirationCard() {
		return expirationCard;
	}
	public void setExpirationCard(Date expirationCard) {
		this.expirationCard = expirationCard;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public StatusCardEntity getStatusCard() {
		return statusCard;
	}
	public void setStatusCard(StatusCardEntity statusCard) {
		this.statusCard = statusCard;
	}
	public CardTypeEntity getCardType() {
		return cardType;
	}
	public void setCardType(CardTypeEntity cardType) {
		this.cardType = cardType;
	}
	public CardClientEntity getCardClient() {
		return cardClient;
	}
	public void setCardClient(CardClientEntity cardClient) {
		this.cardClient = cardClient;
	}


}
