package fabricante;

import outros.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FabricanteDados extends ConexaoBD implements FabricanteInterface {

    @Override
    public void inserir(Fabricante f) throws Exception {
        f = putNull(f);
        
        conectar();
        String sql = "INSERT INTO Fabricante (CNPJ, Nome_Fantasia, Razao_Social, Telefone, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, UF)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, f.getCnpj());
            cmd.setString(2, f.getNomeFantasia());
            cmd.setString(3, f.getRazaoSocial());
            cmd.setString(4, f.getTelefone());
            cmd.setString(5, f.getCep());
            cmd.setString(6, f.getLogradouro());
            cmd.setInt(7, f.getNumero());
            cmd.setString(8, f.getComplemento());
            cmd.setString(9, f.getBairro());
            cmd.setString(10, f.getCidade());
            cmd.setString(11, f.getUf());
            cmd.execute();
        } catch (SQLException e) {
            //Tratamento do erro, enviando a throw com essa mensagem para outro lugar, onde vai ser tratada corretamente
            throw new Exception("Erro ao inserir. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Fabricante f) throws Exception {
        f = putNull(f);
        
        conectar();
        String sql = "UPDATE Fabricante SET Nome_Fantasia = ?, Razao_Social = ?, Telefone = ?, CEP = ?, Logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?, Cidade = ?, UF = ? WHERE CNPJ = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, f.getNomeFantasia());
            cmd.setString(2, f.getRazaoSocial());
            cmd.setString(3, f.getTelefone());
            cmd.setString(4, f.getCep());
            cmd.setString(5, f.getLogradouro());
            cmd.setInt(6, f.getNumero());
            cmd.setString(7, f.getComplemento());
            cmd.setString(8, f.getBairro());
            cmd.setString(9, f.getCidade());
            cmd.setString(10, f.getUf());
            cmd.setString(11, f.getCnpj());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void remover(Fabricante f) throws Exception {
        conectar();
        String sql = "DELETE FROM Fabricante WHERE CNPJ = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, f.getCnpj());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public ArrayList<Fabricante> listar(Fabricante filtro) throws Exception {
        int position = 1;
        ArrayList<Fabricante> fabricantes = new ArrayList<>();

        conectar();
        String sql = "SELECT CNPJ, Nome_Fantasia, Razao_Social, Telefone, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, UF ";
        sql += "FROM Fabricante WHERE CNPJ IS NOT NULL";
        if (filtro.getCnpj() != null && !filtro.getCnpj().equals("")) {
            sql += " AND CNPJ = ?";
        }
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            if (filtro.getCnpj() != null && !filtro.getCnpj().equals("")) {
                cmd.setString(position, filtro.getCnpj());
                position += 1;
            }
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Fabricante f = new Fabricante();
                f.setCnpj(leitor.getString("CNPJ"));
                f.setNomeFantasia(leitor.getString("Nome_Fantasia"));
                f.setRazaoSocial(leitor.getString("Razao_Social"));
                f.setTelefone(leitor.getString("Telefone"));
                f.setCep(leitor.getString("CEP"));
                f.setLogradouro(leitor.getString("Logradouro"));
                f.setNumero(leitor.getInt("Numero"));
                f.setComplemento(leitor.getString("Complemento"));
                f.setBairro(leitor.getString("Bairro"));
                f.setCidade(leitor.getString("Cidade"));
                f.setUf(leitor.getString("UF"));

                f = clearNull(f);
                fabricantes.add(f);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar: " + e.getMessage());
        }
        desconectar();
        
        return fabricantes;
    }
    
    private Fabricante putNull(Fabricante f) {
        if (f.getNomeFantasia().equals("")) {
            f.setNomeFantasia(null);
        }
        if (f.getComplemento().equals("")) {
            f.setComplemento(null);
        }
        return f;
    }
    
    private Fabricante clearNull(Fabricante f) {
        if (f.getNomeFantasia() == null) {
            f.setNomeFantasia("");
        }
        if (f.getComplemento() == null) {
            f.setComplemento("");
        }
        return f;
    }

}
