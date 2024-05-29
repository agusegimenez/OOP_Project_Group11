package models.Nave;

public class NaveAegis extends Nave {


    public NaveAegis(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        int dañoCalculado = calcularDañoNave(arma1.getPoder());
        this.poderDeAtaque = dañoCalculado;
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (poderDeArma * vidaMaxima) / velocidad;
    }

    @Override
    public boolean esPhantom() {
        return false;
    }

    @Override
    public boolean esTitan() {
        return false;
    }


}
