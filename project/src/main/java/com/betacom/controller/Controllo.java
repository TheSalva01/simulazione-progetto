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
		int i = 0;
		if (session.getAttribute("contatore") != null) {
			i = (int) session.getAttribute("contatore");
		}
		String admincode;

		if (username != null && password != null) {
			try {
				LoginUtility lU = new LoginUtility();
				admincode = lU.getCodAdmin(username);
				if (i == 5) {
					response.sendRedirect("accessonegato.jsp");
					return;
				}
				if (admincode != null) {
					if (admincode.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("home.jsp");
					} else if (!admincode.equals(password)) {
						session.setAttribute("contatore", i + 1);
						response.sendRedirect("home.jsp");
					} else if (!admincode.equals(password)) {
						session.setAttribute("contatore", i + 1);
						response.sendRedirect("home.jsp");
					}
				} else if (admincode == null) {
					session.setAttribute("contatore", i + 1);
					response.sendRedirect("home.jsp");
				}
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
}