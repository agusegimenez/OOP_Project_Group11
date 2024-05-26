package models.sistemaEstelar;

import models.equipamiento.*;

public class PlanetaNeutral extends Planeta{
	
	private Arma arma;
	private Escudo escudo;

	public PlanetaNeutral(String idPlaneta, Arma arma, Escudo escudo) {
		super(idPlaneta);
		this.arma = arma;
		this.escudo = escudo;
		this.costoDeCombustible = 10;
	}

	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public Escudo getEscudo() {
		return escudo;
	}
	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}
	public boolean soyNeutral() {
		return(true);
	}
	public boolean soyAliado(){
		return (false);
	}
	public boolean soyHostil() {
		return(false);
	}
	public Enemigo getEnemigo() {
		throw new IllegalArgumentException("no es un Planeta Hostil");
	}
	public boolean tieneTesoro() {
		return(false);
	}
	
}
