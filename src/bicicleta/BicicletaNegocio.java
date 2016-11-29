package bicicleta;

import fachada.Fachada;
import java.util.ArrayList;

public class BicicletaNegocio implements BicicletaInterface {
    
    private void validarCampos(Bicicleta b) throws Exception {
        if (b.getDescricao().equals("")) {
            throw new Exception("Nome inválido.");
        }

        if (b.getAno().replace(" ", "").length() < 4) {
            throw new Exception("Ano inválido.");
        }

        if (b.getCor().equals("")) {
            throw new Exception("Cor inválida.");
        }

        if (b.getPneu().equals("")) {
            throw new Exception("Pneu inválido.");
        }
    }

    @Override
    public void inserir(Bicicleta b) throws Exception {
        Fachada fachada = new Fachada();
        if (b.getCodigo() < 1) {
            throw new Exception("Codigo inválido.");
        }

        validarCampos(b);
        
        ArrayList<Bicicleta> existencia = fachada.listar(b);
        if (!existencia.isEmpty()) {
            throw new Exception("Bicicleta existente.");
        }

        BicicletaDados dados = new BicicletaDados();
        dados.inserir(b);
    }

    @Override
    public void atualizar(Bicicleta b) throws Exception {
        validarCampos(b);

        BicicletaDados dados = new BicicletaDados();
        dados.atualizar(b);
    }

    @Override
    public void remover(Bicicleta b) throws Exception {
        BicicletaDados dados = new BicicletaDados();
        dados.remover(b);
    }

    @Override
    public ArrayList<Bicicleta> listar(Bicicleta filtro) throws Exception {
        BicicletaDados dados = new BicicletaDados();
        return dados.listar(filtro);
    }

}
