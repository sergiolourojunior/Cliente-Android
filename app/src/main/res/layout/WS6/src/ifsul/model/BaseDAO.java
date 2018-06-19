package ifsul.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	public BaseDAO()
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/projeto_donate";
		return DriverManager.getConnection(url,"postgres","postgres");
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(new BaseDAO().getConnection());
	}

}
