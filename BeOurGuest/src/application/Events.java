package application;

import javafx.beans.property.SimpleStringProperty;

public class Events {

	private final SimpleStringProperty wedID;
	private final SimpleStringProperty eventID;
	private final SimpleStringProperty eventD;
	private final SimpleStringProperty eventAdd;
	private final SimpleStringProperty eventCity;
	private final SimpleStringProperty eventState;
	private final SimpleStringProperty eventZip;
	private final SimpleStringProperty eventName;
	

	public Events(String wID, String eID, String eDate, String eAdd, String eCity, String eState, String eZip, String eName) {
		this.wedID = new SimpleStringProperty(wID);
		this.eventID = new SimpleStringProperty(eID);
		this.eventD = new SimpleStringProperty(eDate);
		this.eventAdd = new SimpleStringProperty(eAdd);
		this.eventCity = new SimpleStringProperty(eCity);
		this.eventState = new SimpleStringProperty(eState);
		this.eventZip = new SimpleStringProperty(eZip);
		this.eventName = new SimpleStringProperty(eName);
	}
	
	public String getEventID() {
		return eventID.get();
	}
	
	public void setEventID(String eID) {
		wedID.set(eID);
	}


	public String getWedID() {
		return wedID.get();
	}
	
	public void setWedID(String wID) {
		wedID.set(wID);
	}


	public String getEventD() {
		return eventD.get();
	}
	
	public void setEventD(String eDate) {
		eventD.set(eDate);
	}


	public String getEventAdd() {
		return eventAdd.get();
	}
	
	public void setEventAdd(String eAdd) {
		eventAdd.set(eAdd);
	}


	public String getEventState() {
		return eventState.get();
	}
	
	public void setEventState(String eState) {
		eventState.set(eState);
	}
	
	public String getEventCity() {
		return eventCity.get();
	}
	
	public void setEventCity(String eCity) {
		eventCity.set(eCity);
	}


	public String getEventZip() {
		return eventZip.get();
	}
	
	public void setEventZip(String eZip) {
		eventZip.set(eZip);
	}


	public String getEventName() {
		return eventName.get();
	}
	
	public void setEventName(String eName) {
		eventName.set(eName);
	}

}
