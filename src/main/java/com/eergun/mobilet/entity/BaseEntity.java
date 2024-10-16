package com.eergun.mobilet.entity;

import com.eergun.mobilet.entity.enums.State;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public abstract class BaseEntity {
	@Builder.Default
	@Enumerated(EnumType.STRING)
	State state = State.ACTIVE;
	@Builder.Default
	Long createAt = System.currentTimeMillis();
	@Builder.Default
	Long updateAt = System.currentTimeMillis();
	Long deleteAt;
}