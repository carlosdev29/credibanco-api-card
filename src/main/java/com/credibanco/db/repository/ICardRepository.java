package com.credibanco.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.db.repository.entity.CardEntity;


@Repository
public interface ICardRepository extends JpaRepository<CardEntity, Integer>{

}
