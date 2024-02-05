package com.credibanco.db.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_card_type")
public class CardTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_card_type")
	private Integer id;
	
	@Column(name = "card_type_name")
	private String cardTypeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	
	
	
	

}
