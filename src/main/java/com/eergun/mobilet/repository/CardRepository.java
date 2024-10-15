package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findOptionalBySerialNumber(String serialNumber);
    
    @Query("SELECT c.serialNumber FROM Card c")
    List<String> findAllAsSerialNumber();
    
    Boolean existsCardBySerialNumber(String serialNumber);
}