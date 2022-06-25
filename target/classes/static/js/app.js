function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function validateUserID() {
	var name = document.getElementById("userId").value;
	if (name == '') {
		alert('Please Fill Valid User ID and Password.');
		return false;
	} else {
		return true;
	}
}

function AddNewContact()
{
window.transfer("AddNew.jsp");
}

function sample() {
window.transfer("AddNew.jsp","_self"); 
}
