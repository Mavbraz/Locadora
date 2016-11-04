package main;

import cliente.Cliente;
import cliente.ClienteDados;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setCpf("123.456.789-00");
        c.setNome("Josefina");
        c.setSexo('M');
        c.setDataNascimento("01/01/2017");
        c.setTelefone("(81)99807-3310");
        c.setCep("12345-678");
        c.setLogradouro("Rua ABC");
        c.setNumero(120);
        c.setBairro("Boa Viagem");
        c.setCidade("Recife");
        c.setUf("PE");

        try {
            ClienteDados dados = new ClienteDados();
            dados.cadastrar(c);

            JOptionPane.showMessageDialog(null, "Inserido com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }
}
