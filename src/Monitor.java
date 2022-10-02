public class Monitor {
    public String  nombre;
    public Integer edad;
    public Double  promedio;
    
    public Monitor(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "[Monitor nombre: " + nombre + ", edad: " + edad + ", promedio: " + promedio + "]";
    }
}
