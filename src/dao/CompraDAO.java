package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Compra;
import modelo.Passageiro;

public class CompraDAO {
	
	public void save(Compra compra) {
		
		String sql = "INSERT INTO Compra(data_compra, valor_compra, id_passageiro"
				+ ") VALUES (?, ?, ?)"; 
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			SimpleDateFormat formatar = new SimpleDateFormat("dd/mm/yyyy");
			pstm.setDate(1, new Date(formatar.parse(compra.getDatad()).getTime()));
			
			pstm.setDouble(2, compra.getValor());
			pstm.setInt(3, compra.getPassageiro().getId());
			
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
	
	public List<Compra> getCompra(){
		
		String sql = "SELECT * FROM compra;";
		
		List<Compra> compras = new ArrayList<Compra>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Compra compra = new Compra();
				Passageiro passageiro = new Passageiro();
				
				compra.setId(rset.getInt("id_compra"));
				
				SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
				compra.setDatad(dataFormato.format(rset.getDate("data_compra")));
				compra.setValor(rset.getDouble("valor_compra"));
				
				passageiro.setId(rset.getInt("id_passageiro"));
				passageiro.setNome(rset.getString("nome_passageiro"));
				compra.setPassageiro(passageiro);	
				
				compras.add(compra);
				
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
		return compras;
	}

	
	public void update(Compra compra) {
		
		String sql = "UPDATE compra SET data_compra = ?, valor_compra = ? id_passageiro = ? WHERE id_compra = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = 	ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, compra.getDatad());
			pstm.setDouble(2, compra.getValor());
			pstm.setInt(3, compra.getPassageiro().getId());
			
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
		
		String sql = "DELETE FROM compra WHERE id_compra = ?";
		
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
	
public Compra getCompraById(int id) {
		
		String sql = "SELECT * FROM compra WHERE id_compra = ?";
		
		Compra compra = new Compra();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			
			compra.setId(rset.getInt("id_compra"));
			
			compra.setDatad(rset.getString("data_compra"));
			
			
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
		return compra;
	}
}
