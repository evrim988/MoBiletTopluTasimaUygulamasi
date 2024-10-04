package com.eergun.mobilet.entity.card;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcardwithdiscount")
public class CardWithDiscount extends CardWithBalance {
	Double discount;
	Long cardUserId;

}