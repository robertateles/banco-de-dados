package crud;

import java.util.Scanner;

import dao.CompraDAO;
import dao.DestinoDAO;
import dao.VeiculoDAO;
import dao.ViagemDAO;
import modelo.Compra;
import modelo.Destino;
import modelo.Passageiro;
import modelo.Veiculo;
import modelo.Viagem;

public class ViagemCrud {

	public static void main(String[] args) {
		ViagemDAO viagemDAO = new ViagemDAO();
		CompraDAO compraDAO = new CompraDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao = 0;
		int pos = 0;
		
		int id = 0;
		double preco = 0;
		String partida = "";
		int id_compra = 0;
		int id_destino = 0;
		int id_veiculo = 0;
		
		do {
			System.out.println("---- VIAGEM ----");
			System.out.println("1 - Cadastrar viagem");
			System.out.println("2 - Consultar viagem");
			System.out.println("3 - Atualizar viagem");
			System.out.println("4 - Deletar viagem");
			System.out.println("0 - Sair ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("---- CADASTRO DE VIAGEM ----");
				System.out.println("Digite o preço da passagem: ");
				preco = entrada.nextDouble();
				entrada.nextLine();
				System.out.println("Digite a data da partida: ");
				partida = entrada.nextLine();
				System.out.println("Digite o id da compra: ");
				id_compra = entrada.nextInt();
				System.out.println("Digite o id do destino: ");
				id_destino = entrada.nextInt();
				System.out.println("Digite o id do veiculo: ");
				id_veiculo = entrada.nextInt();
				
				
				Compra compra = compraDAO.getCompraById(id_compra);
				Destino destino = destinoDAO.getDestinoById(id_destino);
				Veiculo veiculo = veiculoDAO.getVeiculoyId(id_veiculo);
				Viagem v = new Viagem(id, preco, partida, compra, destino, veiculo);
				
				//Passageiro passageiro = passageiroDAO.getPassageiroById(id_passageiro);
				//Compra c = new Compra(id, datad, valor, passageiro);
				
				
				viagemDAO.save(v);
		
				System.out.println("---- VIAGEM CADASTRADA ----");
				break;
				
			case 2:
				System.out.println("---- CONSULTA DE VIAGEM ----");
				for(Viagem v2 : viagemDAO.getViagem()) {
					System.out.println("Id: " + v2.getId() + "Destino: " + v2.getDestino().getNome_destino() + "Partida: " + v2.getPartida() + "Veiculo: " + v2.getVeiculo().getPlaca());
				}
				System.out.println("---- CONSULTADA REALIZADA ----");
				break;
			}
			
		}while(opcao != 0);
		entrada.close();
	}

}
