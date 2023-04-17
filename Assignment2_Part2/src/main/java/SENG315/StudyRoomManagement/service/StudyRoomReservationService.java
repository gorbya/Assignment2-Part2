
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
			
			message = createAndUpdateReservation(inputParms);

				result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		}


	private static String createAndUpdateReservation(JSONObject inputParms) {
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


//package SENG315.StudyRoomManagement.service;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import SENG315.StudyRoomManagement.model.StudyRoomReservation;
//
//public class StudyRoomReservationService {
//	
//	public static JSONArray list() {
//		JSONArray articles = new JSONArray();
//		
//		StudyRoomReservation srr = new StudyRoomReservation();
//		srr = srr.listSRReservation();
//		
//		return articles;
//	}
//
//	public static JSONObject addSRReservation(JSONObject inputParms) {
//	
//		String message = "";
//		JSONObject result = new JSONObject();
//		
//		
//		try {
//			
//			int studentID = inputParms.getInt("studentID");
//			String studentName = inputParms.getString("studentName");
//			String contactNumber = inputParms.getString("contactNumber");
//			String estDepartTime = inputParms.getString("estDepartTime");
//			int estNumStudents = inputParms.getInt("estNumStudents");
//			int roomNum = inputParms.getInt("roomNum");
//			String arrivalTime = inputParms.getString("arrivalTime");
//			String departTime = inputParms.getString("departTime");
//				
//			StudyRoomReservation SRReservation = new StudyRoomReservation();
//		
//			SRReservation.setStudentID(studentID);
//			SRReservation.setStudentName(studentName);
//			SRReservation.setContactNumber(contactNumber);
//			SRReservation.setEstDepartTime(estDepartTime);
//			SRReservation.setEstNumStudents(estNumStudents);
//			SRReservation.setRoomNum(roomNum);
//			SRReservation.setArrivalTime(arrivalTime);
//			SRReservation.setDepartTime(departTime);
//			
//			message = SRReservation.addSRReservation();
//	
//			result.put("message", message);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
//
//	public static JSONObject updateReservation(JSONObject inputParms) {
//		
//		String message = "";
//		JSONObject result = new JSONObject();
//		
//		System.out.println(inputParms);
//		
//		
//		try {
//			int studentID = inputParms.getInt("studentID");
//			String studentName = inputParms.getString("studentName");
//			String contactNumber = inputParms.getString("contactNumber");
//			String estDepartTime = inputParms.getString("estDepartTime");
//			int estNumStudents = inputParms.getInt("estNumStudents");
//			int roomNum = inputParms.getInt("roomNum");
//			String arrivalTime = inputParms.getString("arrivalTime");
//			String departTime = inputParms.getString("departTime");
//			
//			StudyRoomReservation SRRev = new StudyRoomReservation();
//			
//			SRRev.setStudentID(studentID);
//			SRRev.setStudentName(studentName);
//			SRRev.setContactNumber(contactNumber);
//			SRRev.setEstDepartTime(estDepartTime);
//			SRRev.setEstNumStudents(estNumStudents);
//			SRRev.setRoomNum(roomNum);
//			SRRev.setArrivalTime(arrivalTime);
//			SRRev.setDepartTime(departTime);
//
//			message = SRRev.updateReservation();
//
//			result.put("message", message);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
//	
//	 public static JSONObject getReservation(int id) {
//		 
//		 JSONObject jo = new JSONObject();
//		 
//	     StudyRoomReservation srr = new StudyRoomReservation();
//		 srr.setSrmsID(id);
//		 
//		 jo=srr.getReservation();
//		 
//		 return jo;
//	 }
//	 
//		public JSONArray listReservations() {
//			
//			JSONArray results = new JSONArray();
//			
//			StudyRoomReservation srr = new StudyRoomReservation();
//			results = srr.listReservations();
//
//			return results;
//		}
//		
//		public static JSONObject deleteReservation(JSONObject inputParms) {
//			
//			System.out.println(inputParms);
//			
//			String message = "";
//			JSONObject result = new JSONObject();
//				
//			try {
//				
//				int srmsID = inputParms.getInt("srmsID");			
//				StudyRoomReservation srr = new StudyRoomReservation();
//				srr.setSrmsID(srmsID);
//				
//				message = srr.deleteReservation();
//
//					result.put("message", message);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				
//		return result;
//		}
//}