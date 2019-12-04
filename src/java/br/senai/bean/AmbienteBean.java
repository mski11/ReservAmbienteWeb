package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.ItemDAO;
import br.senai.dao.PedidoReservaDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import br.senai.model.Pedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

@SessionScoped
@ManagedBean(name="ambienteBean")
public class AmbienteBean {
    
 /* --------------------------------- Atributos ----------------------------- */
    
    /* Usado para CRUD's relacionados aos ambientes. */
    private AmbienteDAO ambienteDAO = new AmbienteDAO();
    
    /* Usado para CRUD's relacionados aos itens de ambientes. */
    private ItemDAO itensDAO = new ItemDAO();
    
    /* Usado para CRUD's relacionados aos pedidos de reserva. */
    private PedidoReservaDAO pedidosDAO = new PedidoReservaDAO();
    
    /* Lista receptora do método buscarAmbientes do AmbienteDAO. */
    private List<Ambiente> ambientes = new ArrayList();
    
    /* Lista receptora do método buscarPedidosUsuário do pedidosDAO. */
    private List<Pedido> pedidosUsuario = new ArrayList();
    
    /*
    *   Lista que recebe itens e guarda-os em sessão no bean
    *   para depois inserir estes no banco de dados com a
    *   confirmação de criação de um novo ambiente.
    */
    private List<Item> itensNovoAmbiente = new ArrayList();
    
    /*  
    *   LoginBean importado para uso das informações
    *   do usuário em funções deste Bean.
    */
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanImportado;
    
    /* Recebe nome do ambiente no momento da criação. */
    private Ambiente ambiente = new Ambiente();
    
    /* Usado para criação de novos itens para criação e edição de ambientes. */
    private Item item = new Item();
    
