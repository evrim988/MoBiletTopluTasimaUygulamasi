package com.eergun.mobilet.entity.card;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblanonymouscard")
public class AnonymousCard extends CardWithBalance {

	String name;

}