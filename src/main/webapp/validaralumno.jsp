<% 
	if (session.getAttribute("alumnos") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("loginalumnos.jsp");
	}
%>