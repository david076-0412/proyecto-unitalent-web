
<% 
	if (session.getAttribute("docentes") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("login.jsp");
	}
%>