package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String[] args) {
		DestinoDAO destinoDAO = new DestinoDAO();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao = 0;
		int pos = 0;
		
		int id = 0;
		String nome_destino = "";

		do {
			System.out.println("---- DESTINOS ----");
			System.out.println("1 - Cadastrar destino");
			System.out.println("2 - Consultar destino");
			System.out.println("3 - Atualizar destino");
			System.out.println("4 - Deletar destino");
			System.out.println("0 - Sair ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("---- CADASTRO DE DESTINO ----");
				System.out.println("Digite o lugar de destino:");
				entrada.nextLine();
				nome_destino = entrada.nextLine();
				
				Destino destino = new Destino();
				destino.setNome_destino(nome_destino);
				destinoDAO.save(destino);

				System.out.println("---- DESTINO CADASTRADO ----");
				break;
				
			case 2:
				System.out.println("---- CONSULTA DE DESTINO ----");
				for(Destino d : destinoDAO.getDestino()) {
					System.out.println("Id: " + d.getId() + "   |Nome: " + d.getNome_destino());
				}
				System.out.println("---- CONSULTA REALIZADA ----");
				break;
			
			case 3:
				System.out.println("---- ATUALIZAÇÃO DE DESTINO ----");
				System.out.println("Digite o id: ");
				id = entrada.nextInt();
				System.out.println("Digite o novo destino");
				entrada.nextLine();
				nome_destino = entrada.nextLine();
				
				
				Destino destino1 = new Destino(id,nome_destino);
				destinoDAO.update(destino1);
				System.out.println("---- ATUALIZAÇÃO REALIZADA ----");
				break;
				
			case 4:
				System.out.println("---- EXCLUSÃO DE DESTINO ----");
				System.out.println("Digite o id: ");
				pos = entrada.nextInt();
				
				destinoDAO.deleteById(pos);
				
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
