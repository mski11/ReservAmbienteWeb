package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.PedidoReservaDAO;
import br.senai.dao.UserDAO;
import br.senai.model.Pedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ReservaAmbienteBean {
    
 /* --------------------------------- Atributos ----------------------------- */    
    
    /* Usado para criar, buscar, aceitar e negar pedidos  de reserva. */
    private PedidoReservaDAO pedidoDAO = new PedidoReservaDAO();
    
    /* Objeto usado para criar novos pedidos de reserva. */
    private Pedido pedidoReserva = new Pedido();
    
    
    @ManagedProperty(value = "#{ambienteBean}")
    private AmbienteBean ambienteBeanImportado = new AmbienteBean();
    
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean usuarioBeanImportado = new LoginBean();
    
    private List<Pedido> pedidosPendentes = new ArrayList();
    private List<Pedido> pedidosRevisados = new ArrayList();
    
    private Pedido pedidoSelecionado = new Pedido();
    
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    public void PRVVisualizarReservas(){
        pedidosPendentes = pedidoDAO.buscarPedidosPendentes();
        pedidosRevisados = pedidoDAO.buscarPedidosRevisados();
    }
    
    public void redirectReservarAmbientes(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("reservarAmbientes.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void redirectMainUsuario(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainUsuario.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void enviarPedidoReserva(){
        pedidoReserva.setIdUsuario(usuarioBeanImportado.infoUser.getIdUsuario());
        pedidoReserva.setIdAmbiente(ambienteBeanImportado.getAmbienteSelecionado().getIdAmbiente());
        pedidoDAO.criarPedido(ambienteBeanImportado.getAmbienteSelecionado(), pedidoReserva, usuarioBeanImportado.getInfoUser());
    }
    
    public void pedidoRealizadoMsg() {
        addMessage("Concluído", "Pedido de reserva realizado com sucesso.");
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    

    
    public void aceitarPedido(){
        pedidoSelecionado.setRespostaMestre("Seu pedido foi aceito! Nos vêmos lá. ;)");
        pedidoDAO.responderPedido(pedidoSelecionado);
    }
    
    public void negarPedido(){
        pedidoDAO.responderPedido(pedidoSelecionado);
    }
    
 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */

    public Pedido getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    public void setPedidoSelecionado(Pedido pedidoSelecionado) {
        this.pedidoSelecionado = pedidoSelecionado;
    }    

    public List<Pedido> getPedidosPendentes() {
        return pedidosPendentes;
    }

    public void setPedidosPendentes(List<Pedido> pedidosPendentes) {
        this.pedidosPendentes = pedidosPendentes;
    }

    public List<Pedido> getPedidosRevisados() {
        return pedidosRevisados;
    }

    public void setPedidosRevisados(List<Pedido> pedidosRevisados) {
        this.pedidosRevisados = pedidosRevisados;
    }
    
    
    
    public PedidoReservaDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoReservaDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Pedido getPedidoReserva() {
        return pedidoReserva;
    }

    public void setPedidoReserva(Pedido pedidoReserva) {
        this.pedidoReserva = pedidoReserva;
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
