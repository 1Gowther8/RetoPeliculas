package org.example;

import javax.swing.*;

public class Detalles extends JFrame {
    private JLabel detalletitulo;
    private JLabel detallegenero;
    private JLabel detallesaño;
    private JTextArea detallesdescripcion;
    private JLabel detallesdirector;
    private JLabel detallesestado;
    private JLabel detallessoporte;
    private JPanel detalles;

    public Detalles() {
        this.setContentPane(detalles);
        this.setTitle("Detalles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
    }
}
