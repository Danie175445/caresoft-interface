package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
	 private ArrayList<String> patientNotes;
		
	    // TO DO: Constructor that takes an ID Done!
	 public Physician(Integer id) {
		 super(id);
	 }
	    // TO DO: Implement HIPAACompliantUser!
		
	    public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }

		@Override
		public boolean assignPin(int pin) {
			// TODO Auto-generated method stub Done!
			if(pin <1000 || pin >9999) {
				return false;
			}
			this.pin = pin;
			return true;
		}

		@Override
		public boolean accessAuthorized(Integer confirmedAuthID) {
			// TODO Auto-generated method stub
			if(id == confirmedAuthID) {
				return true;
			}
			return false;
		}
		
	    // TO DO: Setters & Getters
}
