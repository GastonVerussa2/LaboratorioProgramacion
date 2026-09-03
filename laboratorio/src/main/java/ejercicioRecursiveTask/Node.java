package ejercicioRecursiveTask;

public class Node {
    Node firstChild;
    Node nextSibling;
    String nombre;
    Local[] locales;


    Node(String nombre, Local[] locales,  Node child, Node sibling)
    {
        this.nombre = nombre;
        this.firstChild = child;
        this.nextSibling = sibling;
        this.locales = locales;

        System.out.println("En " + this.nombre + " los precios de los locales son: ");
        for(Local local: locales)
        {
           System.out.println(local.toString());
        }
    }

    public Node getChild()
    {
        return firstChild;
    }

    public Node getSibling()
    {
        return nextSibling;
    }

    public void addChild(Node child)
    {
        if(firstChild != null)
        {
            firstChild.setSibling(child);
        } 
        firstChild = child;
    }

    public void setSibling(Node sibling)
    {
        if(nextSibling == null)
        {
            nextSibling = sibling;
        } 
        else 
        {
            sibling.setSibling(nextSibling);
            nextSibling = sibling;
        }
    }

    public Local[] getLocales()
    {
        return locales;
    }
}