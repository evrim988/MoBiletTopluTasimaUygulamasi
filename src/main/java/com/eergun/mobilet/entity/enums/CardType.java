package com.eergun.mobilet.entity.enums;

public enum CardType {
	DEFAULT(1.0,0.5),
	STUDENT(0.75,0.25),
	ELDER(0.95,0.5),
	TEACHER(0.80,0.3),
	MARTYR(0.75,0.25),
	EMPLOYEE(0.75,0.25);
	

	CardType(Double discountedAmount,Double transferDiscountedAmount) {
		this.discountRate = discountedAmount;
		this.transferDiscountedAmount = transferDiscountedAmount;
		
	}
	private final double discountRate;
	private final double transferDiscountedAmount;
	
	public double getDiscountRate() {
		return discountRate;
	}
	
	public double getTransferDiscountedAmount() {
		return transferDiscountedAmount;
	}
}