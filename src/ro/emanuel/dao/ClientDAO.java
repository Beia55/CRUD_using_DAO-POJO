package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.pojo.Client;
import ro.emanuel.helpers.DBHelper;

public class ClientDAO {
	
	public static ArrayList<Client> getClienti() throws SQLException {
		String select = "SELECT * FROM client";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Client> result = new ArrayList<Client>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");		
			String nume = rs.getNString("nume");
			String prenume = rs.getNString("prenume");
			int varsta = rs.getInt("varsta");
			String cont = rs.getNString("cont");
			double sold = rs.getDouble("sold");
			
			Client c = new Client(id, nume, prenume, varsta, cont, sold);
			result.add(c);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Client getClientiById(int id) throws SQLException {
		String select = "SELECT * FROM client WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Client result = null;
		
		if(rs.next()) {
			String nume = rs.getNString("nume");
			String prenume = rs.getNString("prenume");
			int varsta = rs.getInt("varsta");
			String cont = rs.getNString("cont");
			double sold = rs.getDouble("sold");
			result = new Client(id, nume, prenume, varsta, cont, sold);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Client> getClientiByNume(String numeQuery) throws SQLException {
		String select = "SELECT * FROM client where nume LIKE ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + numeQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Client> result = new ArrayList<Client>();
		while(rs.next()) {
			int id = rs.getInt("id");		
			String nume = rs.getNString("nume");
			String prenume = rs.getNString("prenume");
			int varsta = rs.getInt("varsta");
			String cont = rs.getNString("cont");
			double sold = rs.getDouble("sold");
			result.add(new Client (id, nume, prenume, varsta, cont, sold));
		}
		DBHelper.closeConnection();
		return result;	}
	
	public static void createClient(Client c) throws SQLException{
		createClient(c.getNume(), c.getPrenume(), c.getVarsta(), c.getCont(), c.getSold());
	}
	
	public static void createClient(String nume, String prenume, int varsta, String cont, double sold) throws SQLException{
		String insert = "INSERT INTO client (nume, prenume, varsta, cont, sold)" + "value (?,?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, nume);
			stmt.setString(2, prenume);
			stmt.setInt(3, varsta);
			stmt.setString(4,cont);
			stmt.setDouble(5, sold);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateClient (Client c) throws SQLException {
		String update = "UPDATE client set nume = ?, prenume = ?, varsta = ?, cont = ?, sold = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, c.getNume());
			stmt.setString(2, c.getPrenume());
			stmt.setInt(3, c.getVarsta());
			stmt.setString(4,c.getCont());
			stmt.setDouble(5, c.getSold());
			stmt.setInt(6, c.getId());

		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteClient(Client c) throws SQLException {
		deleteClient(c.getId());
	}

	public static void deleteClient(int id) throws SQLException {
		String delete = "DELETE FROM client WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}
