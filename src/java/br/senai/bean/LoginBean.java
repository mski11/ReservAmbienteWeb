package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.model.PedidoRegistro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    PedidoRegistro pedidoRegistro = new PedidoRegistro();
    pedidoRegistroDAO pr = new pedidoRegistroDAO();
    
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
