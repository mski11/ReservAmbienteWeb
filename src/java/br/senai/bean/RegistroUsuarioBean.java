/*
    Esse é o bean que gerencia as ações executadas
    pela página registrarUsuarios.jsf, fazendo
    chamados ao pedidoRegistroDAO
*/

package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.UserDAO;
import br.senai.model.PedidoRegistro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.tomcat.util.http.fileupload.RequestContext;

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
    
    /* LoginBean importado para uso em funções relacionadas ao usuario. */
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanImportado;
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    /*
    *   Método preRenderView da página registrarUsuarios.jsf
    *   usado para popular a dataTable presente na página.
    */
    public void PRVPedidosRegistro(){
        if(loginBeanImportado.infoUser != null){
            if(loginBeanImportado.infoUser.isMestre()){
                arrayPedidos = PedidosDAO.buscarPedidos();
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
        }
    }
    
    
    /*
    *   Método usado para aceitar pedidos de registro,
    *   registrando um novo usuário e excluindo o pedido.
    */
    public void aceitar(){
        novoUsuarioDAO.registrarUsuario(pedidoSelecionado.getIdPedido());
        PedidosDAO.excluirPedido(pedidoSelecionado.getIdPedido());
        metodoBuscar();
    }
    
    /*
    *   Método usado para negar e excluir pedidos de registro.
    */
    public void negar(){
        PedidosDAO.excluirPedido(pedidoSelecionado.getIdPedido());
        metodoBuscar();
    }
    
    /*
    *   Método usado para popular a dataTable
    *   da página registrarUsuarios.jsf.
    */
    public void metodoBuscar(){
        arrayPedidos = PedidosDAO.buscarPedidos();
    }
    
    /*
    *   Função de redirecionamento de página para
    *   a página mainUsuario.jsf
    */
    public void redirectMainUsuario(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainUsuario.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    *   Função de redirecionamento de página para
    *   a página Login.jsf
    */
    public void redirectLogin(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    

 /* --------------------------------- Fim de métodos ------------------------ */


 /* --------------------------------- Getters e Setters --------------------- */    

    public LoginBean getLoginBeanImportado() {
        return loginBeanImportado;
    }

    public void setLoginBeanImportado(LoginBean loginBeanImportado) {
        this.loginBeanImportado = loginBeanImportado;
    }
    
    
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
