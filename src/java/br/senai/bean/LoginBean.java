package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    pedidoRegistroDAO pr = new pedidoRegistroDAO();

    public String conectar(){
        return pr.conectar();
    }
}
