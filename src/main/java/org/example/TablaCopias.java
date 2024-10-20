package org.example;

import org.example.dao.CopiaDAO;
import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;
import org.example.model.Copia;
import org.example.model.Sesion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static org.example.model.Sesion.peliculasesion;

public class TablaCopias extends JFrame {
    private JTable tablacopias;
    private JButton volverButton;
    private JPanel copias;
    private JLabel copiasusuario;
    private JPanel ventanacopias;
    private JButton cerrarAplicaciónButton;
    private final DefaultTableModel model;

    public TablaCopias() {
        this.setContentPane(copias);
        this.setTitle("Tabla de Copias");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);

        String usuariotabla = Sesion.usuariosesion.getNombreUsuario();
        copiasusuario.setText(" " + usuariotabla); /*Se muestra el nombre del usuario en la tabla de copias*/

        /*Crea la cabecera de la tabla */

        String[] cabecera = {"Titulo", "Estado", "Soporte"};
        model = new DefaultTableModel(cabecera, 0);
        tablacopias.getTableHeader().setForeground(Color.RED); //Color a la cabecera de la tabla
        tablacopias.setModel(model);

        usuariotabla = Integer.toString(Sesion.usuariosesion.getId());

        /*Se obtienen las copias del usuario y se muestran en la tabla*/
        List<Copia> copias = new CopiaDAO(JdbcUtils.getConnection()).imprimirCopias(usuariotabla);
        for (Copia copia : copias) {
            model.addRow(new Object[]{copia.getTitulo(), copia.getEstado(), copia.getSoporte()});
        }

        tablacopias.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {  /*Si el valor no se está ajustando entonces se obtiene la fila seleccionada*/
                int selectedRow = tablacopias.getSelectedRow();

                if (selectedRow != -1) { /*Verifica que la fila haya sido seleccionada */
                    Sesion.copiasesion = copias.get(selectedRow);
                    /* Se guarda la pelicula seleccionada en la variable peliculasesion y se abre la ventana de Detalles*/
                    peliculasesion = new PeliculaDAO(JdbcUtils.getConnection()).findById(Sesion.copiasesion.getId_pelicula());
                    new Detalles().setVisible(true);
                }
            }
        });

        /*Se cierra la ventana de TablaCopias y se abre la ventana de Login*/
        volverButton.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);

        });


        cerrarAplicaciónButton.addActionListener(e -> dispose());
    }
}