package org.example;

import com.mysql.cj.log.Log;
import org.example.dao.CopiaDAO;
import org.example.dao.JdbcUtils;
import org.example.dao.PeliculaDAO;
import org.example.dao.UsuarioDao;
import org.example.model.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //System.out.println(new CopiaDAO(JdbcUtils.getConnection()).imprimirCopias("1"));
        Login login = new Login();
        login.setVisible(true);



    }
}