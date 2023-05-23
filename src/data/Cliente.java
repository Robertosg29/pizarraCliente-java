package data;

import Controlador.Controlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Rober
 */
public class Cliente {

    Socket conexionConServidor = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    boolean finCliente=false;
    Controlador c;
    String nombre;
    int cod;

    public Cliente(String nombre) {
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCod() {
        return cod;
    }
    

    public DataOutputStream getOut() {
        return out;
    }

    public void setFinCliente(boolean finCliente) {
        this.finCliente = finCliente;
    }
    
    

    public boolean conectarServer() {
        
        try {
            conexionConServidor = new Socket(("localhost"),50000);
        } catch (IOException ex) {
             return false;
        }

       
        try {
            in = new DataInputStream(conexionConServidor.getInputStream());
            out = new DataOutputStream(conexionConServidor.getOutputStream());
            
            //Solo te creas el controlador si el servidor esta operativo si no, da problemas
            this.c=new Controlador(this);
            //enviamos el nombre al GB para que se lo asigne
            out.writeUTF(Protocolo.USUARIO_CONECTADO_C+Protocolo.SEPARADOR+nombre);
            out.flush();
            while(!finCliente){
                try {
                    conexionConServidor.setSoTimeout(3000);
                    String cad=in.readUTF();
                    System.out.println("Servidor dice : "+cad);
                    recibirServidor(cad);

                } catch (IOException iOException) {
                }
          
            }

        } catch (IOException ex) {
            System.out.println("Error al crear el flujo de entrada o salida del Cliente o el servidor ha cortado la conexion");
        }

        try {

            out.close();
            in.close();
            conexionConServidor.close();
            System.out.println("Se ha finalizado la comunicacion.");
        } catch (IOException ex) {
            System.out.println("Algún flujo no puede cerrarse.");
        }
        return true;
    }

    private void recibirServidor(String cad) {
        
        String []msjServidor=cad.split(Protocolo.SEPARADOR);
        switch (msjServidor[0]) {
            case ""+Protocolo.PINTAR_S:
                recibirDibujo(msjServidor[1]);
                break;
            case ""+Protocolo.FIN_SERVIDOR:
                finCliente=true;
                JOptionPane.showMessageDialog(null, "El servidor ha cerrado la comunicación");
                c.getV().dispose();
                break;
             case "" + Protocolo.USUARIO_CONECTADO_S:
                cod=Integer.parseInt(msjServidor[1]);
                c.getV().darValorEtiquetaVentana();
                c.getV().setVisible(true);
                break;
        }
    }

    private void recibirDibujo(String mensaje) {
        c.pintarDibujo(mensaje);
    }
}