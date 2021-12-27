package com.hm.hb.ui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hm.hb.bean.ScheduleBean;


public class Schedule {
	public static ScheduleBean addSchedule() {
		  String scid=JOptionPane.showInputDialog("Enter Scheduleid:");
          String sid=JOptionPane.showInputDialog("Enter ShipId:");
		  String rid=JOptionPane.showInputDialog("Enter Routeid:");		 
		  String startdate=JOptionPane.showInputDialog("Enter StartDate:");
          ScheduleBean scb=new ScheduleBean();
          scb.setScheduleID(scid);
          scb.setShipID(sid);
          scb.setRouteID(rid);
          scb.setStartDate(startdate);
			
	        return scb;
	  }
	public static ArrayList<String> removeSchedule() {
		ArrayList<String> scheduleidlist=new ArrayList<String>();
		  String sdid=JOptionPane.showInputDialog("Enter Scheduleid:");
		  scheduleidlist.add(sdid);
		  return scheduleidlist;
	  }
	public static ScheduleBean modifySchedule() {
		  String scid=JOptionPane.showInputDialog("Enter Scheduleid:");
        String sid=JOptionPane.showInputDialog("Enter ShipId:");
		  String rid=JOptionPane.showInputDialog("Enter Routeid:");		 
		  String startdate=JOptionPane.showInputDialog("Enter StartDate:");
        ScheduleBean scb=new ScheduleBean();
        scb.setScheduleID(scid);
        scb.setShipID(sid);
        scb.setRouteID(rid);
        scb.setStartDate(startdate);
			
	        return scb;
	  }
	public static String viewSchedule() {
		  String scid=JOptionPane.showInputDialog("Enter ScheduleId:");
		  return scid;
	  }
}
