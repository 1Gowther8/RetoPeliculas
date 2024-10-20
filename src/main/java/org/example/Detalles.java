package org.example;

import org.example.model.Sesion;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Detalles extends JFrame {


    private JLabel detallesaño;
    private JLabel detallesdirector;
    private JLabel detallesestado;
    private JLabel detallessoporte;
    private JPanel detalles;

    private JLabel detallestitulo;

    private JPanel contenedordescripcion;


    private JScrollPane scrolldescripcion;
    private JTextArea detallesdescripcion;
    private JLabel imgdetalles;
    private JLabel detallesid;
    private JLabel detallesgenero;

    public Detalles() {
        this.setContentPane(detalles);
        this.setTitle("Detalles");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); /*Se cierra la ventana de detalles sin cerrar todo el programa */
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        mostrarDetalles();



    }

    public void mostrarDetalles() {

        ImageIcon imagenOriginal = new ImageIcon("src/main/resources/imagenes/fotodetalleslogo.png");

        // Escalar la imagen a 100x100 píxeles
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
        imgdetalles.setIcon(imagenFinal);

        // Añadir un DocumentListener para ajustar el tamaño según el contenido
        detallesdescripcion.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { ajustarTamaño(detallesdescripcion); }
            public void removeUpdate(DocumentEvent e) { ajustarTamaño(detallesdescripcion); }
            public void changedUpdate(DocumentEvent e) { ajustarTamaño(detallesdescripcion); }

            // Método para ajustar el tamaño del JTextArea dinámicamente
            private void ajustarTamaño(JTextArea textArea) {
                textArea.setRows(textArea.getLineCount()+3);
            }
        });

        // Crear el JScrollPane y evitar el desplazamiento horizontal

        scrolldescripcion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrolldescripcion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);


        //Evita que la descripcion salga cortada entre otras cosas
       detallesdescripcion.setRows(15);
        detallesdescripcion.setColumns(30);
        detallesdescripcion.setLineWrap(true);                 // Ajustar el texto a la línea
        detallesdescripcion.setWrapStyleWord(true);        // Ajustar por palabras completas




        detallesid.setText("ID: " + Sesion.copiasesion.getId_pelicula());
        detallesdescripcion.setText(Sesion.peliculasesion.getDescripcion());
        detallestitulo.setText("Titulo "+Sesion.peliculasesion.getTitulo());
        detallesgenero.setText("Genero: "+Sesion.peliculasesion.getGenero());
        detallesaño.setText(String.valueOf("Año: "+Sesion.peliculasesion.getAño()));
        detallesdescripcion.setText(Sesion.peliculasesion.getDescripcion());
        detallesdirector.setText("Director: "+Sesion.peliculasesion.getDirector());
        detallesestado.setText("Estado: "+Sesion.copiasesion.getEstado());
        detallessoporte.setText("Soporte: "+Sesion.copiasesion.getSoporte());


    }


}
