package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Pelicula pelicula = null;
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        String query = "SELECT * FROM Pelicula WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setAño(rs.getInt("año"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setDirector(rs.getString("director"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    @Override
    public void save(Pelicula Pelicula) {

    }

    @Override
    public void update(Pelicula Pelicula) {

    }

    @Override
    public void delete(int id) {


    }

}
