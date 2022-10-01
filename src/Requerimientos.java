import javax.swing.JOptionPane;

public class Requerimientos {

    public static void listarMonitores(Arbin<Monitor> raiz) {
        String lista = Operaciones.listarMonitores(raiz, "    ");
        JOptionPane.showMessageDialog(null, lista, "Arbol de Monitores", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void promedioDeEdades(Arbin<Monitor> raiz) {
        float promedio = Operaciones.promedioDeEdades(raiz);
        JOptionPane.showMessageDialog(null, promedio, "Promedio de edades", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void buscarPorNombre(Arbin<Monitor> raiz) {
        String nombre = JOptionPane.showInputDialog("Nombre del monitor");
        Monitor objetivo = Operaciones.buscarPorNombre(raiz, nombre);
        if (objetivo == null)
            JOptionPane.showMessageDialog(null, "No existe", "No existe", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, objetivo.toString());
    }

    public static void sinMonitorAsociado(Arbin<Monitor> raiz) {
        // Sin monitor asociado
        String sma = Operaciones.sinMonitorAsociado(raiz);
        JOptionPane.showMessageDialog(null, sma, "Sin monitor asociado", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cuantoGanara(Arbin<Monitor> raiz) {
    }

    public static void asignarMonitor(Arbin<Monitor> raiz) {
    }

}

class Operaciones {
    public static String listarMonitores(Arbin<Monitor> raiz, String sep) {
        String lista = raiz.obtener().toString() + "\n";
        String nextSep = sep + sep;

        if (raiz.izq() != null)
            lista += sep + listarMonitores(raiz.izq(), nextSep);
        if (raiz.der() != null)
            lista += sep + listarMonitores(raiz.der(), nextSep);
        return lista;
    }

    public static String sinMonitorAsociado(Arbin<Monitor> raiz) {
        if (raiz == null) return "";
        if (raiz.izq() == null && raiz.der() == null)
            return raiz.obtener().toString() + "\n";

        return sinMonitorAsociado(raiz.der()) + sinMonitorAsociado(raiz.izq());
    }

    public static float promedioDeEdades(Arbin<Monitor> raiz) {
        if (raiz == null)
            return 0.f;
        return sumaDeEdades(raiz) / numeroDeElementos(raiz);
    }

    private static int numeroDeElementos(Arbin<Monitor> raiz) {
        if (raiz == null)
            return 0;
        return 1 + numeroDeElementos(raiz.izq()) + numeroDeElementos(raiz.der());
    }

    private static float sumaDeEdades(Arbin<Monitor> raiz) {
        if (raiz == null)
            return 0.f;
        return raiz.obtener().edad + promedioDeEdades(raiz.izq()) + promedioDeEdades(raiz.der());
    }

    public static Monitor buscarPorNombre(Arbin<Monitor> raiz, String nombre) {
        if (raiz == null) return null;
        if (raiz.obtener().nombre.equals(nombre)) return raiz.obtener();

        Monitor m1 = buscarPorNombre(raiz.izq(), nombre);
        Monitor m2 = buscarPorNombre(raiz.der(), nombre);

        if (m1 != null) return m1;
        return m2;
    }
}
