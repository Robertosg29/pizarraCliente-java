package data;

import javax.swing.JOptionPane;

/**
 *
 * @author Rober
 */
public class Main {

    public static void main(String[] args) {
        try {
            String nombre = introducirNombre();
            Cliente c = new Cliente(nombre);
            if (!c.conectarServer()) {
                JOptionPane.showMessageDialog(null, "El servidor no esta disponible.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
//            JOptionPane.showMessageDialog(null, "Gracias por usar este servicio, hasta luego.");
        }

    }

    public static String introducirNombre() {
        String nombre = "";
        nombre = JOptionPane.showInputDialog(null, "¿Cómo te llamas?");

        while (nombre.compareTo("") == 0) {
            nombre = JOptionPane.showInputDialog(null, "No puedes introducir una cadena vacía ¿Cómo te llamas?");
        }
        return nombre;
    }
}
