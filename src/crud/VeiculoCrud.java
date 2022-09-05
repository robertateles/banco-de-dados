package crud;

import java.util.Scanner;

import dao.VeiculoDAO;
import modelo.Veiculo;

public class VeiculoCrud {

	public static void main(String[] args) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao = 0;
		int pos = 0;
		
		int id = 0;
		String qtdlugar = "";
		String placa = "";
		
		do {
			System.out.println("---- VEICULOS ----");
			System.out.println("1 - Cadastrar veiculo");
			System.out.println("2 - Consultar veiculo");
			System.out.println("3 - Atualizar veiculo");
			System.out.println("4 - Deletar veiculo");
			System.out.println("0 - Sair ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			
			case 1:
				System.out.println("---- CADASTRO DE VEICULO ----");
				System.out.println("Digite a quantidade de acento que existe no ônibus: ");
				entrada.nextLine();
				qtdlugar = entrada.nextLine();
				System.out.println("Digite a placa: ");
				placa = entrada.nextLine();
				
				Veiculo veiculo = new Veiculo();
				veiculo.setQtdLugar(qtdlugar);
				veiculo.setPlaca(placa);

				veiculoDAO.save(veiculo);
				System.out.println("---- CADASTRO REALIZADO ----");
				break;
				
			case 2:
				System.out.println("---- CONSULTA DE VEICULO ----");
				for(Veiculo v : veiculoDAO.getVeiculo()) {
					System.out.println("Id: " + v.getId() + "   |Quantidade de acento: " + v.getQtdLugar() + "   |Placa: " + v.getPlaca());
				}
				System.out.println("---- CONSULTA REALIZADA ----");
				break;
				
				
			case 3:
				System.out.println("---- ATUALIZAÇÃO DE VEICULO ----");
				System.out.println("Digite o id: ");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite a nova quantidade de acento que existe no ônibus: ");
				qtdlugar = entrada.nextLine();
				System.out.println("Digite a atual placa: ");
				placa = entrada.nextLine();
				
				
				Veiculo veicul = new Veiculo(id,qtdlugar,placa);
				veiculoDAO.update(veicul);
				
				System.out.println("---- ATUALIZAÇÃO REALIZADA ----");
				break;
				
			case 4:
				System.out.println("---- Exclusão DE VEICULO ----");
				System.out.println("Digite o id: ");
				pos = entrada.nextInt();
				veiculoDAO.deleteById(pos);
				System.out.println("---- EXCLUSÃO REALIZADA ----");
				break;
				
			default:
				System.out.println(opcao !=0 ? "Opção inválida, tente novamente." : "");
				break;
				
			}
			
			
		}while(opcao != 0);
		System.out.println("CONEXÃO FINALIZADA");
		entrada.close();
	}

}
