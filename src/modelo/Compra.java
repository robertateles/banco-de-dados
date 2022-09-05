package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {
	private int id;
	private LocalDate datad;
	private double valor;
	private Passageiro passageiro;
	
	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Compra() {
		
	}
	
	public Compra(int id, String datad, double valor, Passageiro passageiro) {
		super();
		this.id = id;
		this.datad = LocalDate.parse(datad,formatar);
		this.valor = valor;
		this.passageiro = passageiro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatad() {
		return formatar.format(datad);
	}

	public void setDatad(String datad) {
		this.datad = LocalDate.parse(datad, formatar);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	

	
	
}
