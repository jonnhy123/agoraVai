package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecao{

	private static Conecao self;
	private Connection conecta;
	
	private final static String url = "jdbc:postgresql://localhost:5432/Loteria";
	private final static String Nomebanco = "postgres";
	private final static String senhaBanco = "univel";
	private final static String driver = "org.postgresql.Driver";
	
	public void conectar(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro ao capturar driver\n");;
		}
		
		try {
			conecta = DriverManager.getConnection(url,Nomebanco,senhaBanco);
			System.out.println("conectado");
		} catch (SQLException e) {
			System.out.println("Erro no metodo conectar();\n");;
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Conecao.this.conecta.close();
				} catch (SQLException e) {
					System.out.println("Erro no método fechar conexão"+e);
				}
				System.out.println("Fexando aplicação!!!");
			}
		}));
	}
	
	public final static synchronized Conecao newInstance(){
		if (self == null) {
			self = new Conecao();
		}	
		return self;
	}
	
	public Connection getConection(){
		return conecta;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("Só pode haver uma.\n");
		return super.clone();
	}
}
