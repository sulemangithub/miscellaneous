<html>
<head>


<script>

var min=<%=session.getAttribute("minutes")%>
var seconds=<%=session.getAttribute("seconds")%>

function increaseTime()
{
seconds--;
if(seconds==0)
{
min--;
seconds=60;
}

if(min<=0 && seconds<=60)
	{
	document.getElementById("s").innerHTML="TIME OVER";
	}
else
	{
		document.getElementById("s").innerHTML="REMAINING TIME :"+min+":"+seconds;
	}
setTimeout("increaseTime()",1000);

}

function setTimeToServer()
{
	xmlHttp1=new XMLHttpRequest();
	
	var str="SaveTime1.jsp?min="+min+"&sec="+seconds;
	
	xmlHttp1.open("GET", str);
	
	xmlHttp1.onreadystatechange=function()
	{
		if(xmlHttp1.readyState==4 && xmlHttp1.status==200)
			{
				alert("22");
				alert(xmlHttp1.responseText);		
			}
	}
	
	xmlHttp1.send();	
	
}



</script>
</head>
<body onunload="setTimeToServer()" onload="increaseTime()">

<span id="s"></span>

</body>

</html>