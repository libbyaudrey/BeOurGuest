//Libby Snedaker
//Dec 9, 2019
//This class creates a guest object
package application;

import javafx.beans.property.SimpleStringProperty;

public class GuestObject {
	
	// guest attributes
	private final SimpleStringProperty weddingID;
	
	private final SimpleStringProperty guestID;
	
	private final SimpleStringProperty  guestN;

	private final SimpleStringProperty guestE;

	private final SimpleStringProperty  guestP;

	private final SimpleStringProperty  guestA;
	
	private final SimpleStringProperty guestCity;
	
	private final SimpleStringProperty  guestState;
	
	private final SimpleStringProperty  guestZ;
	
	private final SimpleStringProperty dietaryR;
	
	private final SimpleStringProperty rsvpStatus;
	
	private final SimpleStringProperty tableN;
	
	
	// constructor
	public GuestObject(String weddingId, String guestId, String name, String email, String phone, String address, String city, String state,
			String zip, String dietary, String rsvp, String tableNum)
	{
		this.weddingID = new SimpleStringProperty(weddingId);
		this.guestID = new SimpleStringProperty(guestId);
		this.guestN = new SimpleStringProperty(name);
		this.guestE = new SimpleStringProperty(email);
		this.guestP = new SimpleStringProperty(phone);
		this.guestA = new SimpleStringProperty(address);
		this.guestCity = new SimpleStringProperty(city);
		this.guestState = new SimpleStringProperty(state);
		this.guestZ = new SimpleStringProperty(zip);
		this.dietaryR = new SimpleStringProperty(dietary);
		this.rsvpStatus = new SimpleStringProperty(rsvp);
		this.tableN = new SimpleStringProperty(tableNum);
				

	}

	// getters and setters for attributes
	public String getGuestID() {
		return guestID.get();
	}

	public void setGuestID(String id) {
		guestID.set(id);
	}
	
	public String getGuestCity() {
		return guestCity.get();
	}

	public void setGuestCity(String city) {
		guestCity.set(city);
	}

	public String getGuestN() {
		return guestN.get();
	}

	public void setGuestN(String name) {
		guestN.set(name);
	}

	public String getGuestE() {
		return guestE.get();
	}

	public void setGuestE(String email) {
		guestE.set(email);
	}

	public String getGuestP() {
		return guestP.get();
	}

	public void setGuestP(String phone) {
		guestP.set(phone);
	}

	public String getGuestA() {
		return guestA.get();
	}

	public void setGuestA(String address) {
		guestA.set(address);
	}

	public String getGuestState() {
		return guestState.get();
	}

	public void setGuestState(String state) {
		guestState.set(state);
	}

	public String getGuestZ() {
		return guestZ.get();
	}

	public void setGuestZ(String zip) {
		guestZ.set(zip);
	}

	public String getDietaryR() {
		return dietaryR.get();
	}

	public void setDietaryR(String dietary) {
		dietaryR.set(dietary);
	}

	public String getTableN() {
		return tableN.get();
	}

	public void setTableN(String tableNum) {
		tableN.set(tableNum);
	}

	public String getWeddingID() {
		return weddingID.get();
	}

	public void setWeddingID(String weddingId) {
		weddingID.set(weddingId);
	}

	public String getRsvpStatus() {
		return rsvpStatus.get();
	}

	public void setRsvpStatus(String rsvp) {
		rsvpStatus.set(rsvp);
	}
	
	
	
	

}
