/*
    Esse é o bean que gerencia as ações executadas
    pela página registrarUsuarios.jsf, fazendo
    chamados ao pedidoRegistroDAO
*/

package br.senai.bean;

import br.senai.dao.pedidoRegistroDAO;
import br.senai.dao.usuarioDAO;
import br.senai.model.PedidoRegistro;
import br.senai.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroUsuarioBean {
    
 // PedidosDAO importa todos pedidos do sistema para que o admin visualize-os.
    pedidoRegistroDAO PedidosDAO = new pedidoRegistroDAO();
    
 // novoUsuarioDAO registra novos usuários no sistema.
    usuarioDAO novoUsuarioDAO = new usuarioDAO();
    
    // Tem que chamar a função que retorna o array do ResultSet!!!!!!!!! <--- Anotação p mim mesmo ke

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
