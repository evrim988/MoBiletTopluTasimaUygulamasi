package com.eergun.mobilet.utility.enums;

public enum VehicleType {
	BUS(27.5,1)
	,METRO(37.5,2)
	,TRAM(22.0,1)
	,FERRY(42.5,3)
	,FUNICULAR(37.5,1);

	VehicleType(Double price,Integer tapCount){
		this.price = price;
		this.tapCount = tapCount;
	}
	final double price;
	final int tapCount;

	public double getPrice() {
		return price;
	}

	public int getTapCount() {
		return tapCount;
	}
}