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
    
 /* --------------------------------- Atributos ----------------------------- */
    
    /* 
    *   PedidosDAO é usado para importar todos pedidos do
    *   sistema para que o admin visualize-os.
    */
    private pedidoRegistroDAO PedidosDAO = new pedidoRegistroDAO();
    
    /* Usado para registrar novos usuários no sistema. */    
    private UserDAO novoUsuarioDAO = new UserDAO();
    
    /* Lista receptora do método buscarPedidos do PedidoRegistroDAO */
    private List<PedidoRegistro> arrayPedidos = new ArrayList<>();
    
    /* Usado para resgatar valores de um pedido selecionado em dataTables */
    private PedidoRegistro pedidoSelecionado;
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    /*
    *   Método preRenderView da página registrarUsuarios.jsf
    *   usado para popular a dataTable presente na página.
    */
    public void PRVPedidosRegistro(){
        arrayPedidos = PedidosDAO.buscarPedidos();
    }
    
    
    /*
    *   Método usado para aceitar pedidos de registro
    *   e registrar novos usuários no sistema.
    */
    public void aceitar(){
        novoUsuarioDAO.registrarUsuario(pedidoSelecionado.getIdPedido());
    }

 /* --------------------------------- Fim de métodos ------------------------ */


 /* --------------------------------- Getters e Setters --------------------- */    
    
    public PedidoRegistro getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    public void setPedidoSelecionado(PedidoRegistro pedidoSelecionado) {
        this.pedidoSelecionado = pedidoSelecionado;
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
    
 /* --------------------------------- Fim de Getters e Setters -------------- */

}
