package com.eergun.mobilet.repository;

import com.eergun.mobilet.entity.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardUserRepository extends JpaRepository<CardUser, Long> {

    List<CardUser> findAllByNameContainingIgnoreCase(String name);

    Optional<CardUser> findOptionalByEmailAndPassword(String email, String password);

}