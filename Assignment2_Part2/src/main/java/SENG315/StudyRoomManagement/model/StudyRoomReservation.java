package SENG315.StudyRoomManagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudyRoomReservation {
	
	int srmsID;
	Date date;
	int studentID;
	String studentName;
	String contactNumber;
	String estDepartTime;
	int estNumStudents;
	int roomNum;
	String arrivalTime;
	String departTime;
	
	public String addSRReservation() {
		
		String message="Reservation Added";
			try {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("SENG315.StudyRoomManagement");
			context.refresh();
	
			MSSQLConnection mssqlConnection = context.getBean("MSSQLConnection", MSSQLConnection.class);
			Connection connection = mssqlConnection.getConnection();
			
				String addSRReservation = "INSERT "+mssqlConnection.getDatabase()+".dbo.reservations " +
						"(date, studentID, studentName, contactNumber, estDepartTime, estNumStudents, roomNum, arrivalTime, departTime) VALUES (?,?,?,?,?,?,?,?,?)";
			
				PreparedStatement ps = connection.prepareStatement(addSRReservation);
				
				Date date2 = new Date();
				
				//ps.setInt(1, srmsID);
				ps.setTimestamp(1, new java.sql.Timestamp(date2.getTime()));
				ps.setInt(2, studentID);
				ps.setString(3, studentName);
				ps.setString(4, contactNumber);
				ps.setString(5, estDepartTime);
				ps.setInt(6, estNumStudents);
				ps.setInt(7, roomNum);
				ps.setString(8, arrivalTime);
				ps.setString(9, departTime);
				
				ps.executeUpdate();
				
				try { if (ps!= null) ps.close(); } catch (Exception e) {};
				try { if (connection != null) connection.close(); } catch (Exception e) {}; 
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		return message;
	}
	
	public String updateReservation() {
		
		String message="Reservation Updated";
		try {
				
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("SENG315.StudyRoomManagement");
			context.refresh();
			
			MSSQLConnection mssqlConnection = context.getBean("MSSQLConnection", MSSQLConnection.class);
		
			Connection connection = mssqlConnection.getConnection();
			String updateReservation = "UPDATE "+mssqlConnection.getDatabase()+".dbo.reservations SET " +
					"studentID=IsNull(NullIf(?,''), studentID), "+
					"studentName=IsNull(NullIf(?,''),studentName), contactNumber=IsNull(?,contactNumber),"+
					"estDepartTime=IsNull(?,estDepartTime), estNumStudents=IsNull(?,estNumStudents), "+
					"roomNum=IsNull(?,roomNum), arrivalTime=IsNull(?,arrivalTime), departTime=IsNull(?,departTime) "+
					"WHERE srmsID="+srmsID+"";

				PreparedStatement ps = connection.prepareStatement(updateReservation);
				
				System.out.println(ps);
				
				ps.setInt(1, studentID);
				ps.setString(2, studentName);
				ps.setString(3, contactNumber);
				ps.setString(4, estDepartTime);
				ps.setInt(5, estNumStudents);
				ps.setInt(6, roomNum);
				ps.setString(7, arrivalTime);
				ps.setString(8, departTime);
				
				ps.executeUpdate();
				
				try { if (ps!= null) ps.close(); } catch (Exception e) {};
				try { if (connection != null) connection.close(); } catch (Exception e) {}; 
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		return message;
	}

	public int getSrmsID() {
		return srmsID;
	}
	public void setSrmsID(int srmsID) {
		this.srmsID = srmsID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEstDepartTime() {
		return estDepartTime;
	}
	public void setEstDepartTime(String estDepartTime) {
		this.estDepartTime = estDepartTime;
	}
	public int getEstNumStudents() {
		return estNumStudents;
	}
	public void setEstNumStudents(int estNumStudents) {
		this.estNumStudents = estNumStudents;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public StudyRoomReservation listSRReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	public static JSONArray listReservations() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("SENG315.StudyRoomManagement");
		context.refresh();
		
		MSSQLConnection mssqlConnection = context.getBean("MSSQLConnection", MSSQLConnection.class);
		
		String sqlString = "SELECT * " +
				"FROM "+mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) ";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
			
		return sqlQuery.lstQuery();
	}

	public JSONObject getReservation() {
		//MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("SENG315.StudyRoomManagement");
		context.refresh();
		
		MSSQLConnection mssqlConnection = context.getBean("MSSQLConnection", MSSQLConnection.class);
		
		String sqlString = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " + 
				"WHERE srmsID = "+srmsID+"";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
	}
	
	public String deleteReservation() {
		
		String message="Reservation " + srmsID + " Deleted";
			try {
			
			//MSSQLConnection mssqlConnection = new MSSQLConnection();
			
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("SENG315.StudyRoomManagement");
				context.refresh();
				
				MSSQLConnection mssqlConnection = context.getBean("MSSQLConnection", MSSQLConnection.class);
				
				Connection connection = mssqlConnection.getConnection();
			
				String delete = "DELETE FROM "+mssqlConnection.getDatabase()+".dbo.reservations " +
						"WHERE srmsID="+srmsID+"";
			
				PreparedStatement ps = connection.prepareStatement(delete);
				
				ps.executeUpdate();
				
				try { if (ps!= null) ps.close(); } catch (Exception e) {};
				try { if (connection != null) connection.close(); } catch (Exception e) {}; 
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		return message;
	}

	
}
