//Client side API call using AJAX
function listReservations(){
	
	$.ajax({
		url: "../../StudyRoomManagementService/studyroomreservations",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {

       		var lstResults = "<tr><td><a href ='./index4.html?srmsID="+value.srmsID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit ||  </span></a>" +
       		"<a href = './index5.html?srmsID="+value.srmsID+"' onclick=deleteReservation('"+value.srmsID+"') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
	            "<td>"+value.studentName+"</td><td>"+value.studentID+"</td><td>"+value.roomNum+"</td>"+
	    		"<td>"+value.contactNumber+"</td><td>"+value.estDepartTime+"</td><td>"+value.estNumStudents+"</td><td>"+value.arrivalTime+"</td><td>"+value.departTime+"</td></tr>";

       		if($("#reservationBody").text()){
    			document.getElementById('reservationBody').innerHTML += lstResults;
    		}
    	});
	});
}
//    	$.each(response, function(key, value) {
//	
//					if(value.categoryContent.length > 150){
//				value.categoryContent = value.categoryContent.substring(0,150) + "...";
//			}
//    		//var lstResults = "<tr><td>"+value.articleID+"</td><td>"+value.articleAuthorID+"</td><td>"+value.articleTitle+"</td><td>"+value.articleContent+"</td></tr>";
//       		
//       		var lstResults = "<tr><td><a href ='./index.jsp?view=catedit&edit="+value.categoryID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a>" +
//       		"<a href = '#' onclick=deleteCatModal('"+value.categoryID+"','"+encodeURIComponent(value.categoryName)+"') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
//	            "<td>"+value.categoryID+"</td><td>"+value.navigationID+"</td><td>"+value.categoryName+"</td>"+
//	    		"<td>"+value.categoryImage+"</td><td>"+value.categoryContent+"</td><td>"+value.categoryOrder+"</td><td>"+value.categoryVisible+"</td></tr>";
//
//       		if($("#categoryBody").text()){
//    			document.getElementById('categoryBody').innerHTML += lstResults;
//    		}
//    	});
//	});
//}

function addReservation(){
	
	
	var studentID = $("#studentID").val();
	var studentName = $("#studentName").val();
	var contactNumber = $("#contactNumber").val();
	var estDepartTime	 = $("#estDepartTime").val();
	var estNumStudents = $("#estNumStudents").val();
	var roomNum = $("#roomNum").val();
	var arrivalTime = $("#arrivalTime").val();
	var departTime = $("#departTime").val();
	
	var parms = {studentID:studentID, studentName:studentName, contactNumber:contactNumber, estDepartTime:estDepartTime, estNumStudents:estNumStudents, roomNum:roomNum, arrivalTime:arrivalTime, departTime:departTime  }
	
	$.ajax({
		url: "../../StudyRoomManagementService/studyroomreservations",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

		alert(response.message);
		window.location = "./"
		
	});
	}
function updateReservation(){
	
	var studentID = $("#studentID").val();
	var studentName = $("#studentName").val();
	var contactNumber = $("#contactNumber").val();
	var estDepartTime	 = $("#estDepartTime").val();
	var estNumStudents = $("#estNumStudents").val();
	var roomNum = $("#roomNum").val();
	var arrivalTime = $("#arrivalTime").val();
	var departTime = $("#departTime").val();
		
	var parms = {srmsID:srmsID, studentID:studentID, studentName:studentName, contactNumber:contactNumber, estDepartTime:estDepartTime, estNumStudents:estNumStudents, roomNum:roomNum, arrivalTime:arrivalTime, departTime:departTime  }
	
	$.ajax({
		url: "../../StudyRoomManagementService/studyroomreservations",
		type: 'PUT',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

		alert(response.message);
		window.location = "./index3.html"
		
	});
	}
	
function deleteReservation(){
	
	var studentID = $("#studentID").val();
	var studentName = $("#studentName").val();
	var contactNumber = $("#contactNumber").val();
	var estDepartTime	 = $("#estDepartTime").val();
	var estNumStudents = $("#estNumStudents").val();
	var roomNum = $("#roomNum").val();
	var arrivalTime = $("#arrivalTime").val();
	var departTime = $("#departTime").val();
	
	var parms = {srmsID:srmsID, studentID:studentID, studentName:studentName, contactNumber:contactNumber, estDepartTime:estDepartTime, estNumStudents:estNumStudents, roomNum:roomNum, arrivalTime:arrivalTime, departTime:departTime  }
	
	$.ajax({
		url: "../../StudyRoomManagementService/studyroomreservations",
		type: 'DELETE',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

		window.location = "./index3.html"
		
	});
	}
	
function getReservation(srmsID){
		
		$.ajax({
			url: "../../StudyRoomManagementService/studyroomreservations/"+srmsID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    
	    	$("#studentID").val(response.studentID);
			$("#studentName").val(response.studentName);
			$("#contactNumber").val(response.contactNumber);
			$("#estDepartTime").val(response.estDepartTime);
			$("#estNumStudents").val(response.estNumStudents);
			$("#roomNum").val(response.roomNum);
			$("#arrivalTime").val(response.arrivalTime);
			$("#departTime").val(response.departTime);
			

		});
	}
	
	function deleteCatModal(catID, catName){
		
		$("#deleteCatModal").modal('show');
		$("#catID").text(catID);
		$("#catName").text(decodeURIComponent(catName));
		
		
	}
	