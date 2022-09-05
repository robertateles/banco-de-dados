package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Viagem {
	private int id;
	private double preco;
	private LocalDate partida;
	private Compra compra;
	private Destino destino;
	private Veiculo veiculo;
	
	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Viagem() {
		
	}

	public Viagem(int id, double preco, String partida, Compra compra, Destino destino, Veiculo veiculo) {
		super();
		this.id = id;
		this.preco = preco;
		this.partida = LocalDate.parse(partida,formatar);
		this.compra = compra;
		this.destino = destino;
		this.veiculo = veiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getPartida() {
		return formatar.format(partida);
	}

	public void setPartida(String partida) {
		this.partida = LocalDate.parse(partida);
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
}
