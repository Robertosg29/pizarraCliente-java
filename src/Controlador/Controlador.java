
package Controlador;

import GUI.VPpal;
import data.Brochas;
import data.Cliente;
import data.Protocolo;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Rober
 */
public class Controlador {
    
  Cliente c;
  VPpal v;

    public Controlador(Cliente c) {
        this.c=c;
        v=new VPpal(this);
    }

    public Cliente getC() {
        return c;
    }

    public VPpal getV() {
        return v;
    }
    public void pintarDibujo(String mensaje){
        
        String[]cadenaAtributos=mensaje.split(Protocolo.SEPARADOR2);
        
        int x=Integer.parseInt(cadenaAtributos[0]);
        int y=Integer.parseInt(cadenaAtributos[1]);
        Color color=new Color(Integer.parseInt(cadenaAtributos[2]));
        int grosor=Integer.parseInt(cadenaAtributos[3]);
        Brochas b=Brochas.valueOf(cadenaAtributos[4]);
        
        Image img=imagenDeBrocha(b);
        v.pintarDibujo(x, y, color, grosor,img);
        
    }

    private Image imagenDeBrocha(Brochas b) {
        String ruta=".\\res\\";
        Image img=null ;
        
        switch (b) {
            case BROCHA_NORMAL:
                img=null;
                break;
             case BORRADOR:
                img=null;
                break;
            case SONRISA:
                img = new ImageIcon(ruta+"carita.png").getImage(); 
                break;
            case PINGUINO:
                img = new ImageIcon(ruta+"pingui.png").getImage(); 
                break;
            case CORAZON:
                img = new ImageIcon(ruta+"corazon.png").getImage(); 
                break;
            case MANO:
                img = new ImageIcon(ruta+"manoTonta.png").getImage();
                break;
            case CACA:
                img = new ImageIcon(ruta+"mierda.png").getImage();
                break;
        }
        return img;
    }
}