    /* Usado para resgatar valores de um ambiente selecionado em dataTables. */
    private  Ambiente ambienteSelecionado;
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    /*
    *   Método preRenderView da página editarAmbiente.jsf
    *   usado para popular a dataTable presente na página.
    */
    public void PRVEditAmbiente(){
        if(loginBeanImportado.infoUser != null){
            if(loginBeanImportado.infoUser.isMestre()){
            ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
        }
    }
    
    /*
    *   Método preRenderView da página VisualisarAmbientes.jsf
    *   usado para popular a dataTable presente na página.
    */
    public void PRVVisualizarAmbientes(){
        if(loginBeanImportado.infoUser != null){
            if(loginBeanImportado.infoUser.isMestre()){
                ambientes = ambienteDAO.buscarAmbientes();
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
        }
    }
    
    /*
    *   Método preRenderView da página criarAmbiente.jsf
    *   usado para evitar que usuários normais acessem a página.
    */
    public void PRVCriarAmbiente(){
        if(loginBeanImportado.infoUser != null){
            if(!loginBeanImportado.infoUser.isMestre()){
                redirectMainUsuario();
            } 
        } else {
            redirectLogin();
        }
    }
    
    
    /*
    *   Método preRenderView da página mainUsuario.jsf usado para popular
    *   a dataTable presente na página.
    */
    public void PRVmainUsuario(){
        if(loginBeanImportado.infoUser != null){
            ambientes = ambienteDAO.buscarAmbientes();
            pedidosUsuario = pedidosDAO.buscarPedidosUsuario(loginBeanImportado.infoUser);
        } else {
            redirectLogin();
        }
    }
    
    
    
    /*
    *   Método preRenderView da página reservarAmbientes.jsf usado para popular
    *   a dataTable presente na página.
    */
    public void PRVreservarAmbientes(){
        if(loginBeanImportado.infoUser != null){
            if(ambienteSelecionado != null){
            ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
            } else {
                redirectMainUsuario();
            }
        } else {
            redirectLogin();
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
    *   Função de redirecionamento de página para
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
    *   Função de redirecionamento de página para
    *   a página VisualisarAmbientes.jsf
    */
    public void redirectVisualisarAmbientes(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("VisualisarAmbientes.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ReservaAmbienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /*
    *   Função que faz a busca por ambientes registrados no sistema.
    *   A lista receptora é usada para impressão em dataTables.
    */
    public void buscarAmbiente(){
        ambientes = ambienteDAO.buscarAmbientes();
    }
    
    /*
    *   Função que adiciona itens temporariamente na lista itensNovoAmbiente
    *   para registro posterior de um novo ambiente no banco de dados.
    */
    public void adicionarItemNovoAmbiente(){
        itensNovoAmbiente.add(item);
        item = new Item();
    }
    
    /*
    *   Função que remove itens da lista itensNovoAmbiente para registro 
    *   posterior de um novo ambiente no banco de dados.
    */
    public void deletarItemNovoAmbiente(Item item){
        itensNovoAmbiente.remove(item);
    }
    
    /*
    *   Função que define itensAmbiente de ambiente e depois usa este para
    *   registro de um novo ambiente e seus itens no banco de dados.
    */
    public void criarAmbiente(){
        ambiente.setItensAmbiente(itensNovoAmbiente);
        ambienteDAO.criarAmbiente(ambiente);
        itensDAO.inserirItemNovoAmbiente(ambiente);
    }
    
    /*
    *   Função que busca itensAmbiente de ambienteSelecionado.
    *   Usada para preencher dataTables.
    */
    public void buscarItensAmbienteSelecionado(){
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
    }
    
    /*
    *   Função usada pelo administrador para excluir itens
    *    de ambientes registradosno sistema. 
    */
    public void deletarItem(Item item){
        itensDAO.excluirItem(item.getIdItem());
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
    }
    
    /*
    *   Método usado para adicionar novos itens em ambientes já criados
    */
    public void adicionarItem(){
        itensDAO.inserirItem(item, ambienteSelecionado.getIdAmbiente());
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
    }
    
    /*
    *   Método usado para display de FacesMessage quando
    *   itens forem editados na criação de um novo ambiente.
    *   @param event - evento de edição do valor do item inserido na tabela.
    */
    public void onCellEditNovoAmbiente(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item editado com sucesso!", "Valor antigo: " + oldValue + ", Novo valor:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */

    public LoginBean getLoginBeanImportado() {
        return loginBeanImportado;
    }

    public void setLoginBeanImportado(LoginBean loginBeanImportado) {
        this.loginBeanImportado = loginBeanImportado;
    }


    
    public PedidoReservaDAO getPedidosDAO() {
        return pedidosDAO;
    }

    public void setPedidosDAO(PedidoReservaDAO pedidosDAO) {
        this.pedidosDAO = pedidosDAO;
    }

    public List<Pedido> getPedidosUsuario() {
        return pedidosUsuario;
    }

    public void setPedidosUsuario(List<Pedido> pedidosUsuario) {
        this.pedidosUsuario = pedidosUsuario;
    }
    
    public List<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(List<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    public Ambiente getAmbienteSelecionado() {
        return ambienteSelecionado;
    }

    public void setAmbienteSelecionado(Ambiente ambienteSelecionado) {
        this.ambienteSelecionado = ambienteSelecionado;
    }
    
    public AmbienteDAO getAmbienteDAO() {
        return ambienteDAO;
    }

    public void setAmbienteDAO(AmbienteDAO ambienteDAO) {
        this.ambienteDAO = ambienteDAO;
    }

    public ItemDAO getItensDAO() {
        return itensDAO;
    }

    public void setItensDAO(ItemDAO itensDAO) {
        this.itensDAO = itensDAO;
    }
    
    public List<Item> getItensAmbiente() {
        return itensNovoAmbiente;
    }

    public void setItensAmbiente(List<Item> itensAmbiente) {
        this.itensNovoAmbiente = itensAmbiente;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
 /* --------------------------------- Fim de Getters e Setters -------------- */
    
}
