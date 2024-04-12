<% 
	if (session.getAttribute("admin") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("loginadmin.jsp");
	}
%>