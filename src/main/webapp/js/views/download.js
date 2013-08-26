$(document).ready(function() {
	$("#div_PleaseWait").toggle();
	$("#div_GetFile").toggle();
});

function cmd_GetFileOnClick() {
	$("#div_PleaseWait").toggle();
	var txt_InputFileCode = document.getElementById("txt_InputFileCode");
	txt_InputFileCode.value = $.trim(txt_InputFileCode.value);
	var fileIndex = $.trim(txt_InputFileCode.value);
	$.post("./", {
		fileIndex : fileIndex
	}, serverReply);
}

function serverReply(reply) {
	//var data = reply.split("|");
	if (message.substring(0, 2) == "HAS_FILE") {
		$("#div_GetFile").toggle(1000);
		$("#txt_FileName").html(fileName);
		$("#txt_FileCode").html(fileCode);
		var fileCode = $("txt_InputFileCode").val();
		var fileName = message.substring(3);
		var sec_GetFile = document.getElementById("sec_GetFile");
		var frm_DownLoadForm = document.getElementById("frm_DownLoadForm");
		var link = "storage/" + fileCode + "/" + fileName;
		sec_GetFile.style.display = "block";
		txt_FileName.href = link;
		frm_DownLoadForm.action = link;
	} else if (message.substring(0, 2) == "NO_FILE") {
		UpdateMessage("There is no file having that code", null);
	} else {
		UpdateMessage(message, null);
	}

}
