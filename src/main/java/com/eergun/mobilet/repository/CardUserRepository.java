package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardUserRepository extends JpaRepository<CardUser, Long> {

List<CardUser> findAllByNameContainingIgnoreCase(String name);
}