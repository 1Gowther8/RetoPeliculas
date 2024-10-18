package org.example;

import org.example.dao.JdbcUtils;
import org.example.dao.UsuarioDao;
import org.example.model.Sesion;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        this.setSize(500, 500);


        UsuarioDao usuarioDao = new UsuarioDao(JdbcUtils.getConnection());


        accederBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textousuario.getText();
                String contraseña = new String(textocontraseña.getPassword());
                if(usuario.isEmpty() || contraseña.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña vacios");
                    return;
                }
                Usuario user = new UsuarioDao(JdbcUtils.getConnection()).obtenerUsuario(usuario, contraseña);


                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
                    Sesion.usuariosesion=user;
                    dispose();
                    new TablaCopias().setVisible(true);


                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        salirBoton.addActionListener(e -> System.exit(0));
    }


}


