function validateUserName() {
	var userId = document.getElementById("userId").value;
	if (userId == '') {
		alert('Please enter a valid User Name.');
		return false;
	} else {
		return true;
	}
}

function validateUserID() {
	var regex =  /^\+?([0-9]{2})\)?\d{10}$/;
	var name = document.getElementById("name").value;
	var phone = document.getElementById("phone").value;
	if (name == '') {
		alert('Please enter a valid Name.');
		return false;
	}else if(!regex.test(phone)) {
		alert('Please enter a valid Phone number with Country code');
		return false;
	}
	else {
		return true;
	}
}
