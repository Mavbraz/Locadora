package fabricante;

import fachada.Fachada;
import java.util.ArrayList;

public class FabricanteNegocio implements FabricanteInterface {
    
    
    private void validarCampos(Fabricante f) throws Exception {
        if (f.getRazaoSocial().equals("")) {
            throw new Exception("Razão Social inválida.");
        }
        
        if (f.getTelefone().replace(" ", "").length() < 13) {
            throw new Exception("Telefone inválido.");
        }
        
        if (f.getCep().replace(" ", "").length() < 10) {
            throw new Exception("CEP inválido.");
        }
        
        if (f.getLogradouro().equals("")) {
            throw new Exception("Logradouro inválido.");
        }
        
        if (f.getNumero() < 1) {
            throw new Exception("Número inválido.");
        }
        
        if (f.getBairro().equals("")) {
            throw new Exception("Bairro inválido.");
        }
        
        if (f.getCidade().equals("")) {
            throw new Exception("Cidade inválida.");
        }
    }

    @Override
    public void inserir(Fabricante f) throws Exception {
        Fachada fachada = new Fachada();
        
        if (f.getCnpj().replace(" ", "").length() < 18) {
            throw new Exception("CNPJ inválido.");
        }
        
        validarCampos(f);
        
        ArrayList<Fabricante> existencia = fachada.listar(f);
        if (!existencia.isEmpty()) {
            throw new Exception("Fabricante existente.");
        }
        
        FabricanteDados dados = new FabricanteDados();
        dados.inserir(f);
    }

    @Override
    public void atualizar(Fabricante f) throws Exception {
        validarCampos(f);
        
        FabricanteDados dados = new FabricanteDados();
        dados.atualizar(f);
    }

    @Override
    public void remover(Fabricante f) throws Exception {
        FabricanteDados dados = new FabricanteDados();
        dados.remover(f);
    }

    @Override
    public ArrayList<Fabricante> listar(Fabricante filtro) throws Exception {
        FabricanteDados dados = new FabricanteDados();
        return dados.listar(filtro);
    }

}
