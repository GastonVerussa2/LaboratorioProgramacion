package ejercicioRecursiveTask;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class Tarea extends RecursiveTask<Respuesta> {
    final int seqThreshold = 500;
    Node raiz;
    String producto_buscado;

    Tarea(Node raiz, String producto)
    {
        this.raiz = raiz;
        this.producto_buscado = producto;
    }

    @Override
    protected Respuesta compute()
    {
        Respuesta resp = new Respuesta(100000, raiz.nombre, null);
        //   Manda una nueva tarea para cada hijo
        ArrayList<Tarea> tareas = new ArrayList<>();
        Node nodo_actual = raiz.getChild();
        while(nodo_actual != null)
        {
            Tarea tarea_nueva = new Tarea(nodo_actual, producto_buscado);
            tareas.add(tarea_nueva);
            tarea_nueva.fork();
            nodo_actual = nodo_actual.getSibling();
        }

        // Revisa en sus locales
        for(Local local:  raiz.getLocales())
        {
            if(local.getPrecio(producto_buscado) < resp.precio)
            {
                resp.precio = local.getPrecio(producto_buscado);
                resp.local = local.nombre;
            }
        }

        // Recupera los precios de las tareas creadas y compara
        for(Tarea tarea: tareas)
        {
            Respuesta resp_tarea = tarea.join();
            if(resp_tarea.precio < resp.precio)
            {
                resp = resp_tarea;
            }
        }

        return resp;
    }
}