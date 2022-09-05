package modelo;

public class Destino {
	private int id;
	private String nome_destino;
	
	public Destino() {
		
	}

	public Destino(int id, String nome_destino) {
		super();
		this.id = id;
		this.nome_destino = nome_destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_destino() {
		return nome_destino;
	}

	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}
	
	
}
