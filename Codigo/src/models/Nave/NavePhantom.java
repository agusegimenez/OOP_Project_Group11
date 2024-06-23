package models.Nave;

import models.jugador.Jugador;
import models.sistemaEstelar.SistemaEstelar;

public class NavePhantom extends Nave{
    public NavePhantom(int combustible, int vida, int velocidad) {
        super( combustible, vida, velocidad);
        int totalPoderArmas = 0;
        setNombreNave("Nave-Phantom-"+getId().toString());
        for (int x = 0; x < armas.size(); x++) {
            totalPoderArmas += armas.get(x).getPoder();
        }

        // Calcular el poder de ataque basado en el total de poder de las armas
        int dañoCalculado = calcularDañoNave(totalPoderArmas);
        this.poderDeAtaque = dañoCalculado;
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (velocidad * poderDeArma);
    }

    @Override
    public boolean esPhantom() {
        return true;
    }

    @Override
    public boolean esTitan() {
        return false;
    }

    @Override
    public boolean esSwift() {
        return false;
    }

    @Override
    public boolean esAegis() {
        return false;
    }

    @Override
    public void atravesarCinturon() {
        Jugador jugador = this.getJugador();
        int vida = this.getVida();
        SistemaEstelar sistemaActual = jugador.getSistemaActual();
        jugador.sumarUadeCoins(sistemaActual.getCinturonAsteroides().getPoderDelCinturon(), 0);
    }
}
