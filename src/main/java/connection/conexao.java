package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conexao {
	Connection con;
	private Connection oConn;
	private Statement sStmt;
	
	public conexao() {
	}
	
	public Connection abrirBDConn() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/disciplinas?user=root&password=password&useTimezone=true&serverTimezone=UTC";
			con = DriverManager.getConnection(url);
			
			System.out.println("Conexão efetuada com sucesso!");
			return con;
		}
		
		catch(Exception e) {
			System.out.println("Erro ao abrir a conexão com o banco.");
			e.printStackTrace();
			return null;
		}
	}
	
	public void fecharBDConn() {
		try{
			con.close();
			System.out.println("Conexão finalizada com sucesso!");
		}
		catch(Exception e) {
			System.out.println("Erro ao fechar conexão com o banco" + e.getMessage());
		}
	}
}
