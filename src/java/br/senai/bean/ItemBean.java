
package br.senai.bean;

import br.senai.dao.ItemDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ItemBean {
    
 /* --------------------------------- Atributos ----------------------------- */
    
    public ItemDAO itensDAO = new ItemDAO();
    
    @ManagedProperty(value = "ambienteSelecionado")
    public Ambiente ambienteSelecionado;
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    public void buscarItensAmbienteSelecionado(Ambiente ambiente){
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambiente.getIdAmbiente()));
    }
    
    public void adicionarItem(Item item){
        itensDAO.inserirItem(item, ambienteSelecionado.getIdAmbiente());
    }
    
    public void deletarItem(Item item){
        itensDAO.excluirItem(item.getIdItem());
    }

 /* --------------------------------- Fim de métodos ------------------------ */
    
    
 /* --------------------------------- Getters e Setters --------------------- */
    
    public ItemDAO getItensDAO() {
        return itensDAO;
    }

    public void setItensDAO(ItemDAO itensDAO) {
        this.itensDAO = itensDAO;
    }

    public Ambiente getAmbienteSelecionado() {
        return ambienteSelecionado;
    }

    public void setAmbienteSelecionado(Ambiente ambienteSelecionado) {
        this.ambienteSelecionado = ambienteSelecionado;
    }
    
 /* --------------------------------- Fim de Getters e Setters -------------- */
    
}
