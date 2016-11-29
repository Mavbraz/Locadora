/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import bicicleta.Bicicleta;
import bicicleta.BicicletaInterface;
import bicicleta.BicicletaNegocio;
import categoria.Categoria;
import categoria.CategoriaInterface;
import categoria.CategoriaNegocio;
import fabricante.Fabricante;
import fabricante.FabricanteInterface;
import fabricante.FabricanteNegocio;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Fachada implements BicicletaInterface, FabricanteInterface, CategoriaInterface {

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
    public void inserir(Fabricante f) throws Exception {
        FabricanteNegocio negocio = new FabricanteNegocio();
        negocio.inserir(f);
    }

    @Override
    public void atualizar(Fabricante f) throws Exception {
        FabricanteNegocio negocio = new FabricanteNegocio();
        negocio.atualizar(f);
    }

    @Override
    public void remover(Fabricante f) throws Exception {
        FabricanteNegocio negocio = new FabricanteNegocio();
        negocio.remover(f);
    }

    @Override
    public ArrayList<Fabricante> listar(Fabricante filtro) throws Exception {
        FabricanteNegocio negocio = new FabricanteNegocio();
        return negocio.listar(filtro);
    }

    @Override
    public void inserir(Categoria c) throws Exception {
        CategoriaNegocio negocio = new CategoriaNegocio();
        negocio.inserir(c);
    }

    @Override
    public void atualizar(Categoria c) throws Exception {
        CategoriaNegocio negocio = new CategoriaNegocio();
        negocio.atualizar(c);
    }

    @Override
    public void remover(Categoria c) throws Exception {
        CategoriaNegocio negocio = new CategoriaNegocio();
        negocio.remover(c);
    }

    @Override
    public ArrayList<Categoria> listar(Categoria filtro) throws Exception {
        CategoriaNegocio negocio = new CategoriaNegocio();
        return negocio.listar(filtro);
    }

}
