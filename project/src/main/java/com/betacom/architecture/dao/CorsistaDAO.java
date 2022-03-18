package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.Corsista;

public class CorsistaDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}
	
	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Connection conn, Corsista corsista) throws DAOException {
		try{
			rowSet.setCommand(SELECT_CORSISTI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateInt(1, corsista.getCodCorsista());
			rowSet.updateString(2, corsista.getNomeCorsista());
			rowSet.updateString(3, corsista.getCognomeCorsista());
			rowSet.updateInt(4, corsista.getPrecForm());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(Connection conn, Corsista corsista) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setInt(1, corsista.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public List<Corsista> getAll(Connection conn) throws DAOException{
		List<Corsista> corsisti = new ArrayList<Corsista>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.beforeFirst();
			while(rs.next()) {
				Corsista corsista = new Corsista();
				corsista.setCodCorsista(rs.getInt(1));
				corsista.setNomeCorsista(rs.getString(2));
				corsista.setCognomeCorsista(rs.getString(3));
				corsista.setPrecForm(rs.getInt(4));
				corsisti.add(corsista);
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
}
