public class Arbin<T> {
    private T dato;
    private Arbin<T> izq;
    private Arbin<T> der;
    
    public Arbin(T dato, Arbin<T> izq, Arbin<T> der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public Arbin(T dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
 
    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setIzq(Arbin<T> izq) {
        this.izq = izq;
    }

    public void setDer(Arbin<T> der) {
        this.der = der;
    }

    public T obtener() {
        return dato;
    }

    public Arbin<T> izq() {
        return izq;
    }

    public Arbin<T> der() {
        return der;
    }
}
