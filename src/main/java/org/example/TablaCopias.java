package org.example;

import javax.swing.*;

public class TablaCopias extends JFrame {
    private JTable tablacopias;
    private JPanel ventanacopias;
    private JButton volverButton;
    private JPanel copias;
    private JLabel copiasusuario;

    public TablaCopias() {
        this.setContentPane(copias);
        this.setTitle("Tabla de Copias");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
    }
}
