<%@ taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<l:layout>
	<div class="row">
		<div class="span12" id="sec_UpLoadForm">
			<form:form name="frm_UpLoadForm" id="frm_UpLoadForm"
				modelAttribute="uploadForm" enctype="multipart/form-data"
				method="post">
				<input type="file" name="theFile" id="theFile" class="hide"
					onchange="fileSelected()" />
				<p>
					<input class="btn btn-primary" type="button" value="Select File"
						onclick="cmd_SelectFileOnClick()" /> <input
						class="btn btn-primary" type="button" value="Start upload"
						onclick="cmd_UploadOnClick()" />
				</p>
				<span class="muted" id="txt_FileName">Please select file</span>
			</form:form>
		</div>
		<div class="span12" id="sec_ProgressIndicator">
			<div class="row">
				<div class="span12" id="div_PleaseWait">
					<img src="${pageContext.request.contextPath}/img/circle.gif" />
				</div>
				<div class="span12">
					<input class="cmd_SubmitButton" type="button" value="Cancel upload"
						onclick="cmd_CancelOnClick()" />
				</div>
			</div>
		</div>
	</div>
</l:layout>