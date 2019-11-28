package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.PedidoReservaDAO;
import br.senai.dao.UserDAO;
import br.senai.model.Pedido;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
    
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    public void enviarPedidoReserva(){
        
       // LocalDate currentdate = LocalDate.now();
       Date data = new Date();
        
        
        
        pedidoReserva.setDiaPedido(data);
        pedidoReserva.setIdUsuario(usuarioBeanImportado.infoUser.getIdUsuario());
        pedidoReserva.setIdAmbiente(ambienteBeanImportado.getAmbienteSelecionado().getIdAmbiente());
        
        pedidoDAO.criarPedido(ambienteBeanImportado.getAmbienteSelecionado(), pedidoReserva, usuarioBeanImportado.getInfoUser());
        
    }
    
 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */
    
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
