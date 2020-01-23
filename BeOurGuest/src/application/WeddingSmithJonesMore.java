// Libby Snedaker
// Dec 8, 2019
// this is a wedding object for one the reports that details all the smith-jones wedding vendors and the events they're working
package application;

import javafx.beans.property.SimpleStringProperty;

public class WeddingSmithJonesMore {
	private final SimpleStringProperty wedID;
	private final SimpleStringProperty wedN;
	private final SimpleStringProperty eID;
	private final SimpleStringProperty eName;
	private final SimpleStringProperty vID;
	private final SimpleStringProperty vName;
	private final SimpleStringProperty vCost;
	
	public WeddingSmithJonesMore(String weddingID, String weddingName, String eventID, String eventName, String vendorID, 
			String vendorName, String vendorCost) {
		
		this.wedID = new SimpleStringProperty(weddingID);
		this.wedN = new SimpleStringProperty(weddingName);
		this.eID = new SimpleStringProperty(eventID);
		this.eName = new SimpleStringProperty(eventName);
		this.vID = new SimpleStringProperty(vendorID);
		this.vName = new SimpleStringProperty(vendorName);
		this.vCost = new SimpleStringProperty(vendorCost);

	}
	
	public String getWedID() {
		return wedID.get();
	}
	public void setWedID(String weddingID) {
		this.wedID.set(weddingID);
	}
	public String getWedN() {
		return wedN.get();
	}
	public void setWedN(String weddingName) {
		this.wedN.set(weddingName);
	}
	public String getEID() {
		return eID.get();
	}
	public void setEID(String eventID) {
		this.eID.set(eventID);
	}
	public String getEName() {
		return eName.get();
	}
	public void setEName(String eventName) {
		this.eName.set(eventName);
	}
	public String getVID() {
		return vID.get();
	}
	public void setVID(String vendorID) {
		this.vID.set(vendorID);
	}
	public String getVName() {
		return vName.get();
	}
	public void setVName(String vendorName) {
		this.vName.set(vendorName);
	}
	public String getVCost() {
		return vCost.get();
	}
	public void setVCost(String vendorCost) {
		this.vCost.set(vendorCost);
	}
}
