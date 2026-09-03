package ejercicioRecursiveTask;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 

        //  productos
        String[] productos = {"leche", "harina", "huevos", "yerba", "dulce de leche", "cerveza", "gaseosa", "pan", "crema", "fideos"};
        List<String> lista_productos = Arrays.asList(productos);


        Local.setProductos(productos);
        Local[] locales_neuquen = {new Local("Topsy"), new Local("La Anonima"), new Local("Coto")};
        Local[] locales_cipolletti = {new Local("Vea"), new Local("La Anonima"), new Local("ChangoMas")};
        Local[] locales_plottier = {new Local("Cooperativa Obrera"), new Local("La Anonima")};
        Local[] locales_cinco_saltos = {new Local("Mana"), new Local("La Anonima")};
        Local[] locales_fernandez_oro = {new Local("Eco"), new Local("La Anonima")};
        Local[] locales_allen = {new Local("Sabrusan"), new Local("La Anonima")};
        Local[] locales_roca= {new Local("El Rincon del Fiambre"), new Local("La Anonima")};
        Local[] locales_centenario = {new Local("Super Doraemon"), new Local("La Anonima")};
        Local[] locales_barda_del_medio = {new Local("Stop & Go")};
        
        // Genera el arbol a recorrer, la estructura es fija, los precios son aleatorios
        Node raiz = new Node("Neuquen", locales_neuquen, new Node("Plottier", locales_plottier, null, new Node("Centenario", locales_centenario, new Node("Barda del Medio", locales_barda_del_medio, null, 
        null), new Node("Cipolletti", locales_cipolletti, new Node("Cinco Saltos", locales_cinco_saltos, null, new Node("Gral. Fernandez Oro", locales_fernandez_oro, new Node("Allen", 
        locales_allen, null, new Node("Gral. Roca", locales_roca, null, null)), null)), null) )), null);

        ForkJoinPool fjp = new ForkJoinPool();

        System.out.println("Seleccione un producto para consultar su valor. O escriba \"q\" para salir.");
        System.out.println("Lista de productos: " + lista_productos.toString());
        String lectura = scanner.nextLine();
        while(!lectura.equals("q"))
        {
            if(lista_productos.contains(lectura))
            {
                Tarea task = new Tarea(raiz, lectura);
                Respuesta resultado = fjp.invoke(task);
                System.out.println("El precio mas barato de " + lectura + " es en " + resultado.precio + ", en el local " + resultado.local + " de " + resultado.ciudad);
                System.out.println("Seleccione un producto para consultar su valor. O escriba \"q\" para salir.");
            }
            else 
            {
                System.out.println(lectura + " no está entre los productos disponibles, escriba un producto posible.");
            }
            System.out.println("Lista de productos: " + lista_productos.toString());
            lectura = scanner.nextLine();
        }
        scanner.close();
    }
}