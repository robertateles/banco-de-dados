package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import connection.ConnectionMySQL;
import modelo.Compra;
import modelo.Destino;
import modelo.Veiculo;
import modelo.Viagem;

public class ViagemDAO {

     public void save(Viagem viagem) {
		
		    String sql = "INSERT INTO viagem(preco_viagem, partida_viagem, id_compra, id_destino, id_veiculo) VALUES(?, ?, ?, ?, ?)";

		    Connection conn = null;
		    PreparedStatement pstm = null;
		
		    try {
			    conn = ConnectionMySQL.createConnectionMySQL();
			    pstm = conn.prepareStatement(sql);
			
			    pstm.setDouble(1, viagem.getPreco());
			
			    SimpleDateFormat formatar = new SimpleDateFormat("dd/mm/yyyy");
			    pstm.setDate(2, new Date(formatar.parse(viagem.getPartida()).getTime()));
			    pstm.setInt(3, viagem.getCompra().getId());
			    pstm.setInt(4, viagem.getDestino().getId());
			    pstm.setInt(5, viagem.getVeiculo().getId());
			
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
     
     public List<Viagem> getViagem(){
    	 
    	 String sql = "SELECT * FROM viagem";;
    	 
    	 List<Viagem> viagem = new ArrayList<Viagem>();
    	 
    	 Connection conn = null;
    	 PreparedStatement pstm = null;
    	 ResultSet rset = null;
    	 
    	 try {
    		 conn = ConnectionMySQL.createConnectionMySQL();
    		 pstm = conn.prepareStatement(sql);
    		 
    		 
    		 rset = pstm.executeQuery();
    		 
    		 while(rset.next()) {
    			 Viagem viagem1 = new Viagem();
    			 Compra compra = new Compra();
    			 Destino destino = new Destino();
    			 Veiculo veiculo = new Veiculo();
    			 
    			 viagem1.setPreco(rset.getDouble("preco_viagem"));
    			 viagem1.setPartida(rset.getString("partida_viagem"));
    			 
  				 SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

    			 compra.setId(rset.getInt("id_compra"));
    			 compra.setDatad(dataFormato.format(rset.getDate("data_compra")));
    			 viagem1.setCompra(compra);
    			 
    			 destino.setId(rset.getInt("id_destino"));
    			 destino.setNome_destino(rset.getString("nome_destino"));
    			 viagem1.setDestino(destino);
    			 
    			 veiculo.setId(rset.getInt("id_veiculo"));
    			 veiculo.setPlaca(rset.getString("placa_veiculo"));
    			 viagem1.setVeiculo(veiculo);
    			 
    			 viagem.add(viagem1);
    			 
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
    	 return viagem;
     }
     
     public void update(Viagem viagem) {
    	 
    	 String sql = "UPDATE viagem SET preco_viagem = ?, partida_viagem = ?, id_compra = ?, id_destino = ?, id_veiculo = ?";
    	 
    	 Connection conn = null;
    	 PreparedStatement pstm = null;
    	 
    	 try {
    		 conn = ConnectionMySQL.createConnectionMySQL();
    		 pstm = conn.prepareStatement(sql);
    		 
    		 pstm.setDouble(1, viagem.getPreco());
    		 pstm.setString(2, viagem.getPartida());
    		 pstm.setInt(3, viagem.getCompra().getId());
    		 pstm.setInt(4, viagem.getDestino().getId());
    		 pstm.setInt(4, viagem.getVeiculo().getId());
    		 
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
    	 
    	 String sql = "DELETE FROM viagem WHERE id_viagem = ?";
    	 
    	 Connection conn = null;
    	 PreparedStatement pstm = null;
    	 
    	 try {
    		 conn = ConnectionMySQL.createConnectionMySQL();
    		 pstm = conn.prepareStatement(sql);
    		 
    		 pstm.setInt(1, id);    		 
    		 pstm.execute();
    		 
    		 
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally{
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
}
