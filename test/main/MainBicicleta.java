package main;

import bicicleta.Bicicleta;
import fachada.Fachada;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainBicicleta {

    public static void main(String[] args) {
        Fachada fachada = new Fachada();

        Bicicleta b = new Bicicleta();
        b.setCodigo(4);
        b.getFabricante().setCnpj("04.301.024/0002-12");
        b.getCategoria().setCodigo(1);
        b.setDescricao("Bicicleta do Seninha");
        b.setAno("2005");
        b.setCor("Preto");
        b.setPneu("Aro 10000");

        //b.setDescricao("Bicicleta da Peppa");
        //b.setAno("2014");
        //b.setCor("Rosa");
        //b.setPneu("Ano 11000");

        try {
            //fachada.inserir(b);
            //JOptionPane.showMessageDialog(null, "Inserido com sucesso.");

            //fachada.atualizar(b);
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

            //fachada.remover(b);
            //JOptionPane.showMessageDialog(null, "Removido com sucesso.");

            /*String message = "";
            Bicicleta filtro = new Bicicleta();
            ArrayList<Bicicleta> bicicletas = fachada.listar(filtro);
            for (Bicicleta bicicleta : bicicletas) {
                message += "Código: " + bicicleta.getCodigo()  + "\n";
                message += "Fabricante: " + bicicleta.getFabricante().getCnpj()  + "\n";
                message += "Categoria: " + bicicleta.getCategoria().getCodigo()  + "\n";
                message += "Descricao: " + bicicleta.getDescricao()  + "\n";
                message += "Ano: " + bicicleta.getAno()  + "\n";
                message += "Cor: " + bicicleta.getCor()  + "\n";
                message += "Pneu: " + bicicleta.getPneu()  + "\n\n";
            }
            JOptionPane.showMessageDialog(null, message);*/

            //boolean existencia = fachada.verificarBicicleta(b);
            //JOptionPane.showMessageDialog(null, "Existencia: " + existencia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
