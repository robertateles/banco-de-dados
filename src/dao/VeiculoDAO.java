package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Veiculo;

public class VeiculoDAO {
	
	public void save(Veiculo veiculo) {
		
		String sql = "INSERT INTO veiculo(qtdLugar_veiculo, placa_veiculo) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, veiculo.getQtdLugar());
			pstm.setString(2, veiculo.getPlaca());
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
	
	public List<Veiculo> getVeiculo(){
		
		String sql = "SELECT * FROM Veiculo";
		
		List<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Veiculo veicul = new Veiculo();
				
				veicul.setId(rset.getInt("id_veiculo"));
				veicul.setQtdLugar(rset.getString("qtdLugar_veiculo"));
				veicul.setPlaca(rset.getString("placa_veiculo"));
				
				veiculo.add(veicul);
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
		return veiculo;
		
	}
	
	public void update(Veiculo veiculo) {
		String sql = "UPDATE Veiculo SET qtdLugar_veiculo = ?, placa_veiculo = ? WHERE id_veiculo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, veiculo.getQtdLugar());
			pstm.setString(2, veiculo.getPlaca());
			pstm.setInt(3, veiculo.getId());
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
		
        String sql = "DELETE FROM Veiculo WHERE id_veiculo = ?";
		
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
	
public Veiculo getVeiculoyId(int id) {
		
		String sql = "SELECT * FROM veiculo WHERE id_veiculo = ?";
		
		Veiculo veiculo = new Veiculo();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			
		    veiculo.setId(rset.getInt("id_veiculo"));
			veiculo.setPlaca(rset.getString("placa_veiculo"));
			
			
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
		return veiculo;
	}
}
