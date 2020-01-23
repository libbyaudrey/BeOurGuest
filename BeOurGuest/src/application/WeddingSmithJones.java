// Libby Snedaker
// Dec 8, 2019
// this is a wedding object for one the reports that details all the smith-jones wedding guests and their rsvp status
package application;

import javafx.beans.property.SimpleStringProperty;

public class WeddingSmithJones {
	
	private final SimpleStringProperty wedID;
	private final SimpleStringProperty wedN;
	private final SimpleStringProperty gName;
	private final SimpleStringProperty rsvp;
	
	public WeddingSmithJones(String weddingID, String weddingName, String guestName, String rsvpStatus) {
		
		this.wedID = new SimpleStringProperty(weddingID);
		this.wedN = new SimpleStringProperty(weddingName);
		this.gName = new SimpleStringProperty(guestName);
		this.rsvp = new SimpleStringProperty(rsvpStatus);
				
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
	public String getGName() {
		return gName.get();
	}
	public void setGName(String guestName) {
		this.gName.set(guestName);
	}
	public String getRsvp() {
		return rsvp.get();
	}
	public void setRsvp(String rsvpStatus) {
		this.rsvp.set(rsvpStatus);
	}
	

}
