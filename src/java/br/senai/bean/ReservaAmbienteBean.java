package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.PedidoReservaDAO;
import br.senai.dao.UserDAO;
import br.senai.model.Ambiente;
import br.senai.model.Pedido;
import br.senai.model.Usuario;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
    
    private Pedido pedidoReserva = new Pedido();
    
    @ManagedProperty(value = "#{ambienteBean}")
    private AmbienteBean ambienteBeanImportado = new AmbienteBean();
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean usuarioBeanImportado = new LoginBean();
    
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    public void enviarPedidoReserva(){
        
       // LocalDate currentdate = LocalDate.now();
       // Date data = new Date();
        
        
        
        //pedidoReserva.setDiaPedido(data);
        pedidoReserva.setIdUsuario(usuarioBeanImportado.infoUser.getIdUsuario());
        pedidoReserva.setIdAmbiente(ambienteBeanImportado.getAmbienteSelecionado().getIdAmbiente());
        
        pedidoDAO.criarPedido(ambienteBeanImportado.getAmbienteSelecionado(), pedidoReserva, usuarioBeanImportado.getInfoUser());
        
    }
    
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
