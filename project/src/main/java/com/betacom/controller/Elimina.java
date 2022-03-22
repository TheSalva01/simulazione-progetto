package com.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/elimina")
public class Elimina extends HttpServlet {

	private static final long serialVersionUID = 3886988427943376675L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("bottone", "elimina");
		response.sendRedirect("elencocorsi.jsp");
	}

}
