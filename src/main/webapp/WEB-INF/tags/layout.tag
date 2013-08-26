<%@tag import="org.springframework.context.annotation.Import"%>
<%@tag import="com.fastsharing.config.RequestMap"%>
<html>
	<head>
		<title>Fast sharing</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/indexStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/${fileName}.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/${fileName}.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="span12">
					<img src="${pageContext.request.contextPath}/img/FastSharingIcon.png" id="icon" alt="FastSharing icon" />
				</div>
				<div class="span12">
					<jsp:doBody/>				
				</div>			
				<div class = "span12">					
					<a class="btn btn-danger btn-large cmd_SubmitButton" href="${pageContext.request.contextPath}<%=RequestMap.UPLOAD_MAP%>">Upload file</a>&nbsp;&nbsp;&nbsp;			
					<a class="btn btn-info btn-large cmd_SubmitButton" href="${pageContext.request.contextPath}<%=RequestMap.DOWNLOAD_MAP%>">Download file</a> &nbsp;&nbsp;&nbsp;
					<a class="btn btn-success btn-large cmd_SubmitButton" href="${pageContext.request.contextPath}<%=RequestMap.HOW_TO_USE_MAP%>">How to use</a> &nbsp;&nbsp;&nbsp;
					<a class="btn btn-info btn-large cmd_SubmitButton" id="cmd_SubmitButtonPurple" href="${pageContext.request.contextPath}<%=RequestMap.ABOUT_US_MAP%>">About us</a>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>
	</body>
</html>