package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.usuarioDAO;
import br.senai.model.PedidoRegistro;
import br.senai.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    PedidoRegistro pedidoRegistro = new PedidoRegistro();
    pedidoRegistroDAO pr = new pedidoRegistroDAO();
    
    Usuario infoUser = new Usuario();
    usuarioDAO userDAO = new usuarioDAO();
    
    public String logar(){
        
        infoUser = userDAO.loginCheck(infoUser);
       
        if(infoNova != null){
            infoUser = infoNova;
            if(infoUser.isMestre()){
                return "visualisarReservas.jsf";
            } else {
                return "mainUsuario.jsf";
            }
        } else {
            return "Login.jsf";
        }
    }
    
    
    public void salvar(){
        pr.salvar(pedidoRegistro);
    }
    
    public String conectar(){
        return pr.conectar();
    }

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

    public Usuario getInfoUsuario() {
        return infoUsuario;
    }

    public void setInfoUsuario(Usuario infoUsuario) {
        this.infoUsuario = infoUsuario;
    }

    public usuarioDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(usuarioDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
    
}
