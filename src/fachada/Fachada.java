package fachada;

import cliente.Cliente;
import cliente.ClienteInterface;
import cliente.ClienteNegocio;
import nota.Nota;
import nota.NotaInterface;
import nota.NotaNegocio;

public class Fachada implements ClienteInterface, NotaInterface {

    @Override
    public void inserir(Cliente c) throws Exception {
        ClienteNegocio negocioC = new ClienteNegocio();
        negocioC.inserir(c);
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        ClienteNegocio negocioC = new ClienteNegocio();
        negocioC.atualizar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {
        ClienteNegocio negocioC = new ClienteNegocio();
        negocioC.remover(c);
    }

    @Override
    public boolean verificarCliente(Cliente c) throws Exception {
        ClienteNegocio negocioC = new ClienteNegocio();
        return negocioC.verificarCliente(c);
    }

    @Override
    public void inserir(Nota n) throws Exception {
        NotaNegocio negocioN = new NotaNegocio();
        negocioN.inserir(n);
    }

    @Override
    public void atualizar(Nota n) throws Exception {
        NotaNegocio negocioN = new NotaNegocio();
        negocioN.atualizar(n);
    }

    @Override
    public void remover(Nota n) throws Exception {
        NotaNegocio negocioN = new NotaNegocio();
        negocioN.remover(n);
    }

    @Override
    public boolean verificarNota(Nota n) throws Exception {
        NotaNegocio negocioN = new NotaNegocio();
        return negocioN.verificarNota(n);
    }
}
