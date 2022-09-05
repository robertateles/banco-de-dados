package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	public static Connection createConnectionMySQL() throws Exception{
		
		//Carregar a classe pelo JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Criar a conexão com o banco 
		Connection connection = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/travelairlines?user=roberta&password=34672052Ro!");
		
		return connection;
	}
	
	public static void main(String [] args) throws Exception{
		
		//Recuperar a conexão com o banco
		Connection con = createConnectionMySQL();
		
		//Teste de conexão
		if(con != null) {
			System.out.println(con + "\n****Conexão bem sucedida****");
			con.close();
		}
	}

}

