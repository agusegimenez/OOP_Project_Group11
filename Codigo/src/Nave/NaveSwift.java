package Nave;
import equipamiento.*;

public class NaveSwift extends Nave {

    public NaveSwift(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo) {
        super(id, combustible, vida, velocidad, arma, escudo);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.setPoderDeAtaque(calcularDañoNave(arma.getPoder(),velocidad,vida,combustible)) ;
    }

    public int calcularDañoNave(int poderArma, int velocidad, int vida, int combustible) {
        return (poderArma * velocidad) + vida + combustible;
    }
}
