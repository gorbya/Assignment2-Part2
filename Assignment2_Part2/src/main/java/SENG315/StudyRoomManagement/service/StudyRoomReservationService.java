
package SENG315.StudyRoomManagement.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import SENG315.StudyRoomManagement.model.StudyRoomReservation;

public class StudyRoomReservationService {

	public static JSONArray listReservations() {
		
		JSONArray results = new JSONArray();
		
		StudyRoomReservation srr = new StudyRoomReservation();
		results = srr.listReservations();

		return results;
	}
	

	 public static JSONObject getReservation(int id) {
		 
		 JSONObject jo = new JSONObject();
		 
	     StudyRoomReservation srr = new StudyRoomReservation();
		 srr.setSrmsID(id);
		 
		 jo=srr.getReservation();
		 
		 return jo;
	 }
	
	 public static JSONObject updateReservation(JSONObject inputParms) {
		 
		 String message = "";
		 
		 JSONObject result = new JSONObject();
			
		try {
			
			message = populateAndUpdateReservation(inputParms);

				result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}


	private static String populateAndUpdateReservation(JSONObject inputParms) {
		String message;
		int srmsID = inputParms.getInt("srmsID");
		int studentID = inputParms.getInt("studentID");
		String studentName = inputParms.getString("studentName");
		String contactNumber = inputParms.getString("contactNumber");
		String estDepartTime = inputParms.getString("estDepartTime");
		int estNumStudents = inputParms.getInt("estNumStudents");
		int roomNum = inputParms.getInt("roomNum");
		String arrivalTime = inputParms.getString("arrivalTime");
		String departTime = inputParms.getString("departTime");
			
		StudyRoomReservation SRReservation = new StudyRoomReservation();

		SRReservation.setSrmsID(srmsID);
		SRReservation.setStudentID(studentID);
		SRReservation.setStudentName(studentName);
		SRReservation.setContactNumber(contactNumber);
		SRReservation.setEstDepartTime(estDepartTime);
		SRReservation.setEstNumStudents(estNumStudents);
		SRReservation.setRoomNum(roomNum);
		SRReservation.setArrivalTime(arrivalTime);
		SRReservation.setDepartTime(departTime);
		
		message = SRReservation.updateReservation();
		return message;
	}
	 
	public static JSONObject addReservation(JSONObject inputParms) {
			
		String message = "";
		JSONObject result = new JSONObject();
			
		try {

			int studentID = inputParms.getInt("studentID");
			String studentName = inputParms.getString("studentName");
			String contactNumber = inputParms.getString("contactNumber");
			String estDepartTime = inputParms.getString("estDepartTime");
			int estNumStudents = inputParms.getInt("estNumStudents");
			int roomNum = inputParms.getInt("roomNum");
			String arrivalTime = inputParms.getString("arrivalTime");
			String departTime = inputParms.getString("departTime");
				
			StudyRoomReservation SRReservation = new StudyRoomReservation();
		
			SRReservation.setStudentID(studentID);
			SRReservation.setStudentName(studentName);
			SRReservation.setContactNumber(contactNumber);
			SRReservation.setEstDepartTime(estDepartTime);
			SRReservation.setEstNumStudents(estNumStudents);
			SRReservation.setRoomNum(roomNum);
			SRReservation.setArrivalTime(arrivalTime);
			SRReservation.setDepartTime(departTime);

			message = SRReservation.addSRReservation();

				result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	return result;
	}
	
	public static JSONObject deleteReservation(JSONObject inputParms) {
		
		System.out.println(inputParms.getInt("srmsID"));
		
		String message = "";
		JSONObject result = new JSONObject();
			
		try {
			
			int srmsID = inputParms.getInt("srmsID");			
			StudyRoomReservation srr = new StudyRoomReservation();
			srr.setSrmsID(srmsID);
			
			message = srr.deleteReservation();

				result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	return result;
	}
}

