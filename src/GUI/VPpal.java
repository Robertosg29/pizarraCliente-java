package GUI;

import Controlador.Controlador;
import data.Protocolo;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rober
 */
public class VPpal extends javax.swing.JFrame {

    Controlador c;
    PPal pp;

    public VPpal(Controlador c) {
        
        initComponents();
        minitComponents();
        this.c = c;
        this.pp = new PPal(c);
        ponPanel(pp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pintarDibujo(int x, int y, Color c, int grosor,Image img) {
        pp.pintar(x, y, c, grosor,img);
    }

    public void ponPanel(JPanel p) {
        setContentPane(p);
        revalidate();
    }

    private void minitComponents() {
        setTitle("Pizarra 2.0");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    c.getC().getOut().writeUTF(Protocolo.FIN_CLIENTE +Protocolo.SEPARADOR);
                    c.getC().getOut().flush();
                    c.getC().setFinCliente(true);
                    JOptionPane.showMessageDialog(VPpal.this, "Gracias por utilizar nuestro servicio.");
                } catch (IOException ex) {
                    Logger.getLogger(VPpal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    public void darValorEtiquetaVentana() {
        pp.geteCabecera().setText("Pizarra de "+c.getC().getNombre()+"  COD ("+c.getC().getCod()+")");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
