package com.hm.hb.ui;

import javax.swing.JOptionPane;

import com.hm.hb.bean.ProfileBean;

public class Profile {
	public static ProfileBean registerUser() {
		String uid=JOptionPane.showInputDialog("Enter UserId:");
		String fname=JOptionPane.showInputDialog("Enter FirstName:");
		String lname=JOptionPane.showInputDialog("Enter LastName:");
		String dob=JOptionPane.showInputDialog("Enter DOB:");
		String gender=JOptionPane.showInputDialog("Enter Gender:");
		String street=JOptionPane.showInputDialog("Enter Street:");
		String loc=JOptionPane.showInputDialog("Enter Location:");
		String city=JOptionPane.showInputDialog("Enter City:");
		String state=JOptionPane.showInputDialog("Enter State:");
		String pin=JOptionPane.showInputDialog("Enter Pincode:");
		String phn=JOptionPane.showInputDialog("Enter MobileNo:");
        String mail=JOptionPane.showInputDialog("Enter EmailId:");
		String pwd=JOptionPane.showInputDialog("Enter Password:");
		ProfileBean pb=new ProfileBean();
		pb.setUserID(uid);
		pb.setFirstName(fname);
		pb.setLastName(lname);
		pb.setDateOfBirth(dob);
		pb.setGender(gender);
		pb.setStreet(street);
		pb.setLocation(loc);
		pb.setCity(city);
		pb.setState(state);
		pb.setPincode(pin);
		pb.setMobileNo(phn);
		pb.setEmailID(mail);
		pb.setPassword(pwd);
		return pb;
		


		
	}

}
