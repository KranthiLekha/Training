package com.hm.hb.ui;

import javax.swing.JOptionPane;

import com.hm.hb.bean.RouteBean;


public class Route {
	public static RouteBean addRoute() {
		  String rid=JOptionPane.showInputDialog("Enter RouteId:");
		  String src=JOptionPane.showInputDialog("Enter Source:");
		  String dest=JOptionPane.showInputDialog("Enter Destination:");
		  String td=JOptionPane.showInputDialog("Enter Duration:");
          double fare=Double.parseDouble(JOptionPane.showInputDialog("Enter Fare:"));
			RouteBean rb=new RouteBean();
			rb.setRouteID(rid);
			rb.setSource(src);
			rb.setDestination(dest);
			rb.setTravelDuration(td);
			rb.setFare(fare);
	        return rb;
	  }
	public static String removeRoute() {
		  String rid=JOptionPane.showInputDialog("Enter RouteId:");
		  return rid;
	  }
	public static RouteBean modifyRoute() {
		  String rid=JOptionPane.showInputDialog("Enter RouteId:");
		  String src=JOptionPane.showInputDialog("Enter Source:");
		  String dest=JOptionPane.showInputDialog("Enter Destination:");
		  String td=JOptionPane.showInputDialog("Enter Duration:");
        double fare=Double.parseDouble(JOptionPane.showInputDialog("Enter Fare:"));
			RouteBean rb=new RouteBean();
			rb.setRouteID(rid);
			rb.setSource(src);
			rb.setDestination(dest);
			rb.setTravelDuration(td);
			rb.setFare(fare);
	        return rb;
	  }
	public static String viewRoute() {
		  String rid=JOptionPane.showInputDialog("Enter RouteId:");
		  return rid;
	  }
}
