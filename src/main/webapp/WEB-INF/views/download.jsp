<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:layout>
	<div class="row">
		<div class="span12">
			<span class="lead" id="lb_Label">Type in your file code here:</span>
		</div>
		<div class="span12">    
	        <form>
	            <div class="input-append">
	                <input type="text" id="txt_InputFileCode"/>
	                <input class="btn btn-primary btn-small" type="button" value="Get file" onclick="cmd_GetFileOnClick()"/>            
	            </div>
	        </form>
        </div>	   
        <div class="span12" id="div_PleaseWait">
        	<img src="${pageContext.request.contextPath}/img/circle.gif" />
        </div>
        <div class="span12" id="div_NoFile">
        	<span class="lead">There is no file having that code</span>
        </div>  
        <div id="div_GetFile">
            <p>
                <span class="lead" id="lb_Label">The code of the current file is:</span>
                <span class="lead" id="txt_FileCode"></span>
            </p>
            <p>
            	<a id="txt_FileLink" href=""></a>
            </p>
            <p>
                <a id="txt_FileName" href=""></a>&nbsp;&nbsp;&nbsp;
                <a class="btn btn-success txt_FileName" id="cmd_Download" href="">Download  <i class="icon-download-alt"></i></a>     
            </p>	
        </div>
	</div>
	<span class="hide" id="var_contextPath">${pageContext.request.contextPath}</span>	
</l:layout>