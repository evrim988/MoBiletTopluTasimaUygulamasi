package com.eergun.mobilet.entity;

import com.eergun.mobilet.utility.enums.State;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public abstract class BaseEntity {
	State state;
	@Builder.Default
	LocalDateTime createAt = LocalDateTime.now();
	@Builder.Default
	LocalDateTime updateAt = LocalDateTime.now();

	LocalDateTime deleteAt;
}