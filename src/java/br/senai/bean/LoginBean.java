package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.UserDAO;
import br.senai.model.PedidoRegistro;
import br.senai.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    PedidoRegistro pedidoRegistro = new PedidoRegistro();
    pedidoRegistroDAO pr = new pedidoRegistroDAO();
    
    Usuario userLoginInput = new Usuario();
    Usuario infoUser = new Usuario();
    
    UserDAO userDAO = new UserDAO();
    
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
    
    
    
}
