
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
    
    /* Usado para CRUD's relacionados a Item */
    public ItemDAO itensDAO = new ItemDAO();
    
    /* AmbienteBean importado para uso em funções relacionadas aos ambientes. */
    @ManagedProperty(value = "ambienteSelecionado")
    public Ambiente ambienteSelecionado;
    
 /* --------------------------------- Fim de atributos ---------------------- */
    
    
 /* --------------------------------- Métodos ------------------------------- */
    
    /* 
    *   Método usado para buscar os itens do ambiente selecionado.
    *   @param ambiente Ambiente - Ambiente selecionado que se deseja ver os itens.
    */
    public void buscarItensAmbienteSelecionado(Ambiente ambiente){
        ambienteSelecionado.setItensAmbiente(itensDAO.buscarItens(ambiente.getIdAmbiente()));
    }
    
    /* 
    *   Método usado para adicionar um item no ambiente selecionado.
    *   @param ambiente Item - Informações do item adicionado.
    */
    public void adicionarItem(Item item){
        itensDAO.inserirItem(item, ambienteSelecionado.getIdAmbiente());
    }
    
    /* 
    *   Método usado para deletar um item no ambiente selecionado.
    *   @param ambiente Item - Informações do item deletado.
    */
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
