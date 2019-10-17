/*
    Esse é o bean que gerencia as ações executadas
    pela página registrarUsuarios.jsf, fazendo
    chamados ao pedidoRegistroDAO
*/

package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.usuarioDAO;

public class RegistroUsuarioBean {
    
 // PedidosDAO importa todos pedidos do sistema para que o admin visualize-os.
    pedidoRegistroDAO PedidosDAO = new pedidoRegistroDAO();
    
 // novoUsuarioDAO registra novos usuários no sistema.
    usuarioDAO novoUsuarioDAO = new usuarioDAO();
    
    

    public pedidoRegistroDAO getPedidosDAO() {
        return PedidosDAO;
    }

    public void setPedidosDAO(pedidoRegistroDAO PedidosDAO) {
        this.PedidosDAO = PedidosDAO;
    }

    public usuarioDAO getNovoUsuarioDAO() {
        return novoUsuarioDAO;
    }

    public void setNovoUsuarioDAO(usuarioDAO novoUsuarioDAO) {
        this.novoUsuarioDAO = novoUsuarioDAO;
    }
    
}
