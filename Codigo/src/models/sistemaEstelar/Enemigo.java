package models.sistemaEstelar;

import models.Nave.*;

public class  Enemigo {
	private int poderDeAtaque;
	private int uadeCoin;
	private int vida = 100;

	public int getPoderAtaque() {
		return(this.poderDeAtaque);
	}

	public int getVida() {
		return(this.vida);
	}

	public int getUadeCoins() {
		return(this.uadeCoin);
	}


	public Enemigo(int poderAtaque) {
		this.poderDeAtaque = poderAtaque;
		this.uadeCoin = calcularCantidadDeUadeCoins();
	}

	public void atacar(Nave nave) {
		int ataqueEnemigo = getPoderAtaque();
		nave.recibirDaño(ataqueEnemigo);
		System.out.println("Se le infringió al models.jugador"+ataqueEnemigo+"puntos de daño");
	}	
	
	public void recibirDaño(int daño) {
		this.vida = this.vida - daño;
	}
	
	private int calcularCantidadDeUadeCoins() {
		return(this.poderDeAtaque*2);
	}
	
	public void imprimirEstadoEnemigo() {
		System.out.println("Vida actual enemigo "+this.vida);
	}
	
}
