package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {

    private Connection connection;

    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }





    public Pelicula filtrarPorAños(int año1,int año2){
        Pelicula Pelicula = null;
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM pelicula WHERE año BETWEEN ? AND ?")) {
            ps.setInt(1, año1);
            ps.setInt(2, año2);
            var resultSet = ps.executeQuery();
            if(resultSet.next()) {
                Pelicula = new Pelicula(
                 resultSet.getInt(1),
                    resultSet.getString(2),
                        resultSet.getString(4),
                    resultSet.getInt(3)
                );
                System.out.println(Pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Pelicula;


    }

    public Pelicula contarPeliculas(){
        Pelicula Pelicula = null;
        try(PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM pelicula")) {
            var resultSet = ps.executeQuery();
            if(resultSet.next()) {
                System.out.println("El numero de peliculas es: "+resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Pelicula;
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
