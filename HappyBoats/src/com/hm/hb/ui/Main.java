package com.hm.hb.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;  

import javax.swing.JOptionPane;

import com.hm.hb.bean.PassengerBean;
import com.hm.hb.bean.ProfileBean;
import com.hm.hb.bean.ReservationBean;
import com.hm.hb.bean.RouteBean;
import com.hm.hb.bean.ScheduleBean;
import com.hm.hb.bean.ShipBean;
import com.hm.hb.dao.AdministratorDao;
import com.hm.hb.dao.CustomerDao;



public class Main {

	public static void main(String[] args) {
		AdministratorDao adao=new AdministratorDao();
		CustomerDao cdao=new CustomerDao();
		String userid=JOptionPane.showInputDialog("Enter UserID");
		String password=JOptionPane.showInputDialog("Enter Password");
		String userType=JOptionPane.showInputDialog("Enter userType");
//--------AD-001----ADDShip-----------------------		
		if((userid.equals("AD-001")&&(password.equals("AD-001")&&(userType.equals("A")))))
		{
			ShipBean sb=Ship.addShip();
			String status=adao.addShip(sb);
			if(status.equals("Success"))
				JOptionPane.showMessageDialog(null, "Inserted Successfully");
			else
				JOptionPane.showMessageDialog(null, "Inserted Failure");
        }
//----------AD-002--------REMOVESHIP-------------------------		
		else if((userid.equals("AD-002")&&(password.equals("AD-002")&&(userType.equals("A"))))) 
		{
			ArrayList<String> sidlist=Ship.removeShip();
			int i=adao.removeShip(sidlist);
			if(i==1) 
			    JOptionPane.showMessageDialog(null, "Removed Successfully");	
			else
				JOptionPane.showMessageDialog(null, "Failure");	

		}
//AD-003-----------------------VIEWSHIP-------------------		
		else if((userid.equals("AD-003")&&(password.equals("AD-003")&&(userType.equals("A"))))) 
		{
			int useroption=Integer.parseInt(JOptionPane.showInputDialog("Hi Admin!!Select Option-1 to view all records or Option-2 to view a particular record"));
			switch(useroption) {
			case 1: ArrayList<ShipBean> shiplist=adao.viewByAllShips();
			String str="";
			for(ShipBean sb:shiplist) {
			str+=sb.getShipID()+" "+sb.getShipName()+" "+sb.getSeatingCapacity()+" "+sb.getReservationCapacity()+"\n";	
			}
			JOptionPane.showMessageDialog(null, str);
			break;
			case 2: String ShipId=Ship.viewShip();
				ShipBean sb=adao.viewByShipId(ShipId);
				JOptionPane.showMessageDialog(null,sb.getShipID()+" "+sb.getShipName()+" "+sb.getSeatingCapacity()+" "+sb.getReservationCapacity());
				break;

		}
}
//AD-004----------------------MODIFYSHIP----------------------------		
  else if((userid.equals("AD-004")&&(password.equals("AD-004")&&(userType.equals("A"))))) 
  {
			ShipBean sb=Ship.modifyShip();
			boolean flag=adao.modifyShip(sb);
			if(flag)
				JOptionPane.showMessageDialog(null, "Updated Succesful");
			else
				JOptionPane.showMessageDialog(null, "Failure");	
  }
//AD-005---------------------ADDROUTE------------		
  else if((userid.equals("AD-005")&&(password.equals("AD-005")&&(userType.equals("A"))))) 
  {
	  RouteBean rb=Route.addRoute();
	  String status=adao.addRoute(rb);
	  if(status.equals("Success"))
		    JOptionPane.showMessageDialog(null, "Inserted Successfully");
	  else
			JOptionPane.showMessageDialog(null, "Inserted Failure");
 
}
//AD-006-----------------------REMOVEROUTE--------------		
  else if((userid.equals("AD-006")&&(password.equals("AD-006")&&(userType.equals("A"))))) {
	  String rid=Route.removeRoute();
	  int i=adao.removeRoute(rid);
	  if(i==1)
		JOptionPane.showMessageDialog(null, "Deleted Successfully");
	  else
			JOptionPane.showMessageDialog(null, "Deleted Failure");

 }
//AD-007------------------------------VIEWROUTE-------------------		
  else if((userid.equals("AD-007")&&(password.equals("AD-007")&&(userType.equals("A"))))) {
	  int useroption=Integer.parseInt(JOptionPane.showInputDialog("Hi Admin!!Select Option-1 to view all records or Option-2 to view a particular record"));
		switch(useroption) {  
        case 1:ArrayList<RouteBean> routelist=adao.viewByAllRoutes();
		String str="";
		for(RouteBean rb:routelist) 
		{
		str+=rb.getRouteID()+" "+rb.getSource()+" "+rb.getDestination()+" "+rb.getTravelDuration()+" "+rb.getFare()+"\n";	
		}
		JOptionPane.showMessageDialog(null, str);
		break;
        case 2: String rid=Route.viewRoute();
        	RouteBean rb=adao.viewByRouteId(rid);
        	JOptionPane.showMessageDialog(null, rb.getRouteID()+" "+rb.getSource()+" "+rb.getDestination()+" "+rb.getTravelDuration()+" "+rb.getFare()+"\n");
        	break;
		}
	}
//AD-008------------------------------MODIFY ROUTE-------------------		
		
  else if((userid.equals("AD-008")&&(password.equals("AD-008")&&(userType.equals("A"))))) {

		RouteBean rb=Route.modifyRoute();
		boolean flag=adao.modifyRoute(rb);
		if(flag)
		       JOptionPane.showMessageDialog(null, "Updated Successfull");
		else
			   JOptionPane.showMessageDialog(null, "Updated Fail");

  }
//AD-009------------------------------ADD SCHEDULE-------------------		
		
  else if((userid.equals("AD-009")&&(password.equals("AD-009")&&(userType.equals("A"))))) {
	  ScheduleBean scb=Schedule.addSchedule();
	 String status= adao.addSchedule(scb);
	 if(status.equals("Success"))
		JOptionPane.showMessageDialog(null, "Inserted Successfull");
	 else
			JOptionPane.showMessageDialog(null, "Inserted Fail");

  }
//AD-010------------------------------REMOVE SCHEDULE-------------------		

  else if((userid.equals("AD-010")&&(password.equals("AD-010")&&(userType.equals("A"))))) {
	  ArrayList<String> scidlist=Schedule.removeSchedule();
	  int i=adao.removeSchedule(scidlist);
	  if(i==1)
	      JOptionPane.showMessageDialog(null, "Deleted Successful");
	  else
		  JOptionPane.showMessageDialog(null, "Deleted Fail");
}
//AD-011------------------------------VIEW SCHEDULE-------------------		

  else if((userid.equals("AD-011")&&(password.equals("AD-011")&&(userType.equals("A"))))) {
	  int useroption=Integer.parseInt(JOptionPane.showInputDialog("Hi Admin!!Select Option-1 to view all records or Option-2 to view a particular record"));
		switch(useroption) {
		case 1 :ArrayList<ScheduleBean>slist=adao.viewByAllSchedules();
		String str="";
		for(ScheduleBean sb:slist) {
			str+=sb.getScheduleID()+" "+sb.getShipID()+" "+sb.getRouteID()+" "+sb.getStartDate()+"\n";
		}
		JOptionPane.showMessageDialog(null, str);
		break;
		case 2:String scid=Schedule.viewSchedule();
		ScheduleBean scb=adao.viewByScheduleId(scid);
		JOptionPane.showMessageDialog(null, scb.getScheduleID()+" "+scb.getShipID()+" "+scb.getRouteID()+" "+scb.getStartDate()+"\n");
		break;
		}
	}
//AD-012------------------------------MODIFY SCHEDULE-------------------		
		
else if((userid.equals("AD-012")&&(password.equals("AD-012")&&(userType.equals("A"))))) {
	ScheduleBean scb=Schedule.modifySchedule();
	boolean flag=adao.modifySchedule(scb);
	if(flag)
	    JOptionPane.showMessageDialog(null, "Updated Successfully");
	else
		JOptionPane.showMessageDialog(null, "Updated Failure");

}
//AD-013------------------------------VIEW PASSENGER-------------------		

else if((userid.equals("AD-013")&&(password.equals("AD-013")&&(userType.equals("A"))))) {
	int useroption=Integer.parseInt(JOptionPane.showInputDialog("Hi Admin!!Select Option-1 to view all records or Option-2 to view a particular record"));
	switch(useroption) {
	case 1:ArrayList<PassengerBean> plist=adao.viewByAllPassengers();
	String s="";
	for(PassengerBean pb:plist) {
		s+=pb.getReservationID()+" "+pb.getScheduleID()+" "+pb.getName()+" "+pb.getAge()+" "+pb.getGender()+"\n";
	}
	JOptionPane.showMessageDialog(null, s);
	break;
	case 2:String scheduleid=JOptionPane.showInputDialog("Enter ScheduleId:");
		ArrayList<PassengerBean> plistbyid=adao.viewPasengersByShip(scheduleid);
	String str="";
	for(PassengerBean pb:plistbyid) {
		str+=pb.getScheduleID()+" "+pb.getReservationID()+" "+pb.getName()+" "+pb.getAge()+" "+pb.getGender()+"\n";
	}
	JOptionPane.showMessageDialog(null, str);
	break;
	}
	}
//---------------------------------UserFunctions-----------------------------------//
	//US-001--------------REGISTER-----------	
else if((userid.equals("US-001")&&(password.equals("US-001")&&(userType.equals("C"))))) {

      ProfileBean pb=Profile.registerUser();
      String status=cdao.registerUser(pb);
      if(status.equals("Success"))
    	  JOptionPane.showMessageDialog(null, "User Registered Successfully");
      else
    	  JOptionPane.showMessageDialog(null, "User Registered Failed");
}
//----------US-002------------VIEW SCHEDULEBY ROUTE----------		
else if((userid.equals("US-002")&&(password.equals("US-002")&&(userType.equals("C"))))) {
	String source=JOptionPane.showInputDialog("Enter Source");
	String destination=JOptionPane.showInputDialog("Enter Destination");
	String date=JOptionPane.showInputDialog("Enter Date");
	ArrayList<ScheduleBean> slist=cdao.viewScheduleByRoute(source, destination,date);
	String str="";
	for(ScheduleBean sb:slist) {
		str+=sb.getScheduleID()+" "+sb.getShipID()+" "+sb.getRouteID()+" "+sb.getStartDate()+"\n";

	}
	JOptionPane.showMessageDialog(null, str);
	}
//--------US-003----------RESERVE TICKET----------------		
else if((userid.equals("US-003")&&(password.equals("US-003")&&(userType.equals("C"))))) {
	ReservationBean rb=Reservation.addReservation();
	ArrayList<PassengerBean>plist=adao.viewByAllPassengers();
	String status=cdao.reserveTicket(rb, plist);
	if(status.equals("Success"))
		
		JOptionPane.showMessageDialog(null, "Your Ticket Reservation is Successfull");
	else
		JOptionPane.showMessageDialog(null, "Oops!!Error Occurred!Please try again");

}
//-------------US-004------------CANCEL TICKET----------------------------		
else if((userid.equals("US-004")&&(password.equals("US-004")&&(userType.equals("C"))))) {
	String rid=JOptionPane.showInputDialog("Enter ReservationId");
    boolean flag=cdao.cancelTicket(rid);
    if(flag)
    	JOptionPane.showMessageDialog(null, "Your ticket is Succesfully Cancelled!!");
    else
    	JOptionPane.showMessageDialog(null, "Oops!!Error Occurred!Please try again");

}
//-----------US-005-------------------VIEW TICKET-------------------------
else if((userid.equals("US-005")&&(password.equals("US-005")&&(userType.equals("C"))))) {
	String rid=JOptionPane.showInputDialog("Enter ReservationId");
	Map<ReservationBean,PassengerBean> map=cdao.viewTicket(rid);
	for(Map.Entry<ReservationBean, PassengerBean> m:map.entrySet())
	{
		String str="";
		str+=m.getKey().getReservationID()+" "+m.getKey().getScheduleID()+" "+m.getKey().getUserID()+" "+m.getKey().getBookingDate()+" "+m.getKey().getJourneyDate()+" "+m.getKey().getNoOfSeats()+" "+m.getKey().getTotalFare()+" "+m.getKey().getBookingStatus()
				+"\n"+m.getValue().getReservationID()+" "+m.getValue().getScheduleID()+" "+m.getValue().getName()+" "+m.getValue().getAge()+" "+m.getValue().getGender()+"\n";
				;
		JOptionPane.showMessageDialog(null, str);
		
	}
}
//-------------------US-006	---------------------------PRINT TICKET--------------------------	
	else if((userid.equals("US-006")&&(password.equals("US-006")&&(userType.equals("C"))))) {
		String rid=JOptionPane.showInputDialog("Enter ReservationId");
		Map<ReservationBean,PassengerBean> map=cdao.viewTicket(rid);
		Document doc = new Document();
		String str = "";
		try {
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
		"C:\\Users\\kranthi.lekha\\HappyBoats\\Ticket.pdf"));
		doc.open();
		for (Map.Entry<ReservationBean, PassengerBean> m : map.entrySet()) {
		str += "ReservationID: " + m.getKey().getReservationID() + "\nScheduleID: "
		+ m.getKey().getScheduleID() + "\nUserID: " + m.getKey().getUserID() + "\nBooking Date: "
		+ m.getKey().getBookingDate() + "\nJourney Date: " + m.getKey().getJourneyDate()
		+ "\nNo.of Seats: " + m.getKey().getNoOfSeats() + "\nTotal Fare: " + m.getKey().getTotalFare()
		+ "\nBooking Status: " + m.getKey().getBookingStatus() + "\n" + "Reservation ID: "
		+ m.getValue().getReservationID() + "\nSchedule ID: " + m.getValue().getScheduleID()
		+ "\nPassenger Name: " + m.getValue().getName() + "\nPassenger Age: " + m.getValue().getAge()
		+ "\nPasseneger Gender: " + m.getValue().getGender() + "\n";
		;
		}
		doc.add(new Paragraph(str));
		JOptionPane.showMessageDialog(null, "PDF is generated !!!");

		doc.close();
		writer.close();
		} catch (DocumentException e) {
		e.printStackTrace();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}

	}
	}
}





