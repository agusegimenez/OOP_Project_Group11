package Nave;

public class Nave {
    private String id;
    private int combustible;
    private int vida;
    private int velocidad;
    private Arma arma;
    private Escudo escudo;
    private int poderDeAtaque;

    public Nave(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo, int poderDeAtaque) {
        this.id = id;
        this.combustible = combustible;
        this.vida = vida;
        this.velocidad = velocidad;
        this.arma = arma;
        this.escudo = escudo;
        this.poderDeAtaque = poderDeAtaque;
    }


    public void equiparArma(Arma arma){
        this.arma = setArma(Arma arma);
        setPoderDeAtaque(arma.getPoder());
    }
    public void equiparEscudo(Escudo escudo){
        this.escudo = setEscudo(Escudo escudo);
    }
    public void recibirDaño(int daño){
        int dañoFinal = daño - (escudo.getProteccion());  //Compruebo el dañoFinal recibido en base a la proteccion
        if (dañoFinal <= 0) //Si dañoFinal es un numero negativo significa que tengo mas escudo que el daño total
            dañoFinal *= -1; //Como dañoFinal es un numero negativo debido a que tengo mas escudo le cambio el signo y le reasingo la proteccion de la nave  restandole el  daño recibido
            this.escudo.setProteccion(dañoFinal);
        else //Si dañoFinal es un numero positivo significa que no tengo mas escudo que el daño total por lo que resto vida de la nave.
            this.vida -= dañoFinal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
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

    public void setArma(Arma arma) {
        this.arma = arma;
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
}
