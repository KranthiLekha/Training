package com.hm.hb.ui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hm.hb.bean.ShipBean;

public class Ship {
  public static ShipBean addShip() {
	  String sid=JOptionPane.showInputDialog("Enter ShipId:");
	  String sname=JOptionPane.showInputDialog("Enter ShipName:");
	  int seatcap=Integer.parseInt(JOptionPane.showInputDialog("Enter Seating Capacity:"));
	  int rescap=Integer.parseInt(JOptionPane.showInputDialog("Enter Reservation Capacity:"));
		ShipBean sb=new ShipBean();
		sb.setShipID(sid);
		sb.setShipName(sname);
		sb.setSeatingCapacity(seatcap);
		sb.setReservationCapacity(rescap);
        return sb;
  }
  public static ArrayList<String> removeShip() {
	  ArrayList<String> ShipIdList=new ArrayList<String>();
	  String sid=JOptionPane.showInputDialog("Enter ShipId:");
	  ShipIdList.add(sid);
	  return ShipIdList;
  }
  public static ShipBean modifyShip() {
	  String sid=JOptionPane.showInputDialog("Enter ShipId:");
	  String sname=JOptionPane.showInputDialog("Enter ShipName:");
	  int seatcap=Integer.parseInt(JOptionPane.showInputDialog("Enter Seating Capacity:"));
	  int rescap=Integer.parseInt(JOptionPane.showInputDialog("Enter Reservation Capacity:"));
		ShipBean sb=new ShipBean();
		sb.setShipID(sid);
		sb.setShipName(sname);
		sb.setSeatingCapacity(seatcap);
		sb.setReservationCapacity(rescap);
        return sb;
  }
  public static String viewShip() {
	  String sid=JOptionPane.showInputDialog("Enter ShipId:");
	  return sid;
  }
}
