package categoria;

import fachada.Fachada;
import java.util.ArrayList;

public class CategoriaNegocio implements CategoriaInterface {

    private void validarCampos(Categoria c) throws Exception {
        if (c.getDescricao().equals("")) {
            throw new Exception("Nome inválido.");
        }
    }
    
    @Override
    public void inserir(Categoria c) throws Exception {
        Fachada fachada = new Fachada();

        if (c.getCodigo() < 1) {
            throw new Exception("Código inválido.");
        }

        validarCampos(c);

        ArrayList<Categoria> existencia = fachada.listar(c);
        if (!existencia.isEmpty()) {
            throw new Exception("Categoria existente.");
        }

        CategoriaDados dados = new CategoriaDados();
        dados.inserir(c);
    }

    @Override
    public void atualizar(Categoria c) throws Exception {
        validarCampos(c);

        CategoriaDados dados = new CategoriaDados();
        dados.atualizar(c);
    }

    @Override
    public void remover(Categoria c) throws Exception {
        CategoriaDados dados = new CategoriaDados();
        dados.remover(c);
    }

    @Override
    public ArrayList<Categoria> listar(Categoria filtro) throws Exception {
        CategoriaDados dados = new CategoriaDados();
        return dados.listar(filtro);
    }

}
