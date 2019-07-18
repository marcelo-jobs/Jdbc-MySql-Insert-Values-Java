package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import database.DB;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DB.getConnection();
			ps = con.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			ps.setString(1, "Maria Souza");
			ps.setString(2, "mariasouza@hotmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("10/10/1989").getTime()));
			ps.setDouble(4, 2000.0);
			ps.setInt(5, 4);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
	}

}