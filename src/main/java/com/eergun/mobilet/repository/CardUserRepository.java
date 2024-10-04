package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardUserRepository extends JpaRepository<CardUser, Long> {
}