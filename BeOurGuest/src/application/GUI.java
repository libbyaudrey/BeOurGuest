// Libby Snedaker
// Dec. 9, 2019
// main GUI for Be Our Guest w/tab views
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

import java.time.format.DateTimeFormatter;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI extends Application {
	
	// scenes
	Scene scene1;
	Stage window1;
	
	// observablelists for the 4 tabs
	final ObservableList weddingData = FXCollections.observableArrayList();
	final ObservableList guestData = FXCollections.observableArrayList();
	final ObservableList vendorData = FXCollections.observableArrayList();
	final ObservableList eventsData = FXCollections.observableArrayList();
	final ObservableList weddingReport1Data = FXCollections.observableArrayList();
	final ObservableList weddingReport2Data = FXCollections.observableArrayList();
	
	// class variables
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con= null; 
	
	// table variables
	TableView<Weddings> wedTable;
	TableView<GuestObject> guestTable;
	TableView<Vendors> vendorTable;
	TableView<Events> eventsTable;
	TableView<WeddingSmithJones> wedReport1Table;
	TableView<WeddingSmithJonesMore> wedReport2Table;
	
	
	// set up the GUI layout
	@Override
    public void start(Stage primaryStage) { 
		
		fillComboBoxT1();
		fillComboBoxT2();
		fillComboBoxT3();
		fillComboBoxT4();
		
				
    	window1 = primaryStage;
    	
    	// create font object w/specific font type and size
    	Font myFont = new Font ("Times New Roman", 16);
    	Font myFont2 = new Font ("Times New Roman", 14);

    	    	    	
    	// create text fields for weddings
    	TextField field1 = new TextField();
    	field1.setEditable(true);
    	field1.setPrefColumnCount(20);
    	TextField field2 = new TextField();
    	field2.setEditable(true);
    	field2.setPrefColumnCount(20);
    	TextField field3 = new TextField();
    	field3.setEditable(true);
    	field3.setPrefColumnCount(20);
    	TextField field4 = new TextField();
    	field4.setEditable(true);
    	field4.setPrefColumnCount(20);
    	
    	// make combobox for wedding tab
    	ComboBox<String> comboBoxT1 = new ComboBox(weddingData);
    	comboBoxT1.setMaxHeight(50);
    	comboBoxT1.setOnAction(e -> {
    		
    		try { 
    			
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
    			    			String sql = "SELECT* FROM LsWedding WHERE WeddingName = ?";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, (String)comboBoxT1.getSelectionModel().getSelectedItem());
    			rs=pst.executeQuery();
    			    			   			
    			while(rs.next()) {
    				field1.setText(rs.getString(1));
    				field2.setText(rs.getString(2));
    				field3.setText(rs.getString(3));
    				field4.setText(rs.getString(4));
 		
    			}
    			
    			pst.close();
    			rs.close();
    	
    		}
    		 catch (Exception e1) {
    			e1.printStackTrace();
    		
    		 }
    		
    	});
    	
    	
    	
    	// create text fields for guests
    	TextField field5 = new TextField();
    	field5.setEditable(true);
    	field5.setPrefColumnCount(20);
    	TextField field6 = new TextField();
    	field6.setEditable(true);
    	field6.setPrefColumnCount(20);
    	TextField field7 = new TextField();
    	field7.setEditable(true);
    	field7.setPrefColumnCount(20);
    	TextField field8 = new TextField();
    	field8.setEditable(true);
    	field8.setPrefColumnCount(20);
    	TextField field9 = new TextField();
    	field9.setEditable(true);
    	field9.setPrefColumnCount(20);
    	TextField field10 = new TextField();
    	field10.setEditable(true);
    	field10.setPrefColumnCount(20);
    	TextField field11 = new TextField();
    	field11.setEditable(true);
    	field11.setPrefColumnCount(20);
    	TextField field12 = new TextField();
    	field12.setEditable(true);
    	field12.setPrefColumnCount(20);
    	TextField field13 = new TextField();
    	field13.setEditable(true);
    	field13.setPrefColumnCount(20);
    	TextField field14 = new TextField();
    	field14.setEditable(true);
    	field14.setPrefColumnCount(20);
    	TextField field15 = new TextField();
    	field15.setEditable(true);
    	field15.setPrefColumnCount(20);
    	TextField field16 = new TextField();
    	field16.setEditable(true);
    	field16.setPrefColumnCount(20);
    
    	
    	// make combobox for guest tab
    	ComboBox<String> comboBoxT2 = new ComboBox(guestData);
    	comboBoxT2.setMaxHeight(50);
    	comboBoxT2.setOnAction(e -> {
    		
    		try { 
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
    			
    			String sql = "SELECT* FROM LsGuest WHERE GName = ?";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, (String)comboBoxT2.getSelectionModel().getSelectedItem());
    			rs=pst.executeQuery();
    			
    			while(rs.next()) {
    				field5.setText(rs.getString(1));
    				field6.setText(rs.getString(2));
    				field7.setText(rs.getString(3));
    				field8.setText(rs.getString(4));
    				field9.setText(rs.getString(5));
    				field10.setText(rs.getString(6));
    				field11.setText(rs.getString(7));
    				field12.setText(rs.getString(8));
    				field13.setText(String.valueOf(rs.getInt(9)));
    				field14.setText(rs.getString(10));
    				field15.setText(rs.getString(11));
    				field16.setText(String.valueOf(rs.getInt(12)));
 		
    			}
    			pst.close();
    			rs.close();
    		}
    		 catch (Exception e1) {
    			e1.printStackTrace();
    		
    		 }
    		
    	});
    	
    	// create text fields for vendors
    	TextField field17 = new TextField();
    	field17.setEditable(true);
    	field17.setPrefColumnCount(20);
    	TextField field18 = new TextField();
    	field18.setEditable(true);
    	field18.setPrefColumnCount(20);
    	TextField field19 = new TextField();
    	field19.setEditable(true);
    	field19.setPrefColumnCount(20);
    	TextField field20 = new TextField();
    	field20.setEditable(true);
    	field20.setPrefColumnCount(20);
    	TextField field21 = new TextField();
    	field21.setEditable(true);
    	field21.setPrefColumnCount(20);
    	TextField field22 = new TextField();
    	field22.setEditable(true);
    	field22.setPrefColumnCount(20);
    	TextField field23 = new TextField();
    	field23.setEditable(true);
    	field23.setPrefColumnCount(20);
    	
    	// make combobox for vendor tab
    	ComboBox<String> comboBoxT3 = new ComboBox(vendorData);
    	comboBoxT3.setMaxHeight(50);
    	comboBoxT3.setOnAction(e -> {
    		
    		try { 
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
    			
    			String sql = "SELECT* FROM LsVendor WHERE VName = ?";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, (String)comboBoxT3.getSelectionModel().getSelectedItem());
    			rs=pst.executeQuery();
    			
    			while(rs.next()) {
    				field17.setText(rs.getString(1));
    				field18.setText(rs.getString(2));
    				field19.setText(rs.getString(3));
    				field20.setText(rs.getString(4));
    				field21.setText(rs.getString(5));
    				field22.setText(rs.getString(6));
    				field23.setText(String.valueOf(rs.getDouble(7)));
    				 		
    			}
    			pst.close();
    			rs.close();
    		}
    		 catch (Exception e1) {
    			e1.printStackTrace();
    		
    		 }
    		
    	});
    	
    	// create text fields for events
    	TextField field24 = new TextField();
    	field24.setEditable(true);
    	field24.setPrefColumnCount(20);
    	TextField field25 = new TextField();
    	field25.setEditable(true);
    	field25.setPrefColumnCount(20);
    	TextField field26 = new TextField();
    	field26.setEditable(true);
    	field26.setPrefColumnCount(20);
    	TextField field27 = new TextField();
    	field27.setEditable(true);
    	field27.setPrefColumnCount(20);
    	TextField field28 = new TextField();
    	field28.setEditable(true);
    	field28.setPrefColumnCount(20);
    	TextField field29 = new TextField();
    	field29.setEditable(true);
    	field29.setPrefColumnCount(20);
    	TextField field30 = new TextField();
    	field30.setEditable(true);
    	field30.setPrefColumnCount(20);
    	TextField field31 = new TextField();
    	field31.setEditable(true);
    	field31.setPrefColumnCount(20);
    	
       	
    	// make combobox for events tab
    	ComboBox<String> comboBoxT4 = new ComboBox(eventsData);
    	comboBoxT4.setMaxHeight(50);
    	comboBoxT4.setOnAction(e -> {
    		
    		try { 
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
    			
    			String sql = "SELECT* FROM LsEvents WHERE EName = ?";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, (String)comboBoxT4.getSelectionModel().getSelectedItem());
    			rs=pst.executeQuery();
    			
    			while(rs.next()) {
    				field24.setText(rs.getString(1));
    				field25.setText(rs.getString(2));
    				field26.setText(String.valueOf(rs.getDate(3)));
    				field27.setText(rs.getString(4));
    				field28.setText(rs.getString(5));
    				field29.setText(rs.getString(6));
    				field30.setText(String.valueOf(rs.getInt(7)));
    				field31.setText(rs.getString(8));
    				 		
    			}
    			pst.close();
    			rs.close();
    		}
    		 catch (Exception e1) {
    			e1.printStackTrace();
    		
    		 }
    		
    	});    	
    	
      	
    	// create labels for wedding attributes
    	Label labelF1 = new Label("Wedding ID: ");
    	labelF1.setFont(myFont2);
    	Label labelF2 = new Label("Wedding Date: ");
    	labelF2.setFont(myFont2);
    	Label labelF3 = new Label("Wedding Name: ");
    	labelF3.setFont(myFont2);
    	Label labelF4 = new Label("Wedding State: ");
    	labelF4.setFont(myFont2);
    	
    	// create labels for guest attributes
    	Label labelF5 = new Label("Wedding ID: ");
    	labelF5.setFont(myFont2);
    	Label labelF6 = new Label("Guest ID: ");
    	labelF6.setFont(myFont2);
    	Label labelF7 = new Label("Guest Name: ");
    	labelF7.setFont(myFont2);
    	Label labelF8 = new Label("Guest Email: ");
    	labelF8.setFont(myFont2);
    	Label labelF9 = new Label("Guest Phone #: ");
    	labelF9.setFont(myFont2);
    	Label labelF10 = new Label("Guest Address: ");
    	labelF10.setFont(myFont2);
    	Label labelF11 = new Label("Guest City: ");
    	labelF11.setFont(myFont2);
    	Label labelF12 = new Label("Guest State: ");
    	labelF12.setFont(myFont2);
    	Label labelF13 = new Label("Guest Zipcode: ");
    	labelF13.setFont(myFont2);
    	Label labelF14 = new Label("Dietary Restriction(s): ");
    	labelF14.setFont(myFont2);
    	Label labelF15 = new Label("RSVP Status: ");
    	labelF15.setFont(myFont2);
    	Label labelF16 = new Label("Table Number: ");
    	labelF16.setFont(myFont2);
    	
       	
    	// create labels for vendor attributes
    	Label labelF17 = new Label("Wedding ID: ");
    	labelF17.setFont(myFont2);
    	Label labelF18 = new Label("Vendor ID: ");
    	labelF18.setFont(myFont2);
    	Label labelF19 = new Label("Vendor Name: ");
    	labelF19.setFont(myFont2);
    	Label labelF20 = new Label("Vendor Email: ");
    	labelF20.setFont(myFont2);
    	Label labelF21 = new Label("Vendor Phone #: ");
    	labelF21.setFont(myFont2);
    	Label labelF22 = new Label("Event ID: ");
    	labelF22.setFont(myFont2);
    	Label labelF23 = new Label("Vendor Cost: ");
    	labelF23.setFont(myFont2);
    	
    	// create labels for events attributes
    	Label labelF24 = new Label("Event ID: ");
    	labelF24.setFont(myFont2);
    	Label labelF25 = new Label("Wedding ID: ");
    	labelF25.setFont(myFont2);
    	Label labelF26 = new Label("Event Date: ");
    	labelF26.setFont(myFont2);
    	Label labelF27 = new Label("Event Address: ");
    	labelF27.setFont(myFont2);
    	Label labelF28 = new Label("Event City: ");
    	labelF28.setFont(myFont2);
    	Label labelF29 = new Label("Event State: ");
    	labelF29.setFont(myFont2);
    	Label labelF30 = new Label("Event Zip: ");
    	labelF30.setFont(myFont2);
    	Label labelF31 = new Label("Event Name: ");
    	labelF31.setFont(myFont2);
    	
    	// labels for comboboxes
    	Label labelC32 = new Label("Select a Wedding: ");
    	labelC32.setFont(myFont);
    	Label labelC33 = new Label("Select a Wedding Guest ");
    	labelC33.setFont(myFont);
    	Label labelC34 = new Label("Select a Wedding Vendor: ");
    	labelC34.setFont(myFont);
    	Label labelC35 = new Label("Select a Wedding Event : ");
    	labelC35.setFont(myFont);
    	
     
    	// wedding tab/tab 1 buttons and actions
    	Button deleteB1 = new Button("Delete");
	    deleteB1.setFont(myFont);
	    deleteB1.setPrefWidth(100);
	    deleteB1.setOnAction(e -> {
	     	Stage window2 = new Stage();
	    
	    	window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Deleting a Wedding");
	 		window2.setMinWidth(800);
	    	
	    	try {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	    		String deleteWedSQL = "DELETE FROM LsWedding WHERE WeddingName =?";
	    		pst = con.prepareStatement(deleteWedSQL);
	    		pst.setString(1, field3.getText());
	    		pst.executeUpdate();
	    		
	    		pst.close();
	    		
	    		Button close = new Button("Close");
		 		close.setOnAction(action2 -> window2.close());
		 		
		 		Label success = new Label("You have successfully deleted the " + field3.getText() + " wedding." 
		 				+ "Please close this window and press Display All button to view the updated wedding list.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	    		
	    	} catch (Exception e1) {
 				Stage window2Bad = new Stage();
 		 		
 				window2Bad.initModality(Modality.APPLICATION_MODAL);
 				window2Bad.setTitle("Deleting a Wedding");
 				window2Bad.setMinWidth(800);
 				
 				Button close = new Button("Close");
		 		close.setOnAction(action -> window2Bad.close());
 				
 				Label fail = new Label("There was a problem deleting the " + field3.getText() + " wedding. "
 						+ "Please make sure there are no guests added to this wedding before you delete it.");
 				
 				VBox layout = new VBox();
		 		layout.getChildren().addAll(fail, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2Bad.setScene(scene);
		 		window2Bad.showAndWait();
		 		
 				e1.printStackTrace();
 			}
	    });
	    Button displayAllB1 = new Button("Display All");
	    displayAllB1.setOnAction(e -> viewWeddings("View All Weddings", "Here are all the weddings you're managing."));
	    displayAllB1.setFont(myFont);
	    displayAllB1.setPrefWidth(100);
	    Button addB1 = new Button("Add");
	    addB1.setFont(myFont);
	    addB1.setPrefWidth(100);
	    addB1.setOnAction(action -> {
	    	
	      	
	    	Stage window2 = new Stage();
	 		
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Adding a New Wedding");
	 		window2.setMinWidth(800);
	    	
	    	String insertWedSQL = "INSERT INTO LsWedding (WeddingID, WeddingDate, WeddingName, WeddingState) "
	    			+ "VALUES ('" + field1.getText() +"', '" + field2.getText() +"', '" + field3.getText() +"', '" + field4.getText() +"')";
	 		
	 		
	    	try { 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	 			Statement statement=con.createStatement();
	 			
	 			rs=statement.executeQuery(insertWedSQL);
	 			
	 			Button close = new Button("Close");
		 		close.setOnAction(e -> window2.close());
		 		
		 		Label success = new Label("You have successfully added a new wedding. "
		 				+ "Please close this window and press Display All button to view your newly added wedding." 
		 				+ "If you would like to make changes to this wedding, please exit the application and it will be available in the drop down.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	 		 			
	 			} catch (Exception e1) {
	 				Stage window2Bad = new Stage();
	 		 		
	 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 				window2Bad.setTitle("Adding a New Wedding");
	 				window2Bad.setMinWidth(800);
	 				
	 				Button close = new Button("Close");
			 		close.setOnAction(e -> window2Bad.close());
	 				
	 				Label fail = new Label("There was a problem adding the new wedding. Please make sure you are adding valid inputs and try again.");
	 				
	 				VBox layout = new VBox();
			 		layout.getChildren().addAll(fail, close);
			 		layout.setAlignment(Pos.CENTER);
			 		
			 		Scene scene = new Scene(layout);
			 		window2Bad.setScene(scene);
			 		window2Bad.showAndWait();
			 		
	 				e1.printStackTrace();
	 			}
	    	
	    });
	    Button updateB1 = new Button("Update");
	    updateB1.setFont(myFont);
	    updateB1.setPrefWidth(100);
	    updateB1.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	    	
	 		
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Updating a Wedding");
	 		window2.setMinWidth(800);
	    	
	    	String updateWedSQL = "UPDATE LsWedding SET WeddingID=?, WeddingDate=?, WeddingName=?, WeddingState=? "
	    			+ "WHERE WeddingName = '"+field3.getText() +"'";	    	
	
	    	try { 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				
	 		 	pst = con.prepareStatement(updateWedSQL);
	 		 	
	 		 	pst.setString(1, field1.getText());
	 		 	pst.setString(2, field2.getText());
	 		 	pst.setString(3, field3.getText());
	 		 	pst.setString(4, field4.getText());
	 		 
	 		 	pst.execute();
	 		 	
	 		 	pst.close();
	 			
	 		 	Button close = new Button("Close");
		 		close.setOnAction(e -> window2.close());
		 		
		 		Label success = new Label("You have successfully updated the " + field3.getText() + " wedding. "
		 				+ "Please close this window and press Display All button to view your changes. ");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	 		 			
	 			} catch (Exception e1) {
	 				Stage window2Bad = new Stage();
	 		 		
	 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 				window2Bad.setTitle("Updating a Wedding");
	 				window2Bad.setMinWidth(800);
	 				
	 				Button close = new Button("Close");
			 		close.setOnAction(e -> window2Bad.close());
	 				
	 				Label fail = new Label("There was a problem updating the wedding. Please make sure you are adding valid inputs and try again.");
	 				
	 				VBox layout = new VBox();
			 		layout.getChildren().addAll(fail, close);
			 		layout.setAlignment(Pos.CENTER);
			 		
			 		Scene scene = new Scene(layout);
			 		window2Bad.setScene(scene);
			 		window2Bad.showAndWait();
			 		
	 				e1.printStackTrace();
	 			}
	    	
	  	
	    });
	    Button exitB1 = new Button("Exit");
	    exitB1.setFont(myFont);
	    exitB1.setPrefWidth(100);
	    exitB1.setOnAction(e -> ExitB());
	    
	    // guest tab/tab 2 buttons and actions
	    Button deleteB2 = new Button("Delete");
	    deleteB2.setFont(myFont);
	    deleteB2.setPrefWidth(100);
	    deleteB2.setOnAction(e -> {
	     	Stage window2 = new Stage();
	    
	    	window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Deleting a Wedding Guest");
	 		window2.setMinWidth(800);
	    	
	    	try {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	    		String deleteGuestSQL = "DELETE FROM LsGuest WHERE GName =?";
	    		pst = con.prepareStatement(deleteGuestSQL);
	    		pst.setString(1, field7.getText());
	    		pst.executeUpdate();
	    		
	    		pst.close();
	    		
	    		Button close = new Button("Close");
		 		close.setOnAction(action2 -> window2.close());
		 		
		 		Label success = new Label("You have successfully deleted " + field7.getText() + " from the guest list." 
		 				+ "Please close this window and press Display All button to view the updated guest list.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	    		
	    	} catch (Exception e1) {
 				Stage window2Bad = new Stage();
 		 		
 				window2Bad.initModality(Modality.APPLICATION_MODAL);
 				window2Bad.setTitle("Deleting a Wedding Guest");
 				window2Bad.setMinWidth(800);
 				
 				Button close = new Button("Close");
		 		close.setOnAction(action -> window2Bad.close());
 				
 				Label fail = new Label("There was a problem deleting " + field7.getText() + " from the guest list. Please try again.");
 				
 				VBox layout = new VBox();
		 		layout.getChildren().addAll(fail, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2Bad.setScene(scene);
		 		window2Bad.showAndWait();
		 		
 				e1.printStackTrace();
 			}
	    });
	    Button addB2 = new Button("Add");
	    addB2.setFont(myFont);
	    addB2.setPrefWidth(100);
	    addB2.setOnAction(action2 -> {
	    	
	      	Stage window3 = new Stage();
	 		
	 		window3.initModality(Modality.APPLICATION_MODAL);
	 		window3.setTitle("Adding a New Wedding Guest");
	 		window3.setMinWidth(800);
	    	
	    	String insertGuestSQL = "INSERT INTO LsGuest (WeddingID, GuestID, GName, GEmail, GPhone, GAddress, GCity, GState, GZip, DietaryRestrict, RSVP, TableNumber )"
	    			+ "VALUES ('" + field5.getText() +"', '" + field6.getText() +"', '" + field7.getText() +"', '" + field8.getText() +"'"
	    					+ ", '" + field9.getText() +"', '" + field10.getText() +"', '" + field11.getText() +"', '" + field12.getText() +"'"
	    					+ ", '" + field13.getText() +"', '" + field14.getText() +"', '" + field15.getText() +"', '" + field16.getText() +"')";
	 		
	 	
	    	try { 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	 			Statement statement=con.createStatement();
	 			 					
	 			rs=statement.executeQuery(insertGuestSQL);
	 			
	 			Button close = new Button("Close");
		 		close.setOnAction(e -> window3.close());
		 		
		 		Label success = new Label("You have successfully added a new wedding guest. "
		 				+ "Please close this window and press Display All button to view your newly added guest.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window3.setScene(scene);
		 		window3.showAndWait();
	 		 			
	 			} catch (Exception e1) {
	 				Stage window2Bad = new Stage();
	 		 		
	 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 				window2Bad.setTitle("Adding a New Wedding Guest");
	 				window2Bad.setMinWidth(800);
	 				
	 				Button close = new Button("Close");
			 		close.setOnAction(e -> window2Bad.close());
	 				
	 				Label fail = new Label("There was a problem adding the new guest. Please make sure you are adding valid inputs and try again.");
	 				
	 				VBox layout = new VBox();
			 		layout.getChildren().addAll(fail, close);
			 		layout.setAlignment(Pos.CENTER);
			 		
			 		Scene scene = new Scene(layout);
			 		window2Bad.setScene(scene);
			 		window2Bad.showAndWait();
	 			
	 			e1.printStackTrace();
	 			}
			});
	    
	    
	    Button displayAllB2 = new Button("Display All");
	    displayAllB2.setOnAction(e -> viewGuests("View All Guests", "Here are all the guests for all the weddings."));
	    displayAllB2.setFont(myFont);
	    displayAllB2.setPrefWidth(100);
	    Button updateB2 = new Button("Update");
	    updateB2.setFont(myFont);
	    updateB2.setPrefWidth(100);
	    updateB2.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	    	
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Updating a Wedding Guest");
	 		window2.setMinWidth(800);
	    	
	    	String updateGSQL = "UPDATE LsGuest SET WeddingID=?, GuestID=?, GName=?, GEmail=?, GPhone=?, GAddress=?, GCity=?, GState=?, GZip=?, DietaryRestrict=?, RSVP=?, TableNumber=? "
	    			+ "WHERE GName = '"+field7.getText() +"'";	    	
		 		
	 		    	try { 
	 		 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 		 			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
 				
	 		 		 	pst = con.prepareStatement(updateGSQL);
	 		 		 	
	 		 		 	pst.setString(1, field5.getText());
	 		 		 	pst.setString(2, field6.getText());
	 		 		 	pst.setString(3, field7.getText());
	 		 		 	pst.setString(4, field8.getText());
	 		 		 	pst.setString(5, field9.getText());
	 		 		 	pst.setString(6, field10.getText());
	 		 		 	pst.setString(7, field11.getText());
	 		 		 	pst.setString(8, field12.getText());
	 		 		 	pst.setString(9, field13.getText());
	 		 		 	pst.setString(10, field14.getText());
	 		 		 	pst.setString(11, field15.getText());
	 		 		 	pst.setString(12, field16.getText());
	 		 		 		 	 		 		 	
	 		 		 	
	 		 		 	pst.execute();
	 		 		 	
	 		 		 	pst.close();
	 		 			
	 		 		 	Button close = new Button("Close");
	 			 		close.setOnAction(e -> window2.close());
	 			 		
	 			 		Label success = new Label("You have successfully updated " + field7.getText() + "."
	 			 				+ "Please close this window and press Display All button to view your changes.");
	 			 	
	 			 		VBox layout = new VBox();
	 			 		layout.getChildren().addAll(success, close);
	 			 		layout.setAlignment(Pos.CENTER);
	 			 		
	 			 		Scene scene = new Scene(layout);
	 			 		window2.setScene(scene);
	 			 		window2.showAndWait();
	 		 		 			
	 		 			} catch (Exception e1) {
	 		 				Stage window2Bad = new Stage();
	 		 		 		
	 		 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 		 				window2Bad.setTitle("Updating a Wedding Guest");
	 		 				window2Bad.setMinWidth(800);
	 		 				
	 		 				Button close = new Button("Close");
	 				 		close.setOnAction(e -> window2Bad.close());
	 		 				
	 		 				Label fail = new Label("There was a problem updating the wedding guest. Please make sure you are adding valid inputs and try again.");
	 		 				
	 		 				VBox layout = new VBox();
	 				 		layout.getChildren().addAll(fail, close);
	 				 		layout.setAlignment(Pos.CENTER);
	 				 		
	 				 		Scene scene = new Scene(layout);
	 				 		window2Bad.setScene(scene);
	 				 		window2Bad.showAndWait();
	 				 		
	 		 				e1.printStackTrace();
	 		 			}
	 		    	
	 		  	
	 		    });
	 		 	
	 		 	
	    Button exitB2 = new Button("Exit");
	    exitB2.setFont(myFont);
	    exitB2.setPrefWidth(100);
	    exitB2.setOnAction(e -> ExitB()); 
	  	    
	    // vendor tab/tab 3 buttons and actions
	    Button deleteB3 = new Button("Delete");
	    deleteB3.setFont(myFont);
	    deleteB3.setPrefWidth(100);
	    deleteB3.setOnAction(e -> {
	     	Stage window2 = new Stage();
	    	
	    	window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Deleting a Wedding Vendor");
	 		window2.setMinWidth(800);
	    	
	    	try {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	    		String deleteVendorSQL = "DELETE FROM LsVendor WHERE VName =?";
	    		pst = con.prepareStatement(deleteVendorSQL);
	    		pst.setString(1, field19.getText());
	    		pst.executeUpdate();
	    		
	    		pst.close();
	    		
	    		Button close = new Button("Close");
		 		close.setOnAction(action2 -> window2.close());
		 		
		 		Label success = new Label("You have successfully deleted the " + field19.getText() + " wedding vendor." 
		 				+ "Please close this window and press Display All button to view the updated wedding vendor list.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	    		
	    	} catch (Exception e1) {
 				Stage window2Bad = new Stage();
 		 		
 				window2Bad.initModality(Modality.APPLICATION_MODAL);
 				window2Bad.setTitle("Deleting a Wedding Vendor");
 				window2Bad.setMinWidth(800);
 				
 				Button close = new Button("Close");
		 		close.setOnAction(action -> window2Bad.close());
 				
 				Label fail = new Label("There was a problem deleting the " + field19.getText() + " wedding vendor. "
 						+ "Please try again.");
 				
 				VBox layout = new VBox();
		 		layout.getChildren().addAll(fail, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2Bad.setScene(scene);
		 		window2Bad.showAndWait();
		 		
 				e1.printStackTrace();
 			}
	    });
	    Button addB3 = new Button("Add");
	    addB3.setFont(myFont);
	    addB3.setPrefWidth(100);
	    addB3.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	 		
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Adding a New Wedding Vendor");
	 		window2.setMinWidth(800);
	    	
	    	String insertVendorSQL = "INSERT INTO LsVendor (WeddingID, VendorID, VName, VEmail, VPhone, EventID, VCost) "
	    			+ "VALUES ('" + field17.getText() +"', '" + field18.getText() +"', '" + field19.getText() +"', '" + field20.getText() +"'"
	    					+ ", '" + field21.getText() +"', '" + field22.getText() +"', '" + field23.getText() +"')";
	 		
	 	
	    	try { 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	 			Statement statement=con.createStatement();
	 			
	 			System.out.println(insertVendorSQL);
	 							
	 			rs=statement.executeQuery(insertVendorSQL);
	 			
	 			Button close = new Button("Close");
		 		close.setOnAction(e -> window2.close());
		 		
		 		Label success = new Label("You have successfully added a new vendor. "
		 				+ "Please close this window and press Display All button to view your newly added vendor.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	 		 			
	 			} catch (Exception e1) {
	 				Stage window2Bad = new Stage();
	 		 		
	 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 				window2Bad.setTitle("Adding a New Wedding Vendor");
	 				window2Bad.setMinWidth(800);
	 				
	 				Button close = new Button("Close");
			 		close.setOnAction(e -> window2Bad.close());
	 				
	 				Label fail = new Label("There was a problem adding the new vendor. Please make sure you are adding valid inputs and try again.");
	 				
	 				VBox layout = new VBox();
			 		layout.getChildren().addAll(fail, close);
			 		layout.setAlignment(Pos.CENTER);
			 		
			 		Scene scene = new Scene(layout);
			 		window2Bad.setScene(scene);
			 		window2Bad.showAndWait();
			 		
	 				e1.printStackTrace();
	 			}
	    	
	    });
	    Button displayAllB3 = new Button("Display All");
	    displayAllB3.setOnAction(e -> allVendors("View All Vendors", "Here are all the vendors for all the wedding events."));
	    displayAllB3.setFont(myFont);
	    displayAllB3.setPrefWidth(100);
	    Button updateB3 = new Button("Update");
	    updateB3.setFont(myFont);
	    updateB3.setPrefWidth(100);
	    updateB3.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	    	
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Updating a Wedding Vendor");
	 		window2.setMinWidth(800);
	    	
	    	String updateVSQL = "UPDATE LsVendor SET WeddingID=?, VendorID=?, VName=?, VEmail=?, VPhone=?, EventID=?, VCost=?"
	    			+ " WHERE VName = '"+field19.getText() +"'";	    	
		 		
	 		    	try { 
	 		 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 		 			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
 				
	 		 		 	pst = con.prepareStatement(updateVSQL);
	 		 		 	
	 		 		 	pst.setString(1, field17.getText());
	 		 		 	pst.setString(2, field18.getText());
	 		 		 	pst.setString(3, field19.getText());
	 		 		 	pst.setString(4, field20.getText());
	 		 		 	pst.setString(5, field21.getText());
	 		 		 	pst.setString(6, field22.getText());
	 		 		 	pst.setString(7, field23.getText());
	 	
	 		 		 	pst.execute();
	 		 		 	
	 		 		 	pst.close();
	 		 			
	 		 		 	Button close = new Button("Close");
	 			 		close.setOnAction(e -> window2.close());
	 			 		
	 			 		Label success = new Label("You have successfully updated the vendor " + field19.getText() + "."
	 			 				+ "Please close this window and press Display All button to view your changes.");
	 			 	
	 			 		VBox layout = new VBox();
	 			 		layout.getChildren().addAll(success, close);
	 			 		layout.setAlignment(Pos.CENTER);
	 			 		
	 			 		Scene scene = new Scene(layout);
	 			 		window2.setScene(scene);
	 			 		window2.showAndWait();
	 		 		 			
	 		 			} catch (Exception e1) {
	 		 				Stage window2Bad = new Stage();
	 		 		 		
	 		 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 		 				window2Bad.setTitle("Updating a Wedding Vendor");
	 		 				window2Bad.setMinWidth(800);
	 		 				
	 		 				Button close = new Button("Close");
	 				 		close.setOnAction(e -> window2Bad.close());
	 		 				
	 		 				Label fail = new Label("There was a problem updating the wedding vendor. Please make sure you are adding valid inputs and try again.");
	 		 				
	 		 				VBox layout = new VBox();
	 				 		layout.getChildren().addAll(fail, close);
	 				 		layout.setAlignment(Pos.CENTER);
	 				 		
	 				 		Scene scene = new Scene(layout);
	 				 		window2Bad.setScene(scene);
	 				 		window2Bad.showAndWait();
	 				 		
	 		 				e1.printStackTrace();
	 		 			}
	 		    	
	 		  	
	 		    });
	    Button exitB3 = new Button("Exit");
	    exitB3.setFont(myFont);
	    exitB3.setPrefWidth(100);
	    exitB3.setOnAction(e -> ExitB()); 
	 	    
	    // events tab/tab 4 buttons and actions
	    Button deleteB4 = new Button("Delete");
	    deleteB4.setFont(myFont);
	    deleteB4.setPrefWidth(100);
	    deleteB4.setOnAction(e -> {
	     	Stage window2 = new Stage();
	    
	    	window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Deleting a Wedding Event");
	 		window2.setMinWidth(800);
	    	
	    	try {
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	    		String deleteEventSQL = "DELETE FROM LsEvents WHERE EName =?";
	    		pst = con.prepareStatement(deleteEventSQL);
	    		pst.setString(1, field31.getText());
	    		pst.executeUpdate();
	    		
	    		pst.close();
	    		
	    		Button close = new Button("Close");
		 		close.setOnAction(action2 -> window2.close());
		 		
		 		Label success = new Label("You have successfully deleted the " + field31.getText() + " wedding event."
		 				+ "Please close this window and press Display All button to view the updated wedding events list.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	    		
	    	} catch (Exception e1) {
 				Stage window2Bad = new Stage();
 		 		
 				window2Bad.initModality(Modality.APPLICATION_MODAL);
 				window2Bad.setTitle("Deleting a Wedding Event");
 				window2Bad.setMinWidth(800);
 				
 				Button close = new Button("Close");
		 		close.setOnAction(action -> window2Bad.close());
 				
 				Label fail = new Label("There was a problem deleting the " + field31.getText() + " wedding event from the. " + field3.getText() +
 						" wedding. Please try again.");
 				
 				VBox layout = new VBox();
		 		layout.getChildren().addAll(fail, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2Bad.setScene(scene);
		 		window2Bad.showAndWait();
		 		
 				e1.printStackTrace();
 			}
	    });
	    Button addB4 = new Button("Add");
	    addB4.setFont(myFont);
	    addB4.setPrefWidth(100);
	    addB4.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	 		
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Adding a New Wedding Event");
	 		window2.setMinWidth(800);
	    	
	    	String insertEventsSQL = "INSERT INTO LsEvents (EventID, WeddingID, EDate, EAddress, ECity, EState, EZip, EName) "
	    			+ "VALUES ('" + field24.getText() +"', '" + field25.getText() +"', '" + field26.getText() +"', '" + field27.getText() +"'"
	    					+ ", '" + field28.getText() +"', '" + field29.getText() +"', '" + field30 .getText() +"', '" + field31.getText() +"')";
	 		
	 		  	try { 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
	 				 			
	 			Statement statement=con.createStatement();
	 							
	 			rs=statement.executeQuery(insertEventsSQL);
	 			
	 			Button close = new Button("Close");
		 		close.setOnAction(e -> window2.close());
		 		
		 		Label success = new Label("You have successfully added a new wedding event. "
		 				+ "Please close this window and press Display All button to view your newly added wedding event.");
		 	
		 		VBox layout = new VBox();
		 		layout.getChildren().addAll(success, close);
		 		layout.setAlignment(Pos.CENTER);
		 		
		 		Scene scene = new Scene(layout);
		 		window2.setScene(scene);
		 		window2.showAndWait();
	 		 			
	 			} catch (Exception e1) {
	 				Stage window2Bad = new Stage();
	 		 		
	 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 				window2Bad.setTitle("Adding a New Wedding Event");
	 				window2Bad.setMinWidth(800);
	 				
	 				Button close = new Button("Close");
			 		close.setOnAction(e -> window2Bad.close());
	 				
	 				Label fail = new Label("There was a problem adding the new wedding event. Please make sure you are adding valid inputs and try again.");
	 				
	 				VBox layout = new VBox();
			 		layout.getChildren().addAll(fail, close);
			 		layout.setAlignment(Pos.CENTER);
			 		
			 		Scene scene = new Scene(layout);
			 		window2Bad.setScene(scene);
			 		window2Bad.showAndWait();
			 		
	 				e1.printStackTrace();
	 			}
	    	
	    });
	    Button displayAllB4 = new Button("Display All");
	    displayAllB4.setOnAction(e -> allEvents("View All Events", "Here are all the events for all the weddings."));
	    displayAllB4.setFont(myFont);
	    displayAllB4.setPrefWidth(100);
	    Button updateB4 = new Button("Update");
	    updateB4.setFont(myFont);
	    updateB4.setPrefWidth(100);
	    updateB4.setOnAction(action -> {
	    	
	    	Stage window2 = new Stage();
	    	
	 		window2.initModality(Modality.APPLICATION_MODAL);
	 		window2.setTitle("Updating a Wedding Event");
	 		window2.setMinWidth(800);
	    	
	    	String updateESQL = "UPDATE LsEvents SET WeddingID=?, EventID=?, EDate=?,  EAddress=?, ECity=?, EState=?, EZip=?, EName=?"
	    			+ " WHERE EName = '"+field31.getText() +"'";	    	
		 		
	 		    	try { 
	 		 			Class.forName("oracle.jdbc.driver.OracleDriver");
	 		 			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
 				
	 		 		 	pst = con.prepareStatement(updateESQL);
	 		 		 	
	 		 		 	pst.setString(1, field24.getText());
	 		 		 	pst.setString(2, field25.getText());
	 		 		 	pst.setString(3, field26.getText());
	 		 		 	pst.setString(4, field27.getText());
	 		 		 	pst.setString(5, field28.getText());
	 		 		 	pst.setString(6, field29.getText());
	 		 		 	pst.setString(7, field30.getText());
	 		 		 	pst.setString(8, field31.getText());
	 	
	 		 		 	pst.execute();
	 		 		 	
	 		 		 	pst.close();
	 		 			
	 		 		 	Button close = new Button("Close");
	 			 		close.setOnAction(e -> window2.close());
	 			 		
	 			 		Label success = new Label("You have successfully updated the " + field31.getText() + " wedding event."
	 			 				+ "Please close this window and press Display All button to view your changes.");
	 			 	
	 			 		VBox layout = new VBox();
	 			 		layout.getChildren().addAll(success, close);
	 			 		layout.setAlignment(Pos.CENTER);
	 			 		
	 			 		Scene scene = new Scene(layout);
	 			 		window2.setScene(scene);
	 			 		window2.showAndWait();
	 		 		 			
	 		 			} catch (Exception e1) {
	 		 				Stage window2Bad = new Stage();
	 		 		 		
	 		 				window2Bad.initModality(Modality.APPLICATION_MODAL);
	 		 				window2Bad.setTitle("Updating a Wedding Event");
	 		 				window2Bad.setMinWidth(800);
	 		 				
	 		 				Button close = new Button("Close");
	 				 		close.setOnAction(e -> window2Bad.close());
	 		 				
	 		 				Label fail = new Label("There was a problem updating the wedding event. Please make sure you are adding valid inputs and try again.");
	 		 				
	 		 				VBox layout = new VBox();
	 				 		layout.getChildren().addAll(fail, close);
	 				 		layout.setAlignment(Pos.CENTER);
	 				 		
	 				 		Scene scene = new Scene(layout);
	 				 		window2Bad.setScene(scene);
	 				 		window2Bad.showAndWait();
	 				 		
	 		 				e1.printStackTrace();
	 		 			}
	 		    	
	 		  	
	 		    });
	    Button exitB4 = new Button("Exit");
	    exitB4.setFont(myFont);
	    exitB4.setPrefWidth(100);
	    exitB4.setOnAction(e -> ExitB()); 
	    
	    // buttons for reports tab
	    Button report1B = new Button("View All Guests & RSVP Status for Smith-Jones Wedding");
	    report1B.setFont(myFont);
	    report1B.setPrefWidth(500);
	    report1B.setOnAction(e -> viewSmithJonesWedding("View the Smith-Jones Wedding Guests", "Here are all the guests linked to the Smith-Jones Wedding"));
	    Button report2B = new Button("View All Vendors & Events for Smith-Jones Wedding");
	    report2B.setFont(myFont);
	    report2B.setPrefWidth(500);
	    report2B.setOnAction(e -> viewSmithJonesWeddingMore("View the Smith-Jones Wedding Vendors and Events", "Here are all the vendors and events linekd to the Smith-Jones Wedding"));
	            
        // create a tabpane 
        TabPane tabpane = new TabPane(); 
          
        // create Tab 1
        Tab tab1 = new Tab("All Weddings"); 
        
                     
        // gridpane for wedding tab details
        GridPane tab1Pane = new GridPane();
        tab1Pane.setAlignment(Pos.TOP_CENTER);
        tab1Pane.setHgap(5);;
        tab1Pane.setVgap(5);;
        tab1Pane.setPadding(new Insets(25, 25, 25, 25));
        tab1Pane.add(labelF1, 0, 1);
        tab1Pane.add(field1, 1, 1);
        tab1Pane.add(labelF2, 0, 2);
        tab1Pane.add(field2, 1, 2);
        tab1Pane.add(labelF3, 0, 3);
        tab1Pane.add(field3, 1, 3);
        tab1Pane.add(labelF4, 0, 4);
        tab1Pane.add(field4, 1, 4);
        tab1Pane.add(labelC32, 0, 5);
        tab1Pane.add(comboBoxT1, 1, 5);
        tab1Pane.add(displayAllB1, 0, 6);
        tab1Pane.add(addB1, 1, 6);
        tab1Pane.add(updateB1, 0, 7);
        tab1Pane.add(deleteB1, 1, 7);
        tab1Pane.add(exitB1, 0, 8);
       
            
        // gridpane for guests tab details
        GridPane tab2Pane = new GridPane();
        tab2Pane.setAlignment(Pos.TOP_CENTER);
        tab2Pane.setHgap(5);;
        tab2Pane.setVgap(5);;
        tab2Pane.setPadding(new Insets(25, 25, 25, 25));
        tab2Pane.add(labelF5, 0, 1);
        tab2Pane.add(field5, 1, 1);
        tab2Pane.add(labelF6, 0, 2);
        tab2Pane.add(field6, 1, 2);
        tab2Pane.add(labelF7, 0, 3);
        tab2Pane.add(field7, 1, 3);
        tab2Pane.add(labelF8, 0, 4);
        tab2Pane.add(field8, 1, 4);
        tab2Pane.add(labelF9, 0, 5);
        tab2Pane.add(field9, 1, 5);
        tab2Pane.add(labelF10, 0, 6);
        tab2Pane.add(field10, 1, 6);
        tab2Pane.add(labelF11, 0, 7);
        tab2Pane.add(field11, 1, 7);
        tab2Pane.add(labelF12, 0, 8);
        tab2Pane.add(field12, 1, 8);
        tab2Pane.add(labelF13, 0, 9);
        tab2Pane.add(field13, 1, 9);
        tab2Pane.add(labelF14, 0, 10);
        tab2Pane.add(field14, 1, 10);
        tab2Pane.add(labelF15, 0, 11);
        tab2Pane.add(field15, 1, 11);
        tab2Pane.add(labelF16, 0, 12);
        tab2Pane.add(field16, 1, 12);
        tab2Pane.add(labelC33, 0, 13);
        tab2Pane.add(comboBoxT2, 1, 13);
        tab2Pane.add(displayAllB2, 0, 14);
        tab2Pane.add(addB2, 1, 14);
        tab2Pane.add(updateB2, 0, 15);
        tab2Pane.add(deleteB2, 1, 15);
        tab2Pane.add(exitB2, 0, 16);
        
        // gridpane for vendor tab details
        GridPane tab3Pane = new GridPane();
        tab3Pane.setAlignment(Pos.TOP_CENTER);
        tab3Pane.setHgap(5);;
        tab3Pane.setVgap(5);;
        tab3Pane.setPadding(new Insets(25, 25, 25, 25));
        tab3Pane.add(labelF17, 0, 1);
        tab3Pane.add(field17, 1, 1);
        tab3Pane.add(labelF18, 0, 2);
        tab3Pane.add(field18, 1, 2);
        tab3Pane.add(labelF19, 0, 3);
        tab3Pane.add(field19, 1, 3);
        tab3Pane.add(labelF20, 0, 4);
        tab3Pane.add(field20, 1, 4);
        tab3Pane.add(labelF21, 0, 5);
        tab3Pane.add(field21, 1, 5);
        tab3Pane.add(labelF22, 0, 6);
        tab3Pane.add(field22, 1, 6);
        tab3Pane.add(labelF23, 0, 7);
        tab3Pane.add(field23, 1, 7);
        tab3Pane.add(labelC34, 0, 8);
        tab3Pane.add(comboBoxT3, 1, 8);
        tab3Pane.add(displayAllB3, 0, 9);
        tab3Pane.add(addB3, 1, 9);
        tab3Pane.add(updateB3, 0, 10);
        tab3Pane.add(deleteB3, 1, 10);
        tab3Pane.add(exitB3, 0, 11);
        
        // gridpane for events tab details
        GridPane tab4Pane = new GridPane();
        tab4Pane.setAlignment(Pos.TOP_CENTER);
        tab4Pane.setHgap(5);;
        tab4Pane.setVgap(5);;
        tab4Pane.setPadding(new Insets(25, 25, 25, 25));
        tab4Pane.add(labelF25, 0, 1);
        tab4Pane.add(field25, 1, 1);
        tab4Pane.add(labelF24, 0, 2);
        tab4Pane.add(field24, 1, 2);
        tab4Pane.add(labelF26, 0, 3);
        tab4Pane.add(field26, 1, 3);
        tab4Pane.add(labelF27, 0, 4);
        tab4Pane.add(field27, 1, 4);
        tab4Pane.add(labelF28, 0, 5);
        tab4Pane.add(field28, 1, 5);
        tab4Pane.add(labelF29, 0, 6);
        tab4Pane.add(field29, 1, 6);
        tab4Pane.add(labelF30, 0, 7);
        tab4Pane.add(field30, 1, 7);
        tab4Pane.add(labelF31, 0, 8);
        tab4Pane.add(field31, 1, 8);
        tab4Pane.add(labelC35, 0, 9);
        tab4Pane.add(comboBoxT4, 1, 9);
        tab4Pane.add(displayAllB4, 0, 10);
        tab4Pane.add(addB4, 1, 10);
        tab4Pane.add(updateB4, 0, 11);
        tab4Pane.add(deleteB4, 1, 11);
        tab4Pane.add(exitB4, 0, 12);
        
        // gridpane for reports tab details
        GridPane tab5Pane = new GridPane();
        tab5Pane.setAlignment(Pos.TOP_CENTER);
        tab5Pane.setHgap(5);;
        tab5Pane.setVgap(5);;
        tab5Pane.setPadding(new Insets(25, 25, 25, 25));
        tab5Pane.add(report1B, 0, 1);
        tab5Pane.add(report2B, 0, 2);
        
        // add content to tab 1
        tab1.setContent(tab1Pane);   
  
        // create tabs 2-5 and add content
        Tab tab2 = new Tab("Wedding Guests"); 
        tab2.setContent(tab2Pane);  
        Tab tab3 = new Tab("Wedding Vendors");
        tab3.setContent(tab3Pane); 
        Tab tab4 = new Tab("Wedding Events");
        tab4.setContent(tab4Pane); 
        Tab tab5 = new Tab("Reports");
        tab5.setContent(tab5Pane);
  
        // add tabs to the tabpane
        tabpane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5); 
        
        // create the main scene with buttons
        scene1 = new Scene(tabpane, 700, 700);
        window1.setTitle("Be Our Guest: Wedding Manager Application");
        window1.setScene(scene1);
        window1.show();
    }
    
    // wedding table add to comboBoxT1 method
    public void fillComboBoxT1() {
    	
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String sql="SELECT WeddingName FROM LsWedding";
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				weddingData.add(rs.getString("WeddingName"));
					
			}
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
    
    // guest table add to comboBoxT2 method
    public void fillComboBoxT2() {
     	
  		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String sql="SELECT GName FROM LsGuest";
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				guestData.add(rs.getString("GName"));
					
			}
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
    
    // vendor table add to comboBoxT3 method
    public void fillComboBoxT3() {
    
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String sql="SELECT VName FROM LsVendor";
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				vendorData.add(rs.getString("VName"));
					
			}
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
    
    // events table add to comboBoxT4 method
    public void fillComboBoxT4() {
    	
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String sql="SELECT EName FROM LsEvents";
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				eventsData.add(rs.getString("EName"));
					
			}
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
    
    // method to exit the program
    public static void ExitB() {
    				
    	System.exit(0);
    	
    }
    
    // method for display all button on wedding tab    
    public void viewWeddings(String title, String alert) {

		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(900);
		
	
		wedTable = new TableView<>();
		final ObservableList <Weddings> weddingData = FXCollections.observableArrayList();
		
		TableColumn col1 = new TableColumn("Wedding ID");
		col1.setMinWidth(120);
		col1.setCellValueFactory(new PropertyValueFactory<>("WedID"));
		
		TableColumn col2 = new TableColumn("Wedding Date");
		col2.setMinWidth(150);
		col2.setCellValueFactory(new PropertyValueFactory<>("WedD"));
		
		TableColumn col3 = new TableColumn("Wedding Name");
		col3.setMinWidth(150);
		col3.setCellValueFactory(new PropertyValueFactory<>("WedN"));
		
		TableColumn col4 = new TableColumn("Wedding State");
		col4.setMinWidth(120);
		col4.setCellValueFactory(new PropertyValueFactory<>("WedS"));
		
		wedTable.getColumns().addAll(col1, col2, col3, col4);
		
			
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String sql= "SELECT* FROM LsWedding";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				weddingData.add(new Weddings (
						rs.getString("WeddingID"),
						rs.getString("WeddingDate"),
						rs.getString("WeddingName"),
						rs.getString("WeddingState")

						));
				wedTable.setItems(weddingData);
			}
			pst.close();
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		Label label = new Label();
		label.setText(alert);
		Button close = new Button("Close");
		close.setOnAction(e -> window.close());
		
		VBox layout = new VBox(wedTable);
		layout.getChildren().addAll(label, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
	}
	
	// method to display the first report on the reports tab that includes an Inner Join to join all guests tied to the Smith-Jones Wedding
	public void viewSmithJonesWedding(String title, String alert) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(900);
		
			
		wedReport1Table = new TableView<>();
		final ObservableList <WeddingSmithJones> weddingReport1Data = FXCollections.observableArrayList();
		
		TableColumn col1 = new TableColumn("Wedding ID");
		col1.setMinWidth(120);
		col1.setCellValueFactory(new PropertyValueFactory<>("wedID"));
		
		TableColumn col2 = new TableColumn("Wedding Name");
		col2.setMinWidth(150);
		col2.setCellValueFactory(new PropertyValueFactory<>("wedN"));
		
		TableColumn col3 = new TableColumn("Guest Name");
		col3.setMinWidth(150);
		col3.setCellValueFactory(new PropertyValueFactory<>("gName"));
		
		TableColumn col4 = new TableColumn("RSVP Status");
		col4.setMinWidth(120);
		col4.setCellValueFactory(new PropertyValueFactory<>("rsvp"));
		
		wedReport1Table.getColumns().addAll(col1, col2, col3, col4);
		
				
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			Statement statement=con.createStatement();
			String smithJonesGuestsSQL = "SELECT LsWedding.WeddingID, LsWedding.WeddingName, LsGuest.GName, LsGuest.RSVP FROM LsWedding "
    				+ "INNER JOIN LsGuest ON LsWedding.WeddingID = LsGuest.WeddingID WHERE LsWedding.WeddingName='Smith-Jones'";
			pst = con.prepareStatement(smithJonesGuestsSQL);
			rs = pst.executeQuery();
			while(rs.next()) {
				weddingReport1Data.add(new WeddingSmithJones (
						rs.getString("WeddingID"),
						rs.getString("WeddingName"),
						rs.getString("GName"),
						rs.getString("RSVP")

						));
				wedReport1Table.setItems(weddingReport1Data);
			}
			pst.close();
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		Label label = new Label();
		label.setText(alert);
		Button close = new Button("Close");
		close.setOnAction(e -> window.close());
		
		VBox layout = new VBox(wedReport1Table);
		layout.getChildren().addAll(label, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
	}
		// method to display the second report on the reports tab that includes an Inner Join to show all vendors for all events tied to the Smith-Jones wedding
		public void viewSmithJonesWeddingMore(String title, String alert) {
			
			
			Stage window = new Stage();
			
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(900);
			
				
			wedReport2Table = new TableView<>();
			final ObservableList <WeddingSmithJonesMore> weddingReport2Data = FXCollections.observableArrayList();
			
			TableColumn col1 = new TableColumn("Wedding ID");
			col1.setMinWidth(100);
			col1.setCellValueFactory(new PropertyValueFactory<>("wedID"));
			
			TableColumn col2 = new TableColumn("Wedding Name");
			col2.setMinWidth(150);
			col2.setCellValueFactory(new PropertyValueFactory<>("wedN"));
			
			TableColumn col3 = new TableColumn("Event ID");
			col3.setMinWidth(100);
			col3.setCellValueFactory(new PropertyValueFactory<>("eID"));
			
			TableColumn col4 = new TableColumn("Event Name");
			col4.setMinWidth(150);
			col4.setCellValueFactory(new PropertyValueFactory<>("eName"));
			
			TableColumn col5 = new TableColumn("Vendor ID");
			col5.setMinWidth(100);
			col5.setCellValueFactory(new PropertyValueFactory<>("vID"));
			
			TableColumn col6 = new TableColumn("Vendor Name");
			col6.setMinWidth(120);
			col6.setCellValueFactory(new PropertyValueFactory<>("vName"));
			
			TableColumn col7 = new TableColumn("Vendor Cost");
			col7.setMinWidth(120);
			col7.setCellValueFactory(new PropertyValueFactory<>("vCost"));
			
			wedReport2Table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
			
						
			try { 
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
				Statement statement=con.createStatement();
				String smithJonesGuestsSQL2 = "SELECT LsWedding.WeddingID, LsWedding.WeddingName, LsEvents.EventID, LsEvents.EName, LsVendor.VendorID, LsVendor.VName, LsVendor.VCost FROM LsVendor \r\n" + 
						"INNER JOIN LsEvents ON LsVendor.EventID = LsEvents.EventID INNER JOIN LsWedding ON LsEvents.WeddingID = LsWedding.WeddingID WHERE LsWedding.WeddingName='Smith-Jones'";
				pst = con.prepareStatement(smithJonesGuestsSQL2);
				rs = pst.executeQuery();
				while(rs.next()) {
					weddingReport2Data.add(new WeddingSmithJonesMore (
							rs.getString("WeddingID"),
							rs.getString("WeddingName"),
							rs.getString("EventID"),
							rs.getString("EName"),
							rs.getString("VendorID"),
							rs.getString("VName"),
							rs.getString("VCost")

							));
					wedReport2Table.setItems(weddingReport2Data);
				}
				pst.close();
				rs.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			Label label = new Label();
			label.setText(alert);
			Button close = new Button("Close");
			close.setOnAction(e -> window.close());
			
			VBox layout = new VBox(wedReport2Table);
			layout.getChildren().addAll(label, close);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			
		}
		
		// view all guests method
		public void viewGuests(String title, String alert) {
			
			Stage window = new Stage();
			
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(1500);
			
						
			guestTable = new TableView<>();
			final ObservableList <GuestObject> guestData = FXCollections.observableArrayList();
			
			TableColumn col1 = new TableColumn("Wedding ID");
			col1.setMinWidth(120);
			col1.setCellValueFactory(new PropertyValueFactory<>("weddingID"));
			
			TableColumn col2 = new TableColumn("Guest ID");
			col2.setMinWidth(120);
			col2.setCellValueFactory(new PropertyValueFactory<>("guestID"));
			
			TableColumn col3 = new TableColumn("Guest Name");
			col3.setMinWidth(150);
			col3.setCellValueFactory(new PropertyValueFactory<>("guestN"));
			
			TableColumn col4 = new TableColumn("Guest Email");
			col4.setMinWidth(150);
			col4.setCellValueFactory(new PropertyValueFactory<>("guestE"));
			
			TableColumn col5 = new TableColumn("Guest Phone");
			col5.setMinWidth(120);
			col5.setCellValueFactory(new PropertyValueFactory<>("guestP"));
			
			TableColumn col6 = new TableColumn("Guest Address");
			col6.setMinWidth(120);
			col6.setCellValueFactory(new PropertyValueFactory<>("guestA"));
			
			TableColumn col7 = new TableColumn("Guest City");
			col7.setMinWidth(120);
			col7.setCellValueFactory(new PropertyValueFactory<>("guestCity"));
			
			TableColumn col8 = new TableColumn("Guest State");
			col8.setMinWidth(100);
			col8.setCellValueFactory(new PropertyValueFactory<>("guestState"));
			
			TableColumn col9 = new TableColumn("Guest Zipcode");
			col9.setMinWidth(100);
			col9.setCellValueFactory(new PropertyValueFactory<>("guestZ"));
			
			TableColumn col10 = new TableColumn("Dietary Restriction(s)");
			col10.setMinWidth(150);
			col10.setCellValueFactory(new PropertyValueFactory<>("dietaryR"));
			
			TableColumn col11 = new TableColumn("RSVP Status");
			col11.setMinWidth(120);
			col11.setCellValueFactory(new PropertyValueFactory<>("rsvpStatus"));
			
			TableColumn col12 = new TableColumn("Table Number");
			col12.setMinWidth(120);
			col12.setCellValueFactory(new PropertyValueFactory<>("tableN"));
			
			guestTable.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12);
			
					
			try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
				Statement statement=con.createStatement();
				String sql= "SELECT* FROM LsGuest";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					guestData.add(new GuestObject (
							rs.getString("WeddingID"),
							rs.getString("GuestID"),
							rs.getString("GName"),
							rs.getString("GEmail"),
							rs.getString("GPhone"),
							rs.getString("GAddress"),
							rs.getString("GCity"),
							rs.getString("GState"),
							rs.getString("GZip"),
							rs.getString("DietaryRestrict"),
							rs.getString("RSVP"),
							rs.getString("TableNumber")					
							));
					guestTable.setItems(guestData);
				}
				pst.close();
				rs.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			Label label = new Label();
			label.setText(alert);
			Button close = new Button("Close");
			close.setOnAction(e -> window.close());
			
			VBox layout = new VBox(guestTable);
			layout.getChildren().addAll(label, close);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			
		}
		
		// method to display all vendors
		public void allVendors(String title, String alert) {
		
			Stage window = new Stage();
			
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(900);

			vendorTable = new TableView<>();
			final ObservableList <Vendors> vendorData = FXCollections.observableArrayList();
			
			TableColumn col1 = new TableColumn("Wedding ID");
			col1.setMinWidth(100);
			col1.setCellValueFactory(new PropertyValueFactory<>("wedID"));
			
			TableColumn col2 = new TableColumn("Vendor ID");
			col2.setMinWidth(100);
			col2.setCellValueFactory(new PropertyValueFactory<>("vendorID"));
			
			TableColumn col3 = new TableColumn("Vendor Name");
			col3.setMinWidth(150);
			col3.setCellValueFactory(new PropertyValueFactory<>("vName"));
			
			TableColumn col4 = new TableColumn("Vendor Email");
			col4.setMinWidth(150);
			col4.setCellValueFactory(new PropertyValueFactory<>("vEmail"));
			
			TableColumn col5 = new TableColumn("Vendor Phone");
			col5.setMinWidth(150);
			col5.setCellValueFactory(new PropertyValueFactory<>("vPhone"));
			
			TableColumn col6 = new TableColumn("Event ID");
			col6.setMinWidth(120);
			col6.setCellValueFactory(new PropertyValueFactory<>("eventID"));
			
			TableColumn col7 = new TableColumn("Vendor Cost");
			col7.setMinWidth(120);
			col7.setCellValueFactory(new PropertyValueFactory<>("vCost"));
			
					
			vendorTable.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);

			try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			
				String sql= "SELECT* FROM LsVendor";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					vendorData.add(new Vendors (
							rs.getString("WeddingID"),
							rs.getString("VendorID"),
							rs.getString("VName"),
							rs.getString("VEmail"),
							rs.getString("VPhone"),
							rs.getString("EventID"),
							rs.getString("VCost")
							

							));
					vendorTable.setItems(vendorData);
				}
				pst.close();
				rs.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			Label label = new Label();
			label.setText(alert);
			Button close = new Button("Close");
			close.setOnAction(e -> window.close());
			
				
			VBox layout = new VBox(vendorTable);
			layout.getChildren().addAll(label, close);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			
		}
		
		// method to display all wedding events
		public void allEvents(String title, String alert) {
			Stage window = new Stage();
			
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(900);
			eventsTable = new TableView<>();
			final ObservableList <Events> eventsData = FXCollections.observableArrayList();
			
			TableColumn col1 = new TableColumn("Wedding ID");
			col1.setMinWidth(100);
			col1.setCellValueFactory(new PropertyValueFactory<>("wedID"));
			
			TableColumn col2 = new TableColumn("Event ID");
			col2.setMinWidth(100);
			col2.setCellValueFactory(new PropertyValueFactory<>("eventID"));
			
			TableColumn col3 = new TableColumn("Event Date");
			col3.setMinWidth(150);
			col3.setCellValueFactory(new PropertyValueFactory<>("eventD"));
			
			TableColumn col4 = new TableColumn("Event Addresss");
			col4.setMinWidth(150);
			col4.setCellValueFactory(new PropertyValueFactory<>("eventAdd"));
			
			TableColumn col5 = new TableColumn("Event City");
			col5.setMinWidth(150);
			col5.setCellValueFactory(new PropertyValueFactory<>("eventCity"));
			
			TableColumn col6 = new TableColumn("Event State");
			col6.setMinWidth(120);
			col6.setCellValueFactory(new PropertyValueFactory<>("eventState"));
			
			TableColumn col7 = new TableColumn("Event Zipcode");
			col7.setMinWidth(120);
			col7.setCellValueFactory(new PropertyValueFactory<>("eventZip"));
			
			TableColumn col8 = new TableColumn("Event Name");
			col8.setMinWidth(120);
			col8.setCellValueFactory(new PropertyValueFactory<>("eventName"));
			
					
			eventsTable.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8);
			
				
			try { 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "password");
			
				String sql= "SELECT* FROM LsEvents";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					eventsData.add(new Events (
							rs.getString("WeddingID"),
							rs.getString("EventID"),
							rs.getString("EDate"),
							rs.getString("EAddress"),
							rs.getString("ECity"),
							rs.getString("EState"),
							rs.getString("EZip"),
							rs.getString("EName")
							

							));
					eventsTable.setItems(eventsData);
				}
				pst.close();
				rs.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			Label label = new Label();
			label.setText(alert);
			Button close = new Button("Close");
			close.setOnAction(e -> window.close());
			
			VBox layout = new VBox(eventsTable);
			layout.getChildren().addAll(label, close);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			
		}
		
		

    // main method to launch the GUI
	public static void main(String[] args) {
		
		launch(args);

	}
	
}
;