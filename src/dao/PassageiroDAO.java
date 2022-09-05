package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Passageiro;

public class PassageiroDAO {

	public void save(Passageiro passageiro) {
		
		String sql = "INSERT INTO passageiro" + "(nome_passageiro, cpf_passageiro,email_passageiro,senha_passageiro, telefone_passageiro)" + "VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, passageiro.getNome());
			pstm.setString(2, passageiro.getCpf());
			pstm.setString(3, passageiro.getEmail());
			pstm.setString(4, passageiro.getSenha());
			pstm.setString(5, passageiro.getTelefone());
			
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Passageiro> getPassageiro(){
		
		String sql = "SELECT * FROM passageiro";
		
		List<Passageiro> passageiro = new ArrayList<Passageiro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Passageiro passageiros = new Passageiro();
				passageiros.setId(rset.getInt("id_passageiro"));
				passageiros.setNome(rset.getString("nome_passageiro"));
				passageiros.setCpf(rset.getString("cpf_passageiro"));
				passageiros.setEmail(rset.getString("email_passageiro"));
				passageiros.setSenha(rset.getString("senha_passageiro"));
				passageiros.setTelefone(rset.getString("telefone_passageiro"));

				
				passageiro.add(passageiros);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return passageiro;
	}
	
	public void update(Passageiro passageiro1) {
		
		String sql = "UPDATE passageiro SET nome_passageiro = ?, cpf_passageiro = ?, email_passageiro = ?, senha_passageiro = ?, telefone_passageiro = ? WHERE id_passageiro = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = 	ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, passageiro1.getNome());
			pstm.setString(2, passageiro1.getCpf());
			pstm.setString(3, passageiro1.getEmail());
			pstm.setString(4, passageiro1.getSenha());
			pstm.setString(5, passageiro1.getTelefone());
			pstm.setInt(6, passageiro1.getId());
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteById(int id) {
		
		String sql = "DELETE FROM passageiro WHERE id_passageiro = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
public Passageiro getPassageiroById(int id) {
		
		String sql = "SELECT * FROM passageiro WHERE id_passageiro = ?";
		
		Passageiro passageiro = new Passageiro();
				
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();

			passageiro.setId(rset.getInt("id_passageiro"));
			passageiro.setNome(rset.getString("nome_passageiro"));
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return passageiro;
	}
}
