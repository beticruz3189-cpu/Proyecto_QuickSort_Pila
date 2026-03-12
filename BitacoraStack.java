import java.util.EmptyStackException;

public class BitacoraStack {
    // Definición de NODO según el manual [cite: 98, 99, 100]
    private class Nodo {
        String evento; // info
        Nodo siguiente; // sgte
        Nodo(String evento) { this.evento = evento; this.siguiente = null; }
    }

    private Nodo tope; // prim [cite: 104]
    private int tamaño; // longitud [cite: 103]

    public BitacoraStack() { this.tope = null; this.tamaño = 0; }

    // Operación Push (Registrar) [cite: 60, 108]
    public void registrar(String evento) {
        Nodo nuevo = new Nodo(evento);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamaño++;
    }

    // Operación Pop (Eliminar) [cite: 64, 127]
    public String eliminarUltimo() {
        if (estaVacia()) throw new EmptyStackException();
        String dato = tope.evento;
        tope = tope.siguiente;
        tamaño--;
        return dato;
    }

    // Operación Tope (Consultar) [cite: 68, 147]
    public String consultarUltimo() {
        if (estaVacia()) throw new EmptyStackException();
        return tope.evento;
    }

    public boolean estaVacia() { return tope == null; }
    public int totalEventos() { return tamaño; }
}