package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Destino;

public class DestinoDAO {
	
	public void save(Destino destino) {
		
		String sql = "INSERT INTO destino(nome_destino) VALUES (?);";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome_destino());
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
	
	public List<Destino> getDestino(){
		
		String sql = "SELECT * FROM destino";
		
		List<Destino> destino = new ArrayList<Destino>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Destino destin = new Destino();
				
				destin.setId(rset.getInt("id_destino"));
				destin.setNome_destino(rset.getString("nome_destino"));
				
				destino.add(destin);
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
		return destino;
	}
	
	public void update(Destino destino) {
		
		String sql = "UPDATE destino SET nome_destino = ? WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
						
			pstm.setString(1, destino.getNome_destino());
			pstm.setInt(2, destino.getId());
			
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
		
		String sql = "DELETE FROM destino WHERE id_destino = ?";
		
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
	
	public Destino getDestinoById(int id) {
		
		String sql = "SELECT * FROM destino WHERE id_destino = ?";
		
		Destino destino = new Destino();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			
			rset.next();
			pstm.setInt(1, id);
			
			destino.setId(rset.getInt("id_destino"));
			destino.setNome_destino(rset.getString("nome_destino"));
			
			
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
		return destino;
	}
}
