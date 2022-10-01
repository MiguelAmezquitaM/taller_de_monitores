import javax.swing.JOptionPane;

public class Menu {
    static Monitor[] monitores = new Monitor[] {
            new Monitor("M1", 19, 411),
            new Monitor("M2", 17, 421),
            new Monitor("M3", 20, 418),
            new Monitor("M4", 22, 381),
            new Monitor("M5", 17, 415),
            new Monitor("M6", 20, 419),
            new Monitor("M7", 18, 481),
            new Monitor("M8", 17, 401),
            new Monitor("M9", 18, 391)
    };

    public static void main(String[] args) {
        Arbin<Monitor> monitores = crearArbol();

        String menuPrincipal = "1. Listar monitores\n" +
                "2. Ver promedio de edades\n" +
                "3. Buscar por nombre\n" +
                "4. Obtener cuanto gana por nombre\n" +
                "5. Asignar monitoria directa a un monitor\n" +
                "6. Listar monitores sin asociados\n\n" +

                "Seleccione option: ";

        String opcion = JOptionPane.showInputDialog(null, menuPrincipal, "Seleccione una opcion",
                JOptionPane.QUESTION_MESSAGE);

        switch (Integer.parseInt(opcion)) {
            case 1:
                Requerimientos.listarMonitores(monitores);
                break;
            case 2:
                Requerimientos.promedioDeEdades(monitores);
                break;
            case 3:
                Requerimientos.buscarPorNombre(monitores);
                break;
            case 4:
                Requerimientos.cuantoGanara(monitores);
                break;
            case 5:
                Requerimientos.asignarMonitor(monitores);
                break;
            case 6:
                Requerimientos.sinMonitorAsociado(monitores);
                break;
            default:
                break;
        }
    }

    private static Arbin<Monitor> crearArbol() {
        return new Arbin<>(
                monitores[0],
                new Arbin<>(monitores[1],
                        new Arbin<>(monitores[3],
                                new Arbin<>(monitores[6]),
                                null),
                        new Arbin<>(monitores[8])),
                new Arbin<>(monitores[2],
                        new Arbin<>(monitores[4]),
                        new Arbin<>(monitores[5],
                                new Arbin<>(monitores[7]),
                                null)));
    }
}
