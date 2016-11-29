package bicicleta;

import java.util.ArrayList;

public interface BicicletaInterface {

    //inserir bicicleta no banco de dados
    void inserir(Bicicleta b) throws Exception;

    //atualizar bicicleta no banco de dados
    void atualizar(Bicicleta b) throws Exception;

    // remover bicicleta no banco de dados
    void remover(Bicicleta b) throws Exception;

    // listar bicicleta no banco de dadoss
    ArrayList<Bicicleta> listar(Bicicleta filtro) throws Exception;

}
