<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:layout>
	<div id="sec_FrameResult">	
	    <p>
	        <span id="lb_Label">The code of your file is:</span>
	        <span id="lb_Code">${fileIndex}</span>
	    </p>        
	    <p>
	        <span id="lb_Label">The QR code of your file is:</span>
	    </p>
	    <img src="https://chart.googleapis.com/chart?chs200x200&cht=qr&chl${fileIndex}"/>
	</div>  
</l:layout>