package com.eergun.mobilet.utility.enums;

public enum CardType {
	DEFAULT(1.0),
	STUDENT(0.75),
	ELDER(0.95),
	TEACHER(0.80),
	MARTYR(0.75),
	EMPLOYEE(0.75);

	CardType(Double discountedAmount) {
		this.discountRate = discountedAmount;
	}
	private final double discountRate;

	public double getDiscountRate() {
		return discountRate;
	}
}