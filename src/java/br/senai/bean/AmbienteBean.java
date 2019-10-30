package br.senai.bean;

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
    
    private List<Item> itensAmbiente = new ArrayList();
    private Item item = new Item();
    public String nomeAmbiente;
    
    public void adicionarItem(){
        itensAmbiente.add(item);
        item = new Item();
    }
    
    public void deletarItem(Item item){
        itensAmbiente.remove(item);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item editado com sucesso!", "Valor antigo: " + oldValue + ", Novo valor:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<Item> getItensAmbiente() {
        return itensAmbiente;
    }

    public void setItensAmbiente(List<Item> itensAmbiente) {
        this.itensAmbiente = itensAmbiente;
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
