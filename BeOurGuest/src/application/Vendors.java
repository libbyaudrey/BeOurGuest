//Libby Snedaker
//Dec. 9, 2019
// this class represents a wedding vendor object that will be used to display the vendor table data in a tableview
package application;

import javafx.beans.property.SimpleStringProperty;

public class Vendors {
	private final SimpleStringProperty wedID;
	private final SimpleStringProperty vendorID;
	private final SimpleStringProperty vName;
	private final SimpleStringProperty vEmail;
	private final SimpleStringProperty vPhone;
	private final SimpleStringProperty eventID;
	private final SimpleStringProperty vCost;
	

	public Vendors(String weddingId, String vendID, String vendN, String vendE, String vendP, String eventId, String vendC) {
		this.wedID = new SimpleStringProperty(weddingId);
		this.vendorID = new SimpleStringProperty(vendID);
		this.vName = new SimpleStringProperty(vendN);
		this.vEmail = new SimpleStringProperty(vendE);
		this.vPhone = new SimpleStringProperty(vendP);
		this.eventID = new SimpleStringProperty(eventId);
		this.vCost = new SimpleStringProperty(vendC);
	}


	public String getWedID() {
		return wedID.get();
	}
	
	public void setWedID(String weddingId) {
		wedID.set(weddingId);
	}

	public String getVendorID() {
		return vendorID.get();
	}
	public void setVendorID(String vendID) {
		vendorID.set(vendID);
	}


	public String getVName() {
		return vName.get();
	}
	public void setVName(String vendN) {
		vName.set(vendN);
	}


	public String getVEmail() {
		return vEmail.get();
	}
	public void setVEmail(String vendE) {
		vEmail.set(vendE);
	}


	public String getVPhone() {
		return vPhone.get();
	}
	public void setVPhone(String vendP) {
		vPhone.set(vendP);
	}


	public String getEventID() {
		return eventID.get();
	}
	public void setEventID(String eventId) {
		eventID.set(eventId);
	}


	public String getVCost() {
		return vCost.get();
	}
	
	public void setVCost(String vendC) {
		vCost.set(vendC);
	}
}

