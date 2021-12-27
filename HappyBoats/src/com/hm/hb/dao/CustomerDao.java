package com.hm.hb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.hm.hb.bean.PassengerBean;
import com.hm.hb.bean.ProfileBean;
import com.hm.hb.bean.ReservationBean;
import com.hm.hb.bean.ScheduleBean;

public class CustomerDao {
	public static Connection con = getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// Register and Load the database driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/happyboats", "root", "Kranti@12");// Connection

		} catch (ClassNotFoundException cnf) {
			System.out.println(cnf);
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		return con;
	}

	public String registerUser(ProfileBean profileBean) {
		String msg = "";
		try {
			ps = con.prepareStatement("insert into srs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, profileBean.getUserID());
			ps.setString(2, profileBean.getFirstName());
			ps.setString(3, profileBean.getLastName());
			ps.setString(4, profileBean.getDateOfBirth());
			ps.setString(5, profileBean.getGender());
			ps.setString(6, profileBean.getStreet());
			ps.setString(7, profileBean.getLocation());
			ps.setString(8, profileBean.getCity());
			ps.setString(9, profileBean.getState());
			ps.setString(10, profileBean.getPincode());
			ps.setString(11, profileBean.getMobileNo());
			ps.setString(12, profileBean.getEmailID());
			ps.setString(13, profileBean.getPassword());
			ps.executeUpdate();
			msg = "Success";
			return msg;
		} catch (SQLException se) {
			System.out.println(se);
		}
		msg = "Fail";
		return msg;
	}

	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, String Date) {
		ArrayList<ScheduleBean> slist = new ArrayList<ScheduleBean>();
		ArrayList<ScheduleBean> finallist = new ArrayList<ScheduleBean>();

		String route = "";
		ArrayList<String> routeslist = new ArrayList<String>();
		try {
			ps = con.prepareStatement("select RouteId from srs_tbl_route where Source=? and Destination=?");
			ps.setString(1, source);
			ps.setString(2, destination);
			rs = ps.executeQuery();
			while (rs.next()) {
				route = rs.getString("RouteId");
				routeslist.add(route);
			}
			ps = con.prepareStatement("select *  from srs_tbl_schedule where RouteId=?");
			for (String route1 : routeslist) {
				ps.setString(1, route1);
				rs = ps.executeQuery();
				while (rs.next()) {
					ScheduleBean sb = new ScheduleBean();
					sb.setScheduleID(rs.getString("ScheduleId"));
					sb.setShipID(rs.getString("ShipId"));
					sb.setRouteID(rs.getString("RouteId"));
					sb.setStartDate(rs.getString("StartDate"));
					slist.add(sb);
				}
			}

			for (ScheduleBean sb : slist) {
				if (sb.getStartDate().equals(Date)) {
					finallist.add(sb);
				}

			}


		} catch (SQLException se) {
			System.out.println(se);
		}

		return finallist;
	}

	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengerBeanlist) {
		String msg = "";
		for (PassengerBean pb : passengerBeanlist) {
			if (reservationBean.getReservationID().equals(pb.getReservationID())) {
				{
					try {
						ps = con.prepareStatement("insert into srs_tbl_reservation values(?,?,?,?,?,?,?,?)");
						ps.setString(1, reservationBean.getReservationID());
						ps.setString(2, reservationBean.getScheduleID());
						ps.setString(3, reservationBean.getUserID());
						ps.setString(4, reservationBean.getBookingDate());
						ps.setString(5, reservationBean.getJourneyDate());
						ps.setInt(6, reservationBean.getNoOfSeats());
						ps.setDouble(7, reservationBean.getTotalFare());
						ps.setString(8, reservationBean.getBookingStatus());
						ps.executeUpdate();
						msg += "Success";
						// return msg;
					} catch (SQLException se) {
						System.out.println(se);
					}
				}

			}

		}

		return msg;

	}

	public Map<ReservationBean, PassengerBean> viewTicket(String reservationId) {
		Map<ReservationBean, PassengerBean> map = new HashMap<ReservationBean, PassengerBean>();
		try {
			ReservationBean rb = new ReservationBean();
			PassengerBean pb = new PassengerBean();
			ps = con.prepareStatement("select * from srs_tbl_reservation where ReservationId=?");
			ps.setString(1, reservationId);
			rs = ps.executeQuery();
			while (rs.next()) {
				rb.setReservationID(rs.getString("ReservationId"));
				rb.setScheduleID(rs.getString("ScheduleId"));
				rb.setUserID(rs.getString("UserId"));
				rb.setBookingDate(rs.getString("BookingDate"));
				rb.setJourneyDate(rs.getString("JourneyDate"));
				rb.setNoOfSeats(rs.getInt("NoOfSeats"));
				rb.setTotalFare(rs.getDouble("TotalFare"));
				rb.setBookingStatus(rs.getString("BookingStatus"));

			}
			ps = con.prepareStatement("select * from srs_tbl_passenger where ReservationId=?");
			ps.setString(1, reservationId);
			rs = ps.executeQuery();
			while (rs.next()) {
				pb.setReservationID(rs.getString("ReservationId"));
				pb.setScheduleID(rs.getString("ScheduleId"));
				pb.setName(rs.getString("Name"));
				pb.setAge(rs.getInt("Age"));
				pb.setGender(rs.getString("Gender"));
			}
			map.put(rb, pb);

		} catch (SQLException e) {
			System.out.println(e);
		}
		return map;
	}

	public boolean cancelTicket(String reservationId) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("delete from srs_tbl_reservation where ReservationId=?");
			ps.setString(1, reservationId);
			ps.executeUpdate();
			flag = true;
			return flag;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return flag;
	}

	public Map<ReservationBean, PassengerBean> printTicket(String reservationId) {
		Map<ReservationBean, PassengerBean> map = new HashMap<ReservationBean, PassengerBean>();
		try {
			ReservationBean rb = new ReservationBean();
			PassengerBean pb = new PassengerBean();
			ps = con.prepareStatement("select * from srs_tbl_reservation where ReservationId=?");
			ps.setString(1, reservationId);
			rs = ps.executeQuery();
			while (rs.next()) {
				rb.setReservationID(rs.getString("ReservationId"));
				rb.setScheduleID(rs.getString("ScheduleId"));
				rb.setUserID(rs.getString("UserId"));
				rb.setBookingDate(rs.getString("BookingDate"));
				rb.setJourneyDate(rs.getString("JourneyDate"));
				rb.setNoOfSeats(rs.getInt("NoOfSeats"));
				rb.setTotalFare(rs.getDouble("TotalFare"));
				rb.setBookingStatus(rs.getString("BookingStatus"));

			}
			ps = con.prepareStatement("select * from srs_tbl_passenger where ReservationId=?");
			ps.setString(1, reservationId);
			rs = ps.executeQuery();
			while (rs.next()) {
				pb.setReservationID(rs.getString("ReservationId"));
				pb.setScheduleID(rs.getString("ScheduleId"));
				pb.setName(rs.getString("Name"));
				pb.setAge(rs.getInt("Age"));
				pb.setGender(rs.getString("Gender"));
			}
			map.put(rb, pb);

		} catch (SQLException e) {
			System.out.println(e);
		}
		return map;
	}

}
