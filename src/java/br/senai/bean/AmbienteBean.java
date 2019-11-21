package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.ItemDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

@SessionScoped
@ManagedBean
public class AmbienteBean {
    
    /* ----------------------------- Atributos ---------------------------- */
    
    private AmbienteDAO ambienteDAO = new AmbienteDAO();
    
    /*  Neste Bean, o itensDAO é utilizado somente na hora
    *   de criar um novo ambiente. Todas outras funções relacionadas
    *   à itens deveriam ser feitas em ItemBean.
    */
    private ItemDAO itensDAO = new ItemDAO();
    
    /* Lista receptora do método buscarAmbientes do AmbienteDAO */
    private List<Ambiente> ambientes = new ArrayList();
    
    
    /*
    *   Lista que recebe itens e guarda-os em sessão no bean
    *   para depois inserir estes no banco de dados com a
    *   confirmação de criação de um novo ambiente.
    */
    private List<Item> itensNovoAmbiente = new ArrayList();
    
    
    /* Recebe nome do ambiente no momento da criação. */
    public Ambiente ambiente = new Ambiente();
    
    /* Usado para criação de novos itens para criação e edição de ambientes */
    private Item item = new Item();
    
    /* Usado para resgatar valores de um ambiente selecionado em dataTables */
    public Ambiente ambienteSelecionado;
    
    
    /* ----------------------------- Fim de atributos -------------------- */
    
    
    /* ----------------------------- Métodos ----------------------------- */
    
    /*
    *   Método preRenderView da página mainUsuario.jsf usado para popular
    *   a dataTable presente na página.
    */
    public void PRVmainUsuario(){
        ambientes = ambienteDAO.buscarAmbientes();
        if(ambienteSelecionado != null){
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
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
    *   Função usada pelo administrador para excluir itens de ambientes registrados
    *   no sistema. 
    */
    public void deletarItem(Item item){
        itensDAO.excluirItem(item.getIdItem());
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
    }
    
    /*
    *   
    *
    */
    public void adicionarItem(){
        /*
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(item.getNome() == null || item.getNome() == ""){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",  "Você precisa inserir um nome para o item!") );
        } else {
        */
        itensDAO.inserirItem(item, ambienteSelecionado.getIdAmbiente());
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente()));
        
    }
    
    /*
    public void validaCampoItem(FacesContext context, UIComponent toValidate, Object value){
        
        boolean valida = false;
        
        if(value == null || value == "" || value == "0"){
            valida = false;
        } else {
            valida = true;
        }
            ((UIInput) toValidate).setValid(!valida);
            
            FacesMessage message = new FacesMessage("Nenhum dos valores do item podem estar vazios.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(toValidate.getClientId(context), message);            
        }
                    
        /* Código da net
        boolean validax = false;
        
        if(value != null){
            for (char letra : ((String) value).toCharArray()) {
                if(letra < ‘0’ || letra > ‘9’) {
                    valida = true;
                    break;
                }
            }

            ((UIInput) toValidate).setValid(!valida);

            FacesMessage message = new FacesMessage(" Valor com numeros!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(toValidate.getClientId(context), message);
        
         } 
    */
    
    public void onCellEditNovoAmbiente(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item editado com sucesso!", "Valor antigo: " + oldValue + ", Novo valor:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /* ----------------------------- Fim de métodos ---------------------- */
    
    
    /* ----------------------------- Getters e Setters ------------------- */
    
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
    
    /* ----------------------------- Fim de Getters e Setters ------------ */
    
}
