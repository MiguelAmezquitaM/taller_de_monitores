import javax.swing.JOptionPane;

public class Requerimientos {

    public static void listarMonitores(Arbin<Monitor> raiz) {
        String lista = Operaciones.listarMonitores(raiz, " ");
        JOptionPane.showMessageDialog(null, lista, "Arbol de Monitores", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void promedioDeEdades(Arbin<Monitor> raiz) {
        float promedio = Operaciones.promedioDeEdades(raiz);
        JOptionPane.showMessageDialog(null, promedio, "Promedio de edades", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void buscarPorNombre(Arbin<Monitor> raiz) {
        String nombre = JOptionPane.showInputDialog("Nombre del monitor");
        Monitor objetivo = Operaciones.buscarPorNombre(raiz, nombre);
        if (objetivo == null) {
            JOptionPane.showMessageDialog(null, "No existe", "No existe", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, objetivo.toString());
        }
    }

    public static void sinMonitorAsociado(Arbin<Monitor> raiz) {
        // Sin monitor asociado
        String sma = Operaciones.sinMonitorAsociado(raiz);
        JOptionPane.showMessageDialog(null, sma, "Sin monitor asociado", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cuantoGanara(Arbin<Monitor> raiz) {
        String nombre = JOptionPane.showInputDialog("Nombre del monitor");
        Arbin<Monitor> Raiz = Operaciones.buscarArbinPorNombre(raiz, nombre);
        int cuantoGana = Operaciones.cuantoGanara(Raiz);
        JOptionPane.showMessageDialog(null, nombre + " gana " + cuantoGana);
    }

    public static void asignarMonitor(Arbin<Monitor> raiz) {
        String lista = Operaciones.listarMonitores(raiz, "");
        String nombre = JOptionPane.showInputDialog(null,
                "Escoge un monitor para asignarle una monitoria\n" + lista + "\n" + "Nombre: ");
        Arbin<Monitor> Raiz = Operaciones.buscarArbinPorNombre(raiz, nombre);
        if (Raiz == null) {
            JOptionPane.showMessageDialog(null, "Monitor no encontrado");
            return;
        }
        String nombreM = JOptionPane.showInputDialog(null, "Nombre del monitor nuevo: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del monitor nuevo: "));
        int promedio = Integer.parseInt(JOptionPane.showInputDialog(null, "Promedio del monitor nuevo: "));
        Monitor monitor = new Monitor(nombreM, edad, promedio);
        Operaciones.asignarMonitor(Raiz, monitor);
    }

}

class Operaciones {

    public static String listarMonitores(Arbin<Monitor> raiz, String sep) {
        String lista = raiz.obtener().toString() + "\n";

        if (raiz.izq() != null) {
            lista += sep + listarMonitores(raiz.izq(), sep + "  ");
        }
        if (raiz.der() != null) {
            lista += sep + listarMonitores(raiz.der(), sep + "  ");
        }
        return lista;
    }

    public static String sinMonitorAsociado(Arbin<Monitor> raiz) {
        if (raiz == null) {
            return "";
        }
        if (raiz.izq() == null && raiz.der() == null) {
            return raiz.obtener().toString() + "\n";
        }

        return sinMonitorAsociado(raiz.der()) + sinMonitorAsociado(raiz.izq());
    }

    public static float promedioDeEdades(Arbin<Monitor> raiz) {
        if (raiz == null) {
            return 0.f;
        }
        return sumaDeEdades(raiz) / numeroDeElementos(raiz);
    }

    private static int numeroDeElementos(Arbin<Monitor> raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + numeroDeElementos(raiz.izq()) + numeroDeElementos(raiz.der());
    }

    private static float sumaDeEdades(Arbin<Monitor> raiz) {
        if (raiz == null) {
            return 0.f;
        }
        return raiz.obtener().edad + sumaDeEdades(raiz.izq()) + sumaDeEdades(raiz.der());
    }

    public static Monitor buscarPorNombre(Arbin<Monitor> raiz, String nombre) {
        if (raiz == null) {
            return null;
        }
        if (raiz.obtener().nombre.equals(nombre)) {
            return raiz.obtener();
        }

        Monitor m1 = buscarPorNombre(raiz.izq(), nombre);
        Monitor m2 = buscarPorNombre(raiz.der(), nombre);

        if (m1 != null) {
            return m1;
        }
        return m2;
    }

    public static Arbin<Monitor> buscarArbinPorNombre(Arbin<Monitor> raiz, String nombre) {
        if (raiz == null) {
            return null;
        }
        if (raiz.obtener().nombre.equals(nombre)) {
            return raiz;
        }

        Arbin<Monitor> r1 = buscarArbinPorNombre(raiz.izq(), nombre);
        Arbin<Monitor> r2 = buscarArbinPorNombre(raiz.der(), nombre);

        if (r1 != null) {
            return r1;
        }
        return r2;
    }

    public static int cuantoGanara(Arbin<Monitor> raiz) {
        if (raiz == null) {
            return 0;
        }
        int directas = 0;
        if (raiz.izq() == null || raiz.der() == null)
            directas++;
        else
            directas = 2;
        int indirectas = numeroDeElementos(raiz) - 1 - directas;
        return (directas * 100) + (indirectas * 20);
    }

    public static void asignarMonitor(Arbin<Monitor> raiz, Monitor x) {
        if (raiz == null)
            return;
        if (raiz.izq() != null && raiz.der() != null) {
            JOptionPane.showMessageDialog(null, "Este monitor no tiene espacio");
            return;
        }
        if (raiz.izq() == null) {
            raiz.setDer(new Arbin<>(x));
            return;
        }
        if (raiz.der() == null) {
            raiz.setDer(new Arbin<>(x));
            return;
        }
    }
}
