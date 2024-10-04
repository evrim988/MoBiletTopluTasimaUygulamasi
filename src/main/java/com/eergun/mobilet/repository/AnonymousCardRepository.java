package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.card.AnonymousCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnonymousCardRepository extends JpaRepository<AnonymousCard, Long> {
}