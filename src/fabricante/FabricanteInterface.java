package fabricante;

import java.util.ArrayList;

public interface FabricanteInterface {

    void inserir(Fabricante f) throws Exception;

    void atualizar(Fabricante f) throws Exception;

    void remover(Fabricante f) throws Exception;

    ArrayList<Fabricante> listar(Fabricante filtro) throws Exception;
    
}
