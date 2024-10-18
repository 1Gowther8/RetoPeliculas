package org.example;

import org.example.model.Sesion;
import org.example.model.Usuario;

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

        String usuariotabla=Sesion.usuariosesion.getNombreUsuario();
        copiasusuario.setText(" "+usuariotabla);

        volverButton.addActionListener(e -> {
            new Login().setVisible(true);
        });


    }
}
