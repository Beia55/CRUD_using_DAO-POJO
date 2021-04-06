package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.pojo.Banca;
import ro.emanuel.helpers.DBHelper;

public class BancaDAO {
	
	public static ArrayList<Banca> getBanca() throws SQLException {
		String select = "SELECT * FROM banca";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Banca> result = new ArrayList<Banca>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");		
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			
			Banca b = new Banca(id, nume, adresa, telefon);
			result.add(b);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Banca getBancaById(int id) throws SQLException {
		String select = "SELECT * FROM banca WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Banca result = null;
		if (rs.next()) {
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			result = new Banca (id, nume, adresa, telefon);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Banca> getBancaByNume(String numeQuery) throws SQLException {
		String select = "SELECT * FROM banca WHERE nume LIKE ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + numeQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Banca> result = new ArrayList<Banca>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			result.add(new Banca (id, nume, adresa, telefon));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createBanca(Banca b) throws SQLException{
		createBanca(b.getNume(), b.getAdresa(), b.getTelefon());
	}
	
	public static void createBanca(String nume, String adresa, String telefon) throws SQLException{
		String insert = "INSERT INTO banca (nume, adresa, telefon)" + "value (?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, nume);
			stmt.setString(2, adresa);
			stmt.setString(3, telefon);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateBanca (Banca b) throws SQLException {
		String update = "UPDATE banca set nume = ?, adresa = ?, telefon= ? WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, b.getNume());
			stmt.setString(2, b.getAdresa());
			stmt.setString(3, b.getTelefon());
			stmt.setInt(4, b.getId());

		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteBanca(Banca b) throws SQLException {
		deleteBanca(b.getId());
	}
	
	public static void deleteBanca(int id) throws SQLException {
		String delete = "DELETE FROM banca WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}
