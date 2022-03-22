package com.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.utility.LoginUtility;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("nome_admin");
		String password = request.getParameter("cod_admin");
		
		HttpSession session = request.getSession();
		int i = (int) session.getAttribute("contatore");
		String adminpass;

		if (username != null && password != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminpass = lU.getCodAdmin(username);

				if (adminpass != null) {
					if (adminpass.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("home.jsp");
					} else if (!adminpass.equals(password) && i < 5) {
						session.setAttribute("contatore", i+1);
					} else if (!adminpass.equals(password) && i == 5) {
						session.setAttribute("contatore", 0);
						response.sendRedirect("accessonegato.jsp");
					}
				}
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
}