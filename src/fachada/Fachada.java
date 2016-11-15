/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import bicicleta.Bicicleta;
import bicicleta.BicicletaInterface;
import bicicleta.BicicletaNegocio;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Fachada implements BicicletaInterface {

    @Override
    public void inserir(Bicicleta b) throws Exception {
        BicicletaNegocio negocio = new BicicletaNegocio();
        negocio.inserir(b);
    }

    @Override
    public void atualizar(Bicicleta b) throws Exception {
        BicicletaNegocio negocio = new BicicletaNegocio();
        negocio.atualizar(b);
    }

    @Override
    public void remover(Bicicleta b) throws Exception {
        BicicletaNegocio negocio = new BicicletaNegocio();
        negocio.remover(b);
    }

    @Override
    public ArrayList<Bicicleta> listar(Bicicleta filtro) throws Exception {
        BicicletaNegocio negocio = new BicicletaNegocio();
        return negocio.listar(filtro);
    }

    @Override
    public boolean verificarBicicleta(Bicicleta b) throws Exception {
        BicicletaNegocio negocio = new BicicletaNegocio();
        return negocio.verificarBicicleta(b);
    }

}
