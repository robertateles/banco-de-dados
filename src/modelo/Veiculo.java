package modelo;

public class Veiculo {
	private int id;
	private String qtdLugar;
	private String placa;
	
	public Veiculo() {
		
	}

	public Veiculo(int id, String qtdLugar, String placa) {
		super();
		this.id = id;
		this.qtdLugar = qtdLugar;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQtdLugar() {
		return qtdLugar;
	}

	public void setQtdLugar(String qtdLugar) {
		this.qtdLugar = qtdLugar;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
