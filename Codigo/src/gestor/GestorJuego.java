package gestor;

import models.jugador.*;
import models.Nave.*;
import models.planeta.*;
import java.util.ArrayList;
import java.util.List;
import models.equipamiento.*;

public class GestorJuego {
	private List<Planeta> planetas;
	private List<Nave> naves;
	private Jugador jugador;
	private List<Arma> armas;
	private List<Escudo> escudos;

    public GestorJuego() {
        this.planetas = new ArrayList<>(); // Inicializa la lista de todo
        this.naves = new ArrayList<>(); 
        this.armas = new ArrayList<>();
        this.escudos = new ArrayList<>();
    }
    
	public Jugador crearJugador(String id) {
		Jugador jugador = new Jugador(id);
		this.jugador = jugador;
		return(jugador);
	}

	public Planeta generarPlanetaNeutral(String id, int cantCombustible, String idArma, String idEscudo) {
		Escudo escudo = buscarEscudo(idEscudo);
		Arma arma = buscarArma(idArma);
		PlanetaNeutral planeta = new PlanetaNeutral(id, cantCombustible, arma, escudo);
		planetas.add(planeta);
		return(planeta);
	}

	public Planeta generarPlanetaHostil(String id, int cantCombustible) {
		PlanetaHostil planeta = new PlanetaHostil(id, cantCombustible);
		planetas.add(planeta);
		return(planeta);
	}

	public Nave crearNaveAegis(String id, int combustible, int vida, int velocidad) {
		NaveAegis naveAegis = new NaveAegis(id, combustible, vida, velocidad);
		naves.add(naveAegis);
		return(naveAegis);
	}

	public Nave crearNaveSwift(String id, int combustible, int vida, int velocidad) {
		NaveSwift naveSwift = new NaveSwift(id, combustible, vida, velocidad);
		naves.add(naveSwift);
		return(naveSwift);
	}

	public void asignarNaveAJugador(String idNave) {
		Nave nave = buscarNave(idNave);
		jugador.setNave(nave);
	}
	
	private Nave buscarNave(String idNave) {
		for (Nave nave : naves) {
			if(nave.getId()==idNave) {
				return(nave);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idNave);
	}

	public void trasladarAPlaneta(String idPlaneta) {
		Planeta planeta = buscarPlaneta(idPlaneta);
		jugador.visitarPlaneta(planeta);

	}

	public Arma agregarArma(int poder, int precio, String id) {
		Arma arma = new Arma(poder, precio, id);
		armas.add(arma);
		return arma;
	}
	
	public Escudo agregarEscudo(int defensa, int precio, String id) {
		Escudo escudo = new Escudo(defensa, precio, id);
		escudos.add(escudo);	
		return escudo;
	}
	
	public void comprarArma() {
		this.jugador.comprarArma();
	}
	public void comprarEscudo() {
		this.jugador.comprarEscudo();
	}
	public void venderArma(){
		this.jugador.venderArma();
	}
	public void venderEscudo(){
		this.jugador.venderEscudo();
	}
	
	private Arma buscarArma(String idArma) {
		for (Arma arma : armas) {
			if(arma.getId().equals(idArma)) {
				return(arma);
			}
		}
		throw new IllegalArgumentException("No se encontró un arma con el ID especificado: " + idArma);
	}
	
	private Escudo buscarEscudo(String idEscudo) {
		for (Escudo escudo : escudos) {
			if(escudo.getId().equals(idEscudo) ) {
				return(escudo);
			}
		}
		throw new IllegalArgumentException("No se encontró un escudo con el ID especificado: " + idEscudo);
	}

	private Planeta buscarPlaneta(String idPlaneta) {
		for (Planeta planeta : planetas) {
			if(planeta.getIdPlaneta().equals(idPlaneta) ) {
				return(planeta);
			}
		}
		throw new IllegalArgumentException("No se encontró un models.planeta con el ID especificado: " + idPlaneta);
	}
}

