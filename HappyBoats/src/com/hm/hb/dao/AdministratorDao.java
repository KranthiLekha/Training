package com.hm.hb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hm.hb.bean.PassengerBean;
import com.hm.hb.bean.RouteBean;
import com.hm.hb.bean.ScheduleBean;
import com.hm.hb.bean.ShipBean;

public class AdministratorDao {
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//Register and Load the database driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/happyboats","root","Kranti@12");//Connection
			
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println(cnf);
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return con;
	}
	public String addShip(ShipBean shipBean) {
		String msg="";
		try {
			ps=con.prepareStatement("insert into srs_tbl_ship values(?,?,?,?)");
			ps.setString(1,shipBean.getShipID());
			ps.setString(2, shipBean.getShipName());
			ps.setInt(3, shipBean.getSeatingCapacity());
			ps.setInt(4, shipBean.getReservationCapacity());
			ps.executeUpdate();
			msg="Success";
			return msg;
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		msg="Fail";
		return msg;
	}
	public int removeShip(ArrayList<String> ShipId) {
		int i=0;
		try {
			ps=con.prepareStatement("delete from srs_tbl_ship where ShipId=?");
			for(String sid:ShipId) 
			ps.setString(1, sid);
			 i=ps.executeUpdate();
			 return i;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return i;
	}
	public  boolean modifyShip(ShipBean shipBean) {
		boolean Flag=false;
		try {
			ps=con.prepareStatement("Update srs_tbl_ship set ShipName=?,SeatingCapacity=?,ReservationCapacity=? where ShipId=?");
			ps.setString(1, shipBean.getShipName());
			ps.setInt(2, shipBean.getSeatingCapacity());
			ps.setInt(3, shipBean.getReservationCapacity());
			ps.setString(4, shipBean.getShipID());
			ps.executeUpdate();
			Flag=true;
			return Flag;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return Flag;
	}
	public ArrayList<ShipBean> viewByAllShips() {
		ArrayList<ShipBean> shiplist= new ArrayList<ShipBean>();
		try
		{
			ps=con.prepareStatement("select * from srs_tbl_ship");
			rs=ps.executeQuery();
			while(rs.next()) {
				ShipBean sb=new ShipBean();
				sb.setShipID(rs.getString("ShipId"));
				sb.setShipName(rs.getString("ShipName"));
				sb.setSeatingCapacity(rs.getInt("SeatingCapacity"));
				sb.setReservationCapacity(rs.getInt("ReservationCapacity"));
				shiplist.add(sb);
				}
		}
		catch(SQLException sql)
		{
		System.out.println(sql);	
		}
		return shiplist;
	}
	public ShipBean viewByShipId(String ShipId) {
		ShipBean sb=new ShipBean();

		try {
			ps=con.prepareStatement("select * from srs_tbl_ship where ShipId=?");
			ps.setString(1,ShipId );
			rs=ps.executeQuery();
			while(rs.next()) {
				sb.setShipID(rs.getString("ShipId"));
				sb.setShipName(rs.getString("ShipName"));
				sb.setSeatingCapacity(rs.getInt("SeatingCapacity"));
				sb.setReservationCapacity(rs.getInt("ReservationCapacity"));
				
			}
			return sb;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return sb;
	}
//---------------------------Route-----------------------------------------------
	public String addRoute(RouteBean routebean) {
		String msg="";
		try {
			ps=con.prepareStatement("insert into srs_tbl_route values(?,?,?,?,?)");
			ps.setString(1,routebean.getRouteID());
			ps.setString(2, routebean.getSource());
			ps.setString(3,routebean.getDestination());
			ps.setString(4, routebean.getTravelDuration());
			ps.setDouble(5, routebean.getFare());
			ps.executeUpdate();
			msg="Success";
			return msg;
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		msg="Fail";
		return msg;
	}
	public int removeRoute(String RouteId) {
		int i=0;
		try {
			ps=con.prepareStatement("delete from srs_tbl_route where RouteId=?");
			ps.setString(1, RouteId);
			 i=ps.executeUpdate();
			 return i;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return i;
	}
	public boolean modifyRoute(RouteBean routebean) {
		boolean Flag=false;
		try {
			ps=con.prepareStatement("Update srs_tbl_route set Source=?,Destination=?,TravelDuration=?,Fare=? where RouteId=?");
			ps.setString(1, routebean.getSource());
			ps.setString(2,routebean.getDestination());
			ps.setString(3, routebean.getTravelDuration());
			ps.setDouble(4, routebean.getFare());
			ps.setString(5,routebean.getRouteID());

			ps.executeUpdate();
            Flag=true;
            return Flag;
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		return Flag;
	}
	public ArrayList<RouteBean> viewByAllRoutes() {
		ArrayList<RouteBean> routelist=new ArrayList<RouteBean>();
		try
		{
			ps=con.prepareStatement("select * from srs_tbl_route");
			rs=ps.executeQuery();
			while(rs.next()) {
				RouteBean rb=new RouteBean();
				rb.setRouteID(rs.getString("RouteId"));
				rb.setSource(rs.getString("Source"));
				rb.setDestination(rs.getString("Destination"));				
				rb.setTravelDuration(rs.getString("TravelDuration"));
				rb.setFare(rs.getDouble("Fare"));
				routelist.add(rb);
				}
		}
		catch(SQLException sql)
		{
		System.out.println(sql);	
		}
		return routelist;
	}
	public RouteBean viewByRouteId(String RouteId) {
		RouteBean rb=new RouteBean();

		try {
			ps=con.prepareStatement("select * from srs_tbl_route where RouteId=?");
			ps.setString(1,RouteId );
			rs=ps.executeQuery();
			while(rs.next()) {
				rb.setRouteID(rs.getString("RouteId"));
				rb.setSource(rs.getString("Source"));
				rb.setDestination(rs.getString("Destination"));
				rb.setTravelDuration(rs.getString("Travelduration"));
				rb.setFare(rs.getDouble("Fare"));
				
			}
			return rb;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return rb;
	}

	
//----------------------------------------Schedule-------------------------------------------------
	
	public String addSchedule(ScheduleBean schedulebean) {
		String msg="";
		try {
			ps=con.prepareStatement("insert into srs_tbl_schedule values(?,?,?,?)");
			ps.setString(1,schedulebean.getScheduleID());
			ps.setString(2, schedulebean.getShipID());
			ps.setString(3,schedulebean.getRouteID());
			ps.setString(4, schedulebean.getStartDate());
			ps.executeUpdate();
			msg="Success";
			return msg;
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		msg="Fail";
		return msg;
	}
	public int removeSchedule(ArrayList<String> ScheduleId) {
		int i=0;
		try {
			ps=con.prepareStatement("delete from srs_tbl_schedule where ScheduleId=?");
			for(String scid:ScheduleId)
			ps.setString(1, scid);
			 i=ps.executeUpdate();
			 return i;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return i;
	}
	public boolean modifySchedule(ScheduleBean schedulebean) {
		boolean Flag=false;
		try {
			ps=con.prepareStatement("Update srs_tbl_schedule set ShipId=?,RouteId=?,StartDate=? where ScheduleId=?");
			ps.setString(1, schedulebean.getShipID());
			ps.setString(2,schedulebean.getRouteID());
			ps.setString(3, schedulebean.getStartDate());
			ps.setString(4,schedulebean.getScheduleID());

			ps.executeUpdate();
            Flag=true;
            return Flag;
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		return Flag;
	}
	public ArrayList<ScheduleBean> viewByAllSchedules() {
		ArrayList<ScheduleBean> schedulelist=new ArrayList<ScheduleBean>();
		try
		{
			ps=con.prepareStatement("select * from srs_tbl_schedule");
			rs=ps.executeQuery();
			while(rs.next()) {
				ScheduleBean sb=new ScheduleBean();
				sb.setScheduleID(rs.getString("ScheduleId"));
				sb.setShipID(rs.getString("ShipId"));
				sb.setRouteID(rs.getString("RouteId"));
				sb.setStartDate(rs.getString("StartDate"));
				schedulelist.add(sb);
			}
		}
		catch(SQLException sql)
		{
		System.out.println(sql);	
		}
		return schedulelist;
	}
	public ScheduleBean viewByScheduleId(String ScheduleId) {
		ScheduleBean sb=new ScheduleBean();

		try {
			ps=con.prepareStatement("select * from srs_tbl_schedule where ScheduleId=?");
			ps.setString(1,ScheduleId );
			rs=ps.executeQuery();
			while(rs.next()) {
				sb.setScheduleID(rs.getString("ScheduleId"));
				sb.setShipID(rs.getString("ShipId"));
				sb.setRouteID(rs.getString("RouteId"));
				sb.setStartDate(rs.getString("StartDate"));
				
			}
			return sb;
		}catch(SQLException se) {
			System.out.println(se);
		}
		return sb;
	}

//------------------------------------Passenger----------------------------------------------------
	public ArrayList<PassengerBean> viewByAllPassengers(){
		ArrayList<PassengerBean> passengerslist=new ArrayList<PassengerBean>();

		try {
			ps=con.prepareStatement("select * from srs_tbl_passenger");
     		rs=ps.executeQuery();
     		while(rs.next()) {
			PassengerBean pb=new PassengerBean();
			pb.setReservationID(rs.getString("ReservationId"));
			pb.setScheduleID(rs.getString("ScheduleId"));
			pb.setName(rs.getString("Name"));
			pb.setAge(rs.getInt("Age"));
			pb.setGender(rs.getString("Gender"));
			passengerslist.add(pb);
     		}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return passengerslist;
	}
 public ArrayList<PassengerBean> viewPasengersByShip(String scheduleid){
	 ArrayList<PassengerBean> passengerlist=new ArrayList<PassengerBean>();
	 try {
			ps=con.prepareStatement("select * from srs_tbl_passenger where ScheduleId=?");
			ps.setString(1, scheduleid);
  		rs=ps.executeQuery();
  		while(rs.next()) {
			PassengerBean pb=new PassengerBean();
			pb.setReservationID(rs.getString("ReservationId"));
			pb.setScheduleID(rs.getString("ScheduleId"));
			pb.setName(rs.getString("Name"));
			pb.setAge(rs.getInt("Age"));
			pb.setGender(rs.getString("Gender"));
			passengerlist.add(pb);
  		}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return passengerlist;
	
 }

}
