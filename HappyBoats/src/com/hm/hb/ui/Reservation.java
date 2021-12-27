package com.hm.hb.ui;

import javax.swing.JOptionPane;

import com.hm.hb.bean.ReservationBean;

public class Reservation {
	public static ReservationBean addReservation() {
		ReservationBean rb=new ReservationBean();
		String rid=JOptionPane.showInputDialog("Enter ReservationId:");
		String sid=JOptionPane.showInputDialog("Enter ScheduleID:");
		String uid=JOptionPane.showInputDialog("Enter UserId:");
		String bd=JOptionPane.showInputDialog("Enter BookingDate:");
		String jd=JOptionPane.showInputDialog("Enter JourneyDate:");
		int seats=Integer.parseInt(JOptionPane.showInputDialog("Enter No of seats:"));
		double fare=Double.parseDouble(JOptionPane.showInputDialog("Enter TotalFare:"));
		String status=JOptionPane.showInputDialog("Enter bookingStatus:");
		rb.setReservationID(rid);
		rb.setScheduleID(sid);
		rb.setUserID(uid);
		rb.setBookingDate(bd);
		rb.setJourneyDate(jd);
		rb.setNoOfSeats(seats);
		rb.setTotalFare(fare);
		rb.setBookingStatus(status);
        return rb;
	}     

}
