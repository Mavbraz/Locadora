package main;

import cliente.Cliente;
import cliente.ClienteDados;
import javax.swing.JOptionPane;

//Classe teste para ver se cadastra, atualiza e remove corretamente.
public class Main {

    public static void main(String[] args) {
        //Criando Cliente
        Cliente c = new Cliente();
        c.setCpf("123.456.789-00");
        //c.setNome("Josefina"); //Em cadastrar
        c.setSexo('M');
        c.setDataNascimento("01/01/2017");
        c.setTelefone("(81)99807-3310");
        c.setCep("12345-678");
        c.setLogradouro("Rua ABC");
        c.setNumero(120);
        c.setBairro("Boa Viagem");
        c.setCidade("Recife");
        c.setUf("PE");

        c.setNome("José"); //Em atualizar

        //Tentativa, se der erro mostra a mensagem
        try {
            //Cria uma instância de dados para ser utilizada
            ClienteDados dados = new ClienteDados();

            //dados.cadastrar(c);
            //JOptionPane.showMessageDialog(null, "Inserido com sucesso.");

            //dados.atualizar(c);
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

            dados.remover(c);
            JOptionPane.showMessageDialog(null, "Removido com sucesso.");
        } catch (Exception ex) {
            //Exibição do erro
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }
}
