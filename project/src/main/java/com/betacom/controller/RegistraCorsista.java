package com.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.facade.AdminFacade;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;

@WebServlet("/registra")
public class RegistraCorsista extends HttpServlet {
	private static final long serialVersionUID = -3821495915968320464L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		int precForm = 1;
		
		if(request.getParameter("formPrec") == null)
			precForm = 0;
		
		Corsista corsista = new Corsista();
		corsista.setNomeCorsista(nome);
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecForm(precForm);
		
		Corso corso = (Corso) session.getAttribute("corso");
		
		try {
			AdminFacade.getInstance().createCorsista(corsista, corso);
			response.sendRedirect("home.jsp");
		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
		
	}

}
