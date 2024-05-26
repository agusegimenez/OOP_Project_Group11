package models.Nave;
import models.equipamiento.*;

public abstract class Nave {
	protected String id;
    protected int combustible;
    protected int vida;
    protected int velocidad;
    protected Arma arma;
    protected Escudo escudo;
    protected int poderDeAtaque;
    protected final int vidaMaxima;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCombustible() {
        return combustible;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Arma getArma() {
        return arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    protected void setPoderDeAtaque(int poderDeAtaque) {
        this.poderDeAtaque = poderDeAtaque;
    }
    public void setArma(Arma arma){
        this.arma = arma;
        setPoderDeAtaque(calcularDañoNave(arma.getPoder(), vida,velocidad,combustible));
    }

    public Nave(String id, int combustible, int vida, int velocidad) {
        this.id = id;
        this.combustible = combustible;
        this.vidaMaxima = vida;
        this.vida = vidaMaxima;
        this.velocidad = velocidad; 
        // Le instaciamos a la models.Nave un arma y escudo basico
        this.arma = new Arma(10, 0, "Arma Basica");
        this.escudo = new Escudo(20, 0, "Escudo Basico");
    }
    
    public void recibirDaño(int daño){
        int dañoFinal = daño - (escudo.getProteccion());  //Compruebo el dañoFinal recibido en base a la proteccion
        if (dañoFinal <= 0) { //Si dañoFinal es un numero negativo significa que tengo mas escudo que el daño total
            dañoFinal *= -1; //Como dañoFinal es un numero negativo debido a que tengo mas escudo le cambio el signo y le reasingo la proteccion de la nave  restandole el  daño recibido
            this.escudo.setProteccion(dañoFinal);
        }else { //Si dañoFinal es un numero positivo significa que no tengo mas escudo que el daño total por lo que resto vida de la nave.
            this.vida -= dañoFinal;
            escudo.setProteccion(0);
        }
    }

    public void recibirDañoCinturon(int daño){
        this.vida -= daño;
    }

    public void cargarCombustible(int combustible) {
        this.combustible = this.combustible + combustible;
    }
    
    public void consumirCombustible(int combustible) {
    	this.combustible -= combustible;
    }

    public abstract int calcularDañoNave(int poderDeArma, int vida, int velocidad, int combustible);

    public abstract boolean esPhantom();

    public abstract boolean esTitan();

    public void reparar(){
        this.vida = this.vidaMaxima;
        this.escudo.reparar();
    }

}
