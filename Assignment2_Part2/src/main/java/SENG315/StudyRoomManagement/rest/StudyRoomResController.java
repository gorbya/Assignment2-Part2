package SENG315.StudyRoomManagement.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENG315.StudyRoomManagement.model.StudyRoomReservation;
import SENG315.StudyRoomManagement.service.StudyRoomReservationService;

@RestController
@RequestMapping("/studyroomreservations")
public class StudyRoomResController {
	
	@GetMapping
	public String listReservarions(){
		JSONArray reservations = StudyRoomReservation.listReservations();
		return reservations.toString();
	}
	
	@GetMapping(path="/{id}")
	public String getReservation(@PathVariable int id) {
		JSONObject reservations = StudyRoomReservationService.getReservation(id);
		return reservations.toString();
	}
	
	
	@PutMapping
	public String updateStudyRoomRes(@RequestBody String inputParms) {

		JSONObject result;
		try {
			result = StudyRoomReservationService.updateReservation(new JSONObject(inputParms));
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "UpdateSRR_APIFailed";
		

	}
	
	@DeleteMapping
	public String deleteReservation(@RequestBody String inputParms) {
		
		try {
			JSONObject result = StudyRoomReservationService.deleteReservation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "deleteReservationAPI Failed";
		}
	}
	
	
	
	@PostMapping
	public String addStudyRoomRes(@RequestBody String inputParms) {
		
		try {
			JSONObject result = StudyRoomReservationService.addReservation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "add SRR API Failed";
		}
	}
	
}
