package org.example;

import org.example.dao.JdbcUtils;
import org.example.dao.UsuarioDao;
import org.example.model.Sesion;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;
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
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla// Centrar la ventana en la pantalla


        ImageIcon imagenOriginal = new ImageIcon("src/main/resources/imagenes/fotoLogin.png");

        // Escalar la imagen a 100x100 píxeles
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
        imagenlogin.setIcon(imagenFinal);


        accederBoton.addActionListener(new ActionListener() {
            @Override

            /*Verifica si el usuario y la contraseña son correctos, si lo son,
             entonces se muestra un mensaje de bienvenida y se abre la ventana de TablaCopias*/

            public void actionPerformed(ActionEvent e) {
                String usuario = textousuario.getText();
                String contraseña = new String(textocontraseña.getPassword());
                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña vacios");
                    return;
                }
                Usuario user = new UsuarioDao(JdbcUtils.getConnection()).obtenerUsuario(usuario, contraseña);


                if (user != null) {  /*Si el usuario no es nulo, entonces se muestra un mensaje de bienvenida y se abre la ventana de TablaCopias*/
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                    Sesion.usuariosesion = user;
                    dispose();
                    new TablaCopias().setVisible(true);


                } else { /*Si el usuario es nulo, entonces se muestra un mensaje de error*/
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        salirBoton.addActionListener(e -> System.exit(0));


    }


}


