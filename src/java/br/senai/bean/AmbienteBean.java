package br.senai.bean;

import br.senai.dao.AmbienteDAO;
import br.senai.dao.ItemDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

@SessionScoped
@ManagedBean
public class AmbienteBean {
    
    private AmbienteDAO ambienteDAO = new AmbienteDAO();
    
    /*  Neste Bean, o itensDAO é utilizado somente na hora
    *   de criar um novo ambiente. Todas outras funções relacionadas
    *   à itens são feitas em ItemBean.
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
    public String nomeAmbiente;
        
    private Item item = new Item();
    
    public Ambiente ambienteSelecionado;
    
    public void excluirItem(){
        itensDAO.excluirItem(item.getIdItem());
    }
    
    public void buscarAmbiente(){
        ambientes = ambienteDAO.buscarAmbientes();
    }
    
    public void adicionarItem(){
        itensNovoAmbiente.add(item);
        item = new Item();
    }
    
    public void deletarItem(Item item){
        itensNovoAmbiente.remove(item);
    }
    
    public void criarAmbiente(){
        ambienteDAO.criarAmbiente(nomeAmbiente);
        itensDAO.inserirItemNovoAmbiente(itensNovoAmbiente, nomeAmbiente);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item editado com sucesso!", "Valor antigo: " + oldValue + ", Novo valor:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

    public List<Ambiente> getAmbiente() {
        return ambientes;
    }

    public void setAmbiente(List<Ambiente> ambiente) {
        this.ambientes = ambiente;
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

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public void setNomeAmbiente(String nomeAmbiente) {
        this.nomeAmbiente = nomeAmbiente;
    }
    
    
    
}
