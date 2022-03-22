package com.betacom.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.facade.AdminFacade;
import com.betacom.businesscomponent.model.Corso;

@WebServlet("/eliminacorso")
public class EliminaCorso extends HttpServlet {
	private static final long serialVersionUID = -220175088726066682L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Corso corso = new Corso();
			corso.setCodCorso(Long.parseLong(request.getParameter("codCorso")));
			corso.setNomeCorso(request.getParameter("nomeCorso"));
			corso.setDataInizioCorso(formato.parse(request.getParameter("dataInizio")));
			corso.setDataFineCorso(formato.parse(request.getParameter("dataFine")));
			corso.setCostoCorso(Double.parseDouble(request.getParameter("costoCorso")));
			corso.setCommentiCorso(request.getParameter("commenti"));
			corso.setAulaCorso(request.getParameter("aula"));
			corso.setDocente(Integer.parseInt(request.getParameter("docente")));
			AdminFacade.getInstance().deleteCorso(corso);
			response.sendRedirect("elencocorsi.jsp");
		} catch (DAOException | ClassNotFoundException | IOException | ParseException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
