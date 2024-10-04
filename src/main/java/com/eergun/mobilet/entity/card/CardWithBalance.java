package com.eergun.mobilet.entity.card;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public abstract class CardWithBalance extends Card{
	double balance;
}