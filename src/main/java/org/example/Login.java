package org.example;

import javax.swing.*;


public class Login extends JFrame {
    private JPanel login;
    private JButton salirBoton;
    private JTextField textousuario;
    private JButton accederBoton;
    private JLabel imagenlogin;
    private JPasswordField textocontraseña;


    public Login() {
        this.setContentPane(login);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);




    }
}


