package bicicleta;

import java.util.ArrayList;

public class BicicletaNegocio implements BicicletaInterface {

    @Override
    public void inserir(Bicicleta b) throws Exception {
        if (b.getCodigo() < 1) {
            throw new Exception("Codigo inválido.");
        }

        if (b.getFabricante().getCnpj().length() < 18) {
            throw new Exception("Fabricante inválido.");
        }

        if (b.getCategoria().getCodigo() < 1) {
            throw new Exception("Categoria inválida.");
        }

        if (b.getDescricao().equals("")) {
            throw new Exception("Descrição inválida.");
        }

        if (b.getAno().length() < 4) {
            throw new Exception("Ano ivánlido ");
        }

        if (b.getCor().equals("")) {
            throw new Exception("Cor inválida.");
        }

        if (b.getPneu().equals("")) {
            throw new Exception("Pneu inválido.");
        }

        BicicletaDados dados = new BicicletaDados();
        dados.inserir(b);
    }

    @Override
    public void atualizar(Bicicleta b) throws Exception {
        if (b.getDescricao().equals("")) {
            throw new Exception("Descrição inválida.");
        }

        if (b.getAno().length() < 4) {
            throw new Exception("Ano ivánlido ");
        }

        if (b.getCor().equals("")) {
            throw new Exception("Cor inválida.");
        }

        if (b.getPneu().equals("")) {
            throw new Exception("Pneu inválido.");
        }

        BicicletaDados dados = new BicicletaDados();
        dados.atualizar(b);
    }

    @Override
    public void remover(Bicicleta b) throws Exception {
        if (b.getCodigo() < 1) {
            throw new Exception("Codigo inválido.");
        }

        BicicletaDados dados = new BicicletaDados();
        dados.remover(b);
    }

    @Override
    public ArrayList<Bicicleta> listar(Bicicleta filtro) throws Exception {
        BicicletaDados dados = new BicicletaDados();
        return dados.listar(filtro);
    }

    @Override
    public boolean verificarBicicleta(Bicicleta b) throws Exception {
        if (b.getCodigo() < 1) {
            throw new Exception("Codigo inválido.");
        }

        BicicletaDados dados = new BicicletaDados();
        return dados.verificarBicicleta(b);
    }

}
