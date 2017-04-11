package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecao{

	private Connection conecta;
	
	public void conectar(){
		String url = "jdbc:mysql://localhost:3306/Loteria";
		String user = "root";
		String pass = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro ao capturar driver\n");;
		}
		
		try {
			conecta = DriverManager.getConnection(url,user,pass);
			System.out.println("conectado");
		} catch (SQLException e) {
			System.out.println("Erro no metodo conectar();\n");;
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Fexando aplicação!!!");
				desconectar();
			}
		}));
	}
	
	private void desconectar(){
		if (conecta != null) {
			try {
				conecta.close();
			} catch (SQLException e) {
				System.out.println("Erro no metodo desconectar();\n");;
			}
		}
	}
}
