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
    
    Usuario infoUsuario = new Usuario();
    usuarioDAO userDAO = new usuarioDAO();
    
    public void logar(){
        /*if(userDAO.loginCheck(infoUsuario) == "erro"){
            n faço ideia???
        }*/
        /* if(userDAO.loginCheck(infoUsuario) == "user"){
            // manda p pg de usuario
        } */
        if(userDAO.loginCheck(infoUsuario) == "adm"){
            // Redireciona pra pag de adm
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
    
    
    
}
