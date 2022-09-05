package crud;


import java.util.Scanner;

import dao.PassageiroDAO;
import modelo.Passageiro;

public class PassageiroCrud {

	public static void main(String[] args) {
		
		PassageiroDAO passageiroDAO = new PassageiroDAO();
		
		Scanner entrada = new Scanner(System.in); 
		
		int opcao = 0;
		int pos = 0;
		
		int id = 0;
		String nome = "";
		String cpf = "";
		String email = "";
		String senha = "";
		String telefone = "";
		
		
		do {
			System.out.println("---- PASSAGEIROS ----");
			System.out.println("1 - Cadastrar passageiro");
			System.out.println("2 - Consultar passageiro");
			System.out.println("3 - Atualizar passageiro");
			System.out.println("4 - Deletar passageiro");
			System.out.println("0 - Sair ");
			opcao = entrada.nextInt();
			
			switch(opcao) {
			
			case 1:
				System.out.println("---- CADASTRO DE PASSAGEIRO ----");
				System.out.println("Digite o nome do passageiro: ");
				entrada.nextLine();
				nome = entrada.nextLine();
				System.out.println("Digite o cpf do passageiro: ");
				cpf = entrada.nextLine();
				System.out.println("Digite o email do passageiro: ");
				email = entrada.nextLine();
				System.out.println("Digite a senha do passageiro: ");
				senha = entrada.nextLine();
				System.out.println("Digite o telefone do passageiro: ");
				telefone = entrada.nextLine();
				
				Passageiro passageiro1 = new Passageiro(id, nome, cpf, email, senha, telefone);
				passageiroDAO.save(passageiro1);
				
				System.out.println("---- PASSAGEIRO CADASTRADO ----");
				break;
			
				
			case 2:
				System.out.println("---- CONSULTA DE PASSAGEIRO ----");
				for(Passageiro p : passageiroDAO.getPassageiro()) {
					System.out.println("Id: " + p.getId() + "   |Nome: " + p.getNome() + "   |Cpf: " + p.getCpf()
					       +"   |Email: " + p.getEmail() + "   |Telefone: " + p.getTelefone());
				}
				break;
				
			case 3:
				System.out.println("---- ATUALIZAÇÃO DE PASSAGEIRO ----");
				System.out.println("Digite o id: ");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite o atual nome do passageiro: ");
				nome = entrada.nextLine();
				System.out.println("Digite o atual cpf do passageiro: ");
				cpf = entrada.nextLine();
				System.out.println("Digite o atual email do passageiro: ");
				email = entrada.nextLine();
				System.out.println("Digite a atual senha do passageiro: ");
				senha = entrada.nextLine();
				System.out.println("Digite o atual telefone do passageiro: ");
				telefone = entrada.nextLine();
				
				Passageiro passageiros = new Passageiro(id,nome,cpf,email,senha,telefone);
				passageiroDAO.update(passageiros);
				
				System.out.println("---- ATUALIZAÇÃO REALIZADA ----");
				break;
				
				
			case 4:
				System.out.println("---- EXCLUSÃO DE PASSAGEIRO ----");
				System.out.println("Digite o id: ");
				pos = entrada.nextInt();
				
				passageiroDAO.deleteById(pos);
				System.out.println("---- EXCLUSÃO REALIZADA ----");
				break;
				
			default:
				System.out.println(opcao !=0 ? "Opção inválida, tente novamente." : "");
				break;

			}
			
		}while(opcao != 0);
		System.out.println("---- CONEXÃO FINALIZADA ----");
		entrada.close();
	}

}
