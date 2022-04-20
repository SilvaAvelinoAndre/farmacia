package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/farmacia?useSSL=False";
	
	
	public static Connection conectar() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
	return conexao;	
	 
	 }
	
	public static void main(String[] args)     {
		try {
		Connection conexao = ConexaoFactory.conectar();
		System.out.println("Conexao bem sucedida!!!");
		 
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Falha na conexão!!!");
		}
	}
	

}
