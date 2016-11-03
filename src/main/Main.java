package main;

import bancodados.ConexaoBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            ConexaoBD a = new ConexaoBD();
            a.conectar();
            a.desconectar();
            JOptionPane.showMessageDialog(null, "IUPI");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
