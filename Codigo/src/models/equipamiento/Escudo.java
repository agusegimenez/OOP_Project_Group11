package models.equipamiento;

import view.EscudoView;

public class Escudo {
	private int proteccion;
	private int uadeCoin;
	private String id;
	private final int proteccionMaxima;
	
	public Escudo(int proteccion, int precio, String id) {
		this.proteccionMaxima = proteccion;
		this.proteccion = proteccion;
		this.uadeCoin = precio;
		this.id = id;
	}
	
	public void setProteccion(int x) {
		this.proteccion = x;
	}
	
	public int getProteccion() {
		return(this.proteccion);
	}
	
	public int getPrecio() {
		return(this.uadeCoin);
	}
	
	public String getId() {
		return(this.id);
	}

	public void reparar(){
		this.proteccion = proteccionMaxima;
	}
	public EscudoView toView(){
		return new EscudoView(uadeCoin, proteccionMaxima, id);
	}
}
