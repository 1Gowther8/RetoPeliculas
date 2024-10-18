package org.example;

import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        new PeliculaDAO(JdbcUtils.getConnection()).filtrarPorAños(2000,2010);
        System.out.println("Peliculas filtradas por años 2000-2010");



    }
}