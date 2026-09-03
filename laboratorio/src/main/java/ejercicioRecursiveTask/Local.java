package ejercicioRecursiveTask;
import java.util.HashMap;

public class Local {
    HashMap<String, Integer> precios;
    String nombre;
    static String[] productos;

    Local(String nombre)
    {
        this.nombre = nombre;
        //   Se genera con precios al azar para los productos
        this.precios = new HashMap<String, Integer>(productos.length);
        for(String producto: productos)
        {
            //  a cada producto le asigna un precio al azar entre 1000 y 5000
            this.precios.put(producto, (int) (Math.random() * 4000) + 1000);
        }
    }

    public void agregarPrecio(String producto, int precio)
    {
        precios.put(producto, precio);
    }

    public int getPrecio(String producto)
    {
        return precios.get(producto);
    }
    
    public static void setProductos(String[] productosStrings)
    {
        productos = productosStrings;
    }

    @Override
    public String toString()
    {
        String resultado = this.nombre + ": ";
        for(String prod: productos)
        {
            resultado += prod + ": " + precios.get(prod) + ", ";
        }
        return resultado;
    }
}
