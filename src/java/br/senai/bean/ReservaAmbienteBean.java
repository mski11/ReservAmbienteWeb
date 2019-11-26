package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.PedidoReservaDAO;
import br.senai.dao.UserDAO;
import br.senai.model.Ambiente;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ReservaAmbienteBean {
    
 /* --------------------------------- Atributos ----------------------------- */
    
    private UserDAO usuarioDAO = new UserDAO();
    private AmbienteDAO ambienteDAO = new AmbienteDAO();
    private PedidoReservaDAO pedidoDAO = new PedidoReservaDAO();
    
    private Ambiente ambienteSelecionado = new Ambiente();
    private Usuario userInfo = new Usuario();
    private Pedido PedidoReserva = new Pedido();
    
    @ManagedProperty(value = "#{ambienteBean}")
    private AmbienteBean ambienteBeanImportado = new AmbienteBean();
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean usuarioBeanImportado = new LoginBean();
    
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    
    
 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */
    
    public UserDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UserDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public AmbienteDAO getAmbienteDAO() {
        return ambienteDAO;
    }

    public void setAmbienteDAO(AmbienteDAO ambienteDAO) {
        this.ambienteDAO = ambienteDAO;
    }

    public PedidoReservaDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoReservaDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Ambiente getAmbienteSelecionado() {
        return ambienteSelecionado;
    }

    public void setAmbienteSelecionado(Ambiente ambienteSelecionado) {
        this.ambienteSelecionado = ambienteSelecionado;
    }

    public Usuario getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Usuario userInfo) {
        this.userInfo = userInfo;
    }

    public Pedido getPedidoReserva() {
        return PedidoReserva;
    }

    public void setPedidoReserva(Pedido PedidoReserva) {
        this.PedidoReserva = PedidoReserva;
    }

    public AmbienteBean getAmbienteBeanImportado() {
        return ambienteBeanImportado;
    }

    public void setAmbienteBeanImportado(AmbienteBean ambienteBeanImportado) {
        this.ambienteBeanImportado = ambienteBeanImportado;
    }

    public LoginBean getUsuarioBeanImportado() {
        return usuarioBeanImportado;
    }

    public void setUsuarioBeanImportado(LoginBean usuarioBeanImportado) {
        this.usuarioBeanImportado = usuarioBeanImportado;
    }
    
 /* --------------------------------- Fim de Getters e Setters --------------- */
    
}
