package com.eergun.mobilet.utility.enums;

public enum VehicleType {
	BUS(27.5)
	,METRO(37.5)
	,TRAM(22.0)
	,FERRY(42.5)
	,FUNICULAR(37.5);

	VehicleType(Double price){
		this.price = price;
	}
	final double price;

	public double getPrice() {
		return price;
	}
}