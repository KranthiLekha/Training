package com.hm.hb.bean;

public class ShipBean {
	private String shipID ;
	private String shipName; 
	private int seatingCapacity; 
	private int reservationCapacity;
	public String getShipID() {
		return shipID;
	}
	public void setShipID(String shipID) {
		this.shipID = shipID;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	@Override
	public String toString() {
		return "ShipBean [shipID=" + shipID + ", shipName=" + shipName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + "]";
	}
	
}
