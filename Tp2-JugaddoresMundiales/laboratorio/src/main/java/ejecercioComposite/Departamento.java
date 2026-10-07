package ejecercioComposite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Randal
 */

    
import java.util.ArrayList;
import java.util.List;

public class Departamento implements ComponenteEmpresa {

    private String nombre;
    private List<ComponenteEmpresa> componentes;

    public Departamento(String nombre) {
        this.nombre = nombre;
        componentes = new ArrayList<>();
    }

    public void agregar(ComponenteEmpresa componente) {
        componentes.add(componente);
    }

    @Override
    public void mostrar() {
        System.out.println("Departamento: " + nombre);

        for (ComponenteEmpresa componente : componentes) {
            componente.mostrar();
        }
    }

    @Override
    public double calcularSueldo() {
        double total = 0;

        for (ComponenteEmpresa componente : componentes) {
            total += componente.calcularSueldo();
        }

        return total;
    }
}
