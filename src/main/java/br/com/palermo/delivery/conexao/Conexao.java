package br.com.palermo.delivery.conexao;

import br.com.palermo.delivery.exception.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Connection conexao;

    public static Connection conectar() {
        try {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }

            conexao = DriverManager.getConnection(
                    "jdbc:firebirdsql:localhost/3050:C:\\ProjetosJava\\BASE.FDB",
                    "ROOT",
                    "Je@Soft2021");

            return conexao;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        Conexao.conectar();
//    }
}