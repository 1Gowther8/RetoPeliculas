package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Pelicula implements Serializable {
    private int id;
    private String titulo;
    private String genero;
    private int año;
    private String descripcion;
    private String director;


    public Pelicula(String titulo, int año, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.genero = genero;
    }



    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", año='" + año + '\'' +
                '}';
    }
}
