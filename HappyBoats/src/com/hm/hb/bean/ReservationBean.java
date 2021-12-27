package com.hm.hb.bean;

public class ReservationBean {
	private String reservationID ;
	private String scheduleID ;
	private String userID ;
	private String bookingDate; 
	private String journeyDate ;
	private int noOfSeats ;
	private double totalFare ;
	private String bookingStatus;
	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "ReservationBean [reservationID=" + reservationID + ", scheduleID=" + scheduleID + ", userID=" + userID
				+ ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", bookingStatus=" + bookingStatus + "]";
	} 


}
