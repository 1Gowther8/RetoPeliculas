package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {

    private final Connection connection;

    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }






    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }







    @Override
    public Pelicula findById(Integer id) {
        Pelicula Pelicula = null;
        return Pelicula;
    }

    @Override
    public void save(Pelicula Pelicula) {
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO pelicula (titulo, año, genero) VALUES (?,?,?)")){
            ps.setString(1,Pelicula.getTitulo());
            ps.setInt(2,Pelicula.getAño());
            ps.setString(3,Pelicula.getGenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Pelicula Pelicula) {

    }

    @Override
    public void delete(int id) {


    }

}
