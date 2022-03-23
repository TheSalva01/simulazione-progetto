package com.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/riepilogocorsi")
public class RiepilogoCorsi extends HttpServlet {
	private static final long serialVersionUID = -1168636510029424755L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("codCorso", request.getParameter("codCorso"));
		response.sendRedirect("riepilogoCorsista.jsp");
	}
}
