package models.sistemaEstelar;

import models.equipamiento.Arma;
import models.equipamiento.Escudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaEstelar {
    private List<SistemaEstelar> sistemas;

    public MapaEstelar(int cantidadSistemas) {
        this.sistemas = generarSistemas(cantidadSistemas);
    }

    private List<SistemaEstelar> generarSistemas(int numSistemas){
        List<SistemaEstelar> sistemas = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numSistemas; i++) {
            String nombreSistema = "Sistema " + i;
            List<Planeta> planetas = new ArrayList<>();

            // Generar planetas aleatoriamente
            for (int j = 1; j <= random.nextInt(5) + 1; j++) {
                String nombrePlaneta = nombreSistema + " - Planeta " + j;
                int tipoPlaneta = random.nextInt(3);
                Planeta planeta = null;

                switch (tipoPlaneta) {
                    case 0:
                        planeta = new PlanetaAliado(nombrePlaneta);
                        break;
                    case 1:
                        planeta = new PlanetaHostil(nombrePlaneta);
                        break;
                    case 2:
                        planeta = new PlanetaNeutral(nombrePlaneta, new Arma(50, 30, "Arma Neutral"), new Escudo(40, 20, "Escudo Neutral"));
                        break;
                }

                planetas.add(planeta);
            }

            // Generar cinturones de asteroides aleatoriamente
            List<CinturonAsteroides> cinturones = new ArrayList<>();
            if (random.nextBoolean()) {
                cinturones.add(new CinturonAsteroides());
            }

            sistemas.add(new SistemaEstelar(nombreSistema, planetas, cinturones));
        }
        return sistemas;
    }

    public List<SistemaEstelar> getSistemas(){
        return sistemas;
    }

    public void mostrarSistemas() {
        for (int i = 0; i < sistemas.size(); i++) {
            SistemaEstelar sistema = sistemas.get(i);
            System.out.println(i + ". Sistema Estelar: " + sistema.getNombre());
            for (Planeta planeta : sistema.getPlanetas()) {
                System.out.println("  Planeta: " + planeta.getIdPlaneta());
            }
            if (sistema.tieneCinturones()) {
                System.out.println("  Tiene Cinturones de Asteroides");
            }
        }
    }

    public SistemaEstelar seleccionarSistema(int indice) {
        if (indice >= 0 && indice < sistemas.size()) {
            return sistemas.get(indice);
        } else {
            System.out.println("Número de sistema no válido.");
            return null;
        }
    }
}
