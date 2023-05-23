package GUI;

import Controlador.Controlador;
import data.Brochas;
import data.Protocolo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rober
 */
public class Ppizarra extends javax.swing.JPanel implements MouseMotionListener,MouseListener{

    Color color;
    Controlador c;
    int grosorLapiz;
    Brochas b;
    BufferedImage bf;
    
    public Ppizarra(Controlador c) {
        setSize(600,475);
        initComponents();
        addMouseMotionListener(this);
        addMouseListener(this);
        this.c=c;
        this.b=Brochas.BROCHA_NORMAL;
        color=Color.WHITE;
        grosorLapiz=4;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            int posX=e.getX();
            int posY=e.getY();
            c.getC().getOut().writeUTF(Protocolo.PINTAR_C+Protocolo.SEPARADOR+posX+Protocolo.SEPARADOR2+posY+Protocolo.SEPARADOR2+color.getRGB()+Protocolo.SEPARADOR2+grosorLapiz+Protocolo.SEPARADOR2+b);
            c.getC().getOut().flush();
        } catch (IOException ex) {
            Logger.getLogger(Ppizarra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         try {
            int posX=e.getX();
            int posY=e.getY();
            c.getC().getOut().writeUTF(Protocolo.PINTAR_C+Protocolo.SEPARADOR+posX+Protocolo.SEPARADOR2+posY+Protocolo.SEPARADOR2+color.getRGB()+Protocolo.SEPARADOR2+grosorLapiz+Protocolo.SEPARADOR2+b);
            c.getC().getOut().flush();
        } catch (IOException ex) {
            Logger.getLogger(Ppizarra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getGrosorLapiz() {
        return grosorLapiz;
    }

    public void setGrosorLapiz(int grosorLapiz) {
        this.grosorLapiz = grosorLapiz;
    }

    public Brochas getB() {
        return b;
    }

    public void setB(Brochas b) {
        this.b = b;
    }

    public void setBf(BufferedImage bf) {
        this.bf = bf;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bf,0, 0,null);
    }

    
    
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
