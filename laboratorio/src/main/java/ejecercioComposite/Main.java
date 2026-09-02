/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecercioComposite;

/**
 *
 * @author Randal
 */
public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Tech Solutions");

        Departamento ventas = new Departamento("Ventas");
        Departamento recursos= new Departamento("Recursos Humanos");
        Departamento sistemas = new Departamento("Sistemas");

        
         recursos.agregar(new Empleado("Agustina", 300000));
         recursos.agregar(new Empleado("Jorge", 300000));
       
         ventas.agregar(new Empleado("Randal", 500000));
       
         ventas.agregar(new Empleado("Pedro", 600000));

        sistemas.agregar(new Empleado("Gaston", 800000));
        sistemas.agregar(new Empleado("Martin", 900000));

        empresa.agregar(ventas);
        empresa.agregar(sistemas);
        empresa.agregar(recursos);
        empresa.mostrar();

        System.out.println();
        System.out.println("Sueldo total rrhh: $ " + recursos.calcularSueldo());
        System.out.println("Sueldo total Ventas: $ " + ventas.calcularSueldo());
        System.out.println("Sueldo total Sistemas: $ " + sistemas.calcularSueldo());
        System.out.println("Sueldo total Empresa: $ " + empresa.calcularSueldo());
    }
}