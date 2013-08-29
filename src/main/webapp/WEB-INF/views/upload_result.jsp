<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:layout>
	<div id="sec_FrameResult">
		<p>
	        <span>File name:</span>
	        <span><b>${fileName}</b></span>
	    </p>	
	    <p>
	        <span>The code of your file is:</span>
	        <span><b>${fileIndex}</b></span>
	    </p>        
	    <p>
	        <span>The QR code of your file is:</span>
	    </p>
	    <img src="https://chart.googleapis.com/chart?chs=200x200&cht=qr&chl=${fileIndex}"/>
	</div>  
</l:layout>