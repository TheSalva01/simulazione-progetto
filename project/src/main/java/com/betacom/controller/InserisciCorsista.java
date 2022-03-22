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

import com.betacom.businesscomponent.model.Corso;

@WebServlet("/inseriscicorsista")
public class InserisciCorsista extends HttpServlet {

	private static final long serialVersionUID = -3576117997079904190L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
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
			
			HttpSession session = request.getSession();
			session.setAttribute("corso", corso);
			response.sendRedirect("registra.jsp");
		} catch(ParseException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
