package ejecercioComposite;


import ejecercioComposite.ComponenteEmpresa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Randal
 */
public class Empleado implements ComponenteEmpresa {

    private String nombre;
     private double sueldo;
     
     
     public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    
    public void mostrar() {
         System.out.println("Empleado: " + nombre + " - $" + sueldo);
    }
    
    
      public double calcularSueldo() {
        return sueldo;
    }
}
