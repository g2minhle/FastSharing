$(document).ready(function() {
	$("#sec_ProgressIndicator").toggle();
});

function cmd_SelectFileOnClick() {
	var theFile = document.getElementById("theFile");
	theFile.click();
}

function fileSelected() {
	$("#txt_FileName").html("File path : " + $("#theFile").val());
}

function cmd_UploadOnClick() {
	var theFile = $("#theFile");
	var frm_UpLoadForm = document.getElementById("frm_UpLoadForm");
	if (theFile.val() == "") {
		alert("No file selected");
	} else {
		$("#sec_ProgressIndicator").toggle(1000);
		frm_UpLoadForm.submit();
	}
}

function cmd_CancelOnClick() {
	window.location.reload();
}