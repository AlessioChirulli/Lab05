package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.DAO.ConnectDB;
import it.polito.tdp.anagrammi.model.Model;

public class AnagrammaDAO {

	public boolean rootIsCorrect(String nuovaParziale) {
		// TODO Auto-generated method stub
		final String sql=" SELECT * FROM parola"
				+ " where nome LIKE ? ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nuovaParziale+"%");

			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}else {
				rs.close();
				st.close();
				conn.close();
				return false;
			}
		
	}catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
}

	public boolean IsCorrect(String parziale) {
		final String sql=" SELECT * FROM parola"
				+ " where nome = ? ";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parziale);

			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}else {
				rs.close();
				st.close();
				conn.close();
				return false;
			}
		
	}catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
	}
}
