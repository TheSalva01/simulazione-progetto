package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

public class CorsoDAO implements DAOConstants {
	private CachedRowSet rowSet;

	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}
	
	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, entity.getCostoCorso());
			rowSet.updateString(6, entity.getCommentiCorso());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, entity.getCodCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	
	public int getAVGDay(Connection conn) throws DAOException {
			int valore = 0;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_MEDIA_CORSO);
			if(rs.next()) 
				valore = (int) rs.getDouble(1); 
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return valore;
	}
	
	public Corso getById(Connection conn, long cod_corso) throws DAOException {
		Corso corso  = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYID);
			ps.setLong(1, cod_corso);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corso = new Corso();
				corso.setCodCorso(rs.getInt(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setDocente(rs.getInt(8));
			}	
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	public List<Corso> getAll(Connection conn) throws DAOException {
		List<Corso> corsi = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso c = new Corso();
				c.setCodCorso(rs.getInt(1));
				c.setNomeCorso(rs.getString(2));
				c.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				c.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				c.setCostoCorso(rs.getDouble(5));
				c.setCommentiCorso(rs.getString(6));
				c.setAulaCorso(rs.getString(7));
				c.setDocente(rs.getInt(8));
				corsi.add(c);
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
	

	public List<Docente> getDocenti(Connection conn) throws DAOException {
		List<Docente> docenti = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_CORSI);
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente d = new Docente();
				d.setCodDocente(rs.getInt(1));
				d.setNomeDocente(rs.getString(2));
				d.setCognomeDocente(rs.getString(3));
				d.setCvDocente(rs.getString(4));
				d.setCodCorso(rs.getInt(5));
				docenti.add(d);
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}

}