package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.UserDAO;
import br.senai.model.PedidoRegistro;
import br.senai.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    
 /* ------------------------------- Atributos ------------------------------- */
    /*
    *   Objeto usado para criação de novos pedidos de
    *   registro baseados nas informações inseridas pelo usuário.
    */  
    PedidoRegistro pedidoRegistro = new PedidoRegistro();
    
    /* Usado para CRUD's relacionados a Pedidos de registro */
    pedidoRegistroDAO pr = new pedidoRegistroDAO();
    
    /* Usado para checagem de login com a função loginCheck do UserDAO. */
    Usuario userLoginInput = new Usuario();
    
    /* Objeto usuario que armazena informações do usuário logado */
    Usuario infoUser;
    
    /* Usado para CRUD's relacionados ao usuário */
    UserDAO userDAO = new UserDAO();
    
    /* Lista que popula a dataTable presente em visualisarUsuarios.jsf */
    List listUsuarios = new ArrayList();
    
    /*  
    *   Objeto usuário que recebe informações do usuário selecionado   
    *   na página visualisarUsuarios.jsf
    */
    Usuario usuarioSelecionado = new Usuario();
    
 /* --------------------------------- Fim de atributos ---------------------- */

    
 /* --------------------------------- Métodos ------------------------------- */
    
     /*
    *   Método preRenderView que popula a dataTable em
    *   Login.jsf antes do carregamento da view.
    */
    public void PRVLogin(){
        pedidoRegistro = new PedidoRegistro();
    }
    
    /*
    *   Método preRenderView que popula a dataTable em
    *   visualizarUsuarios.jsf antes do carregamento da view.
    */
    public void PRVVisualizarUsuarios(){
        if(infoUser != null){
            if(infoUser.isMestre()){
                listUsuarios = userDAO.buscarUsuarios();
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
        }
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
    
    /*
    *   Método usado para logar o usuário baseado na
    *   permissão de sua conta.
    */
    public void login(){
        infoUser = userDAO.loginCheck(userLoginInput);
        try {
            if(infoUser != null){
                
                if(infoUser.isMestre()){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("visualisarReservas.jsf");
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("mainUsuario.jsf");
                }
            } else {
                // Mensagem de erro dizendo ao usuário que inseriu dados errados/inexistentes!
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    *   Método usado para banir usuários
    *   do sistema.
    */
    public void banirUsuario(){
        userDAO.excluir(usuarioSelecionado);
        buscarUsuarios();
    }
    
    /*  
    *   Método usado para buscar usuários e preencher
    *   a dataTable presente em visualizarUsuarios.jsf
    */
    public void buscarUsuarios(){
        listUsuarios = userDAO.buscarUsuarios();
    }
    
    /* Método usado para salvar um novo pedido de registro no sistema */
    public void salvar(){
        pr.salvar(pedidoRegistro);
    }
    
    /*
    *   Método usado para deslogar usuário do sistema e mandá-lo
    *   de volta à página Login.jsf
    */
    public void deslogar(){
        infoUser = new Usuario();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */
    
    public PedidoRegistro getPedidoRegistro() {
        return pedidoRegistro;
    }

    public void setPedidoRegistro(PedidoRegistro pedidoRegistro) {
        this.pedidoRegistro = pedidoRegistro;
    }

    public pedidoRegistroDAO getPr() {
        return pr;
    }

    public void setPr(pedidoRegistroDAO pr) {
        this.pr = pr;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Usuario getUserLoginInput() {
        return userLoginInput;
    }

    public void setUserLoginInput(Usuario userLoginInput) {
        this.userLoginInput = userLoginInput;
    }

    public Usuario getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(Usuario infoUser) {
        this.infoUser = infoUser;
    }
    
    public List getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
    
     public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
        
 /* --------------------------------- Fim de Getters e Setters -------------- */
    
}
