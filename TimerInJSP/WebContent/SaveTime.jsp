<%

String choice=request.getParameter("choice");

if( choice!=null && choice.equals("set"))
{
	String time=request.getParameter("remTime");
	session.setAttribute("time", time);
	out.println("set");	
}
else
{
	String t=(String)session.getAttribute("remTime");
	if(t==null)
	{
		session.setAttribute("remTime", "4:60");
	}	
	out.println("dkfjkdfjdfjdjjf");
}

%>