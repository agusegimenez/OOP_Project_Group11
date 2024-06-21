package models.sistemaEstelar;
import models.equipamiento.*;
import view.SistemaEstelarView;

import java.util.List;
import java.util.Random;


public class SistemaEstelar {
    private String nombre;
    private List<Planeta> planetas;
    private boolean tieneCinturon;
    private CinturonAsteroides cinturonAsteroides;
    private Random random = new Random();

    public SistemaEstelar(String nombre, List<Planeta> planetas, boolean tieneCinturon) {
        this.nombre = nombre;
        this.planetas = planetas;
        this.tieneCinturon = tieneCinturon;
        if(tieneCinturon){
            CinturonAsteroides cinturonAsteroides = new CinturonAsteroides();
            this.cinturonAsteroides = cinturonAsteroides;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public boolean tieneCinturon() {
        return tieneCinturon;
    }

    public Planeta buscarPlaneta(String idPlaneta) {
        for (Planeta planeta : planetas) {
            if(planeta.getIdPlaneta().equals(idPlaneta) ) {
                return(planeta);
            }
        }
        return null;
    }

    public CinturonAsteroides getCinturonAsteroides(){
        return this.cinturonAsteroides;
    }


    public Planeta buscarPlanetaConTesoro(){
        for (Planeta planeta : planetas){
            if(planeta.tieneTesoro()){
                return planeta;
            }
        }
        return null;
    }

    public SistemaEstelarView toView(){
       return(new SistemaEstelarView(nombre, planetas, cinturonAsteroides));
    }
}
