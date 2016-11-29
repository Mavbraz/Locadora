package main;

import cliente.Cliente;
import fachada.Fachada;
import javax.swing.JOptionPane;
import nota.Nota;

//Classe teste para ver se cadastra, atualiza e remove corretamente.
public class Main {

    public static void main(String[] args) {
        //Criando Cliente
        Cliente c = new Cliente();
        c.setCpf("123.456.789-00");
        c.setNome("Josefina"); //Em cadastrar
        c.setSexo('M');
        c.setDataNascimento("01/01/2017");
        c.setTelefone("(81)99807-3310");
        c.setCep("12.345-678");
        c.setLogradouro("Rua ABC");
        c.setNumero(120);
        c.setBairro("Boa Viagem");
        c.setCidade("Recife");
        c.setUf("PE");

        c.setNome("José"); //Em atualizar

        Nota n = new Nota();
        n.setCliente(c);
        n.setCodigo(1);
        n.setData("10/10/2017");
        n.setHorario("08:00");
        //n.setSituacao("PG");

        n.setSituacao("PE");

        //Tentativa, se der erro mostra a mensagem
        try {
            boolean existencia;
            //Cria uma instância de fachada para ser utilizada
            Fachada fachada = new Fachada();

            /*fachada.inserir(c);
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso.");*/

            /*fachada.atualizar(c);
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");*/

            /*fachada.remover(c);
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");*/

            /*existencia = fachada.verificarCliente(c);
            JOptionPane.showMessageDialog(null, "Existência do cliente: " + existencia);*/

            /*fachada.inserir(n);
            JOptionPane.showMessageDialog(null, "Nota inserida com sucesso.");*/

            /*fachada.atualizar(n);
            JOptionPane.showMessageDialog(null, "Nota atualizada com sucesso.");*/

            /*fachada.remover(n);
            JOptionPane.showMessageDialog(null, "Nota removida com sucesso.");*/

            /*existencia = fachada.verificarNota(n);
            JOptionPane.showMessageDialog(null, "Existência da nota: " + existencia);*/

        } catch (Exception ex) {
            //Exibição do erro
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }
}
