package abstraccion;

public class Log {
    public static void log(String nivel, String mensaje) {
        String registro = String.format("[%s] %s %n",
                nivel.toUpperCase(),
                mensaje);

        System.out.print(registro);
    }

    public static void log(String superclase, String nivel, String mensaje) {
        String registro = String.format("[%s]->[%s] %s %n",
                superclase.toUpperCase(),
                nivel.toUpperCase(),
                mensaje);

        System.out.print(registro);
    }
}