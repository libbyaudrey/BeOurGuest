package application;
import javafx.beans.property.SimpleStringProperty;
//Libby Snedaker
//Dec. 9, 2019
// this class represents a wedding object that will be used to display the wedding table data in a tableview
public class Weddings {
	
	private final SimpleStringProperty wedID;
	private final SimpleStringProperty wedD;
	private final SimpleStringProperty wedN;
	private final SimpleStringProperty wedS;
	

	public Weddings(String wedID, String wedD, String wedN, String wedS) {
		this.wedID = new SimpleStringProperty(wedID);
		this.wedD = new SimpleStringProperty(wedD);
		this.wedN = new SimpleStringProperty(wedN);
		this.wedS = new SimpleStringProperty(wedS);
	}
	
	public String getWedID() {
		return wedID.get();
	}
	
	public void setWedID(String wedID) {
		this.wedID.set(wedID);
	}
	public String getWedD() {
		return wedD.get();
	}
	public void setWedD(String wedD) {
		this.wedD.set(wedD);
	}
	public String getWedN() {
		return wedN.get();
	}
	public void setWedN(String wedN) {
		this.wedN.set(wedN);
	}
	public String getWedS() {
		return wedS.get();
	}
	public void setWedS(String wedS) {
		this.wedS.set(wedS);
	}
	
	

}
