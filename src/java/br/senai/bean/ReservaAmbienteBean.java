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
    
    /* AmbienteBean importado para uso em funções relacionadas aos ambientes. */
    @ManagedProperty(value = "#{ambienteBean}")
    private AmbienteBean ambienteBeanImportado = new AmbienteBean();
    
    /* LoginBean importado para uso em funções relacionadas ao usuario. */
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanImportado;
    
    /* 
    *   DataTables receptoras dos métodos buscarPedidosPendentes e
    *   buscarPedidosRevisados do PedidoReservaDAO.
    */
    private List<Pedido> pedidosPendentes = new ArrayList();
    private List<Pedido> pedidosRevisados = new ArrayList();
    
    /* 
    *   Objeto Pedido que armazena informações do
    *   pedido de reserva selecionado.
    */
    private Pedido pedidoSelecionado = new Pedido();
    
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    /*
    *   Método preRenderView que popula as dataTables em
    *   visualisarReservas.jsf antes do carregamento da view.
    */
    public void PRVVisualizarReservas(){
        if(loginBeanImportado.infoUser != null){
            if(loginBeanImportado.infoUser.isMestre()){
            pedidosPendentes = pedidoDAO.buscarPedidosPendentes();
            pedidosRevisados = pedidoDAO.buscarPedidosRevisados();
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
        }
    }
    
    /*
    *   Método de redirecionamento de página para
    *   a página mainUsuario.jsf
    */
    public void redirectReservarAmbientes(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("reservarAmbientes.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
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
    *   Método de redirecionamento de página para
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
    *   Método usado para criar um novo pedido de reserva de ambiente
    *   baseado no ID do usuário logado, ID do ambiente selecionado e
    *   informações inseridas na página reservarAmbientes.jsf.
    */
    public void enviarPedidoReserva(){
        pedidoReserva.setIdUsuario(loginBeanImportado.infoUser.getIdUsuario());
        pedidoReserva.setIdAmbiente(ambienteBeanImportado.getAmbienteSelecionado().getIdAmbiente());
        pedidoDAO.criarPedido(ambienteBeanImportado.getAmbienteSelecionado(), pedidoReserva, loginBeanImportado.getInfoUser());
    }

    /*
    *   Método usado para aceitar um pedido de reserva
    *   na página visualisarReservas.jsf
    */
    public void aceitarPedido(){
        pedidoSelecionado.setRespostaMestre("Seu pedido foi aceito! Nos vêmos lá. ;)");
        pedidoDAO.responderPedido(pedidoSelecionado);
    }
    
    /*
    *   Método usado para negar um pedido de
    *   reserva selecionado.
    */    
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

     public LoginBean getLoginBeanImportado() {
        return loginBeanImportado;
    }

    public void setLoginBeanImportado(LoginBean loginBeanImportado) {
        this.loginBeanImportado = loginBeanImportado;
    }
    
 /* --------------------------------- Fim de Getters e Setters --------------- */

   
    
}
