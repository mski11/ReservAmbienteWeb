/*
    Esse é o bean que gerencia as ações executadas
    pela página registrarUsuarios.jsf, fazendo
    chamados ao pedidoRegistroDAO
*/

package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.UserDAO;
import br.senai.model.PedidoRegistro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegistroUsuarioBean {
    
 // PedidosDAO importa todos pedidos do sistema para que o admin visualize-os.
    private pedidoRegistroDAO PedidosDAO = new pedidoRegistroDAO();
    
 // novoUsuarioDAO registra novos usuários no sistema.
    private UserDAO novoUsuarioDAO = new UserDAO();
    
    
    private List<PedidoRegistro> arrayPedidos = new ArrayList<>();
    private PedidoRegistro pedidoSelecionado;
    
    public void aceitar(){
        novoUsuarioDAO.registrarUsuario(pedidoSelecionado.getIdPedido());
    }

    public PedidoRegistro getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    public void setPedidoSelecionado(PedidoRegistro pedidoSelecionado) {
        this.pedidoSelecionado = pedidoSelecionado;
    }
        
    public void metodoBuscar(){
        arrayPedidos = PedidosDAO.buscarPedidos();
    }
    
    public pedidoRegistroDAO getPedidosDAO() {
        return PedidosDAO;
    }

    public void setListaPedidos(List<PedidoRegistro> listaPedidos) {
        this.arrayPedidos = listaPedidos;
    }
    
    public void setPedidosDAO(pedidoRegistroDAO PedidosDAO) {
        this.PedidosDAO = PedidosDAO;
    }

    public UserDAO getNovoUsuarioDAO() {
        return novoUsuarioDAO;
    }

    public void setNovoUsuarioDAO(UserDAO novoUsuarioDAO) {
        this.novoUsuarioDAO = novoUsuarioDAO;
    }

    public List<PedidoRegistro> getArrayPedidos() {
        return arrayPedidos;
    }  
}
