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

function cmd_CancelOnClick() {
	window.location.reload();
}