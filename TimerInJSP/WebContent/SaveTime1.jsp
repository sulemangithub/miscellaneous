<%

String minutes=request.getParameter("min");
String seconds=request.getParameter("sec");

session.setAttribute("minutes", minutes);
session.setAttribute("seconds", seconds);

System.out.println(minutes);
System.out.println(seconds);

out.println("DONE...");

%>