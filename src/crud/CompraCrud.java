package crud;

import java.util.Scanner;

import dao.CompraDAO;
import dao.PassageiroDAO;
import modelo.Compra;
import modelo.Passageiro;

public class CompraCrud {

	public static void main(String[] args) {
		CompraDAO compraDAO = new CompraDAO();
		PassageiroDAO passageiroDAO = new PassageiroDAO();
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao = 0;
		int pos = 0;
		
		int id = 0;
		String datad = "";
		double valor = 0;
		int id_passageiro = 0;
		
		do {
			System.out.println("---- COMPRAS ----");
			System.out.println("1 - Cadastrar compra");
			System.out.println("2 - Consultar compra");
			System.out.println("3 - Atualizar compra");
			System.out.println("4 - Deletar compra");
			System.out.println("0 - Sair compra");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			
			case 1:
				System.out.println("---- CADASTRO DE COMPRA ----");
				System.out.println("Digite a data da compra: ");
				entrada.nextLine();
				datad = entrada.nextLine();
				System.out.println("Digite o valor: ");
				valor = entrada.nextDouble();
				System.out.println("Digite o id do passageiro: ");
				id_passageiro = entrada.nextInt();
				
				Passageiro passageiro = passageiroDAO.getPassageiroById(id_passageiro);
				Compra c = new Compra(id, datad, valor, passageiro);
				
				compraDAO.save(c);
				System.out.println("---- COMPRA CADASTRADA ----");
				break;
				
			case 2:
				for(Compra compra : compraDAO.getCompra()) {
					System.out.println("---- CONSULTA DE COMPRA ----");
					System.out.println("Id: " + compra.getId() + "Data: " + compra.getDatad() + "Valor: " + compra.getValor());
				}
				System.out.println("---- CONSULTA REALIZADA ----");
				break;
			case 3:
				System.out.println("---- ATUALIZAÇÃO DE COMPRA ----");
				System.out.println("Digite a nova data da compra: ");
				entrada.nextLine();
				datad = entrada.nextLine();
				System.out.println("Digite o novo valor: ");
				valor = entrada.nextDouble();
				System.out.println("Digite o id do passageiro: ");
				id_passageiro = entrada.nextInt();
				
				Passageiro passageiro1 = passageiroDAO.getPassageiroById(id_passageiro);
				Compra compra2 = new Compra(id,datad,valor,passageiro1);
				compraDAO.update(compra2);
				System.out.println("---- ATUALIZAÇÃO REALIZAÇÃO ----");
				break;
			case 4:
				System.out.println("Digite o id da compra: ");
				pos = entrada.nextInt();
				compraDAO.deleteById(pos);
				System.out.println("COMPRA EXCLUÍDA");
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
