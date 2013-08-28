$(document).ready(function() {
	$("#div_PleaseWait").hide();
	$("#div_GetFile").hide();
	$("#div_NoFile").hide();
});

function cmd_GetFileOnClick() {
	$("#div_GetFile").hide();
	$("#div_NoFile").hide();
	$("#div_PleaseWait").show();
	var txt_InputFileCode = document.getElementById("txt_InputFileCode");
	txt_InputFileCode.value = $.trim(txt_InputFileCode.value);
	var fileIndex = $.trim(txt_InputFileCode.value);
	$.post("./", {
		fileIndex : fileIndex
	}, serverReply);
}

function serverReply(reply) {
	$("#div_PleaseWait").hide();
	if (reply == "NO_FILE") {
		$("#div_NoFile").show();
	} else {
		
		var reply = reply.split("~");
		var fileName = reply[0];
		var fileCode = reply[1];
		$("#div_GetFile").show();
		$("#txt_FileName").html(fileName);
		$("#txt_FileCode").html(fileCode);
		var link = "./" + fileCode + "/";
		$("#txt_FileName").attr("href", link);
		$("#cmd_Download").attr("href", link);
	}
}

