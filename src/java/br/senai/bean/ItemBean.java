
package br.senai.bean;

import br.senai.dao.ItemDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ItemBean {
    
    public ItemDAO itensDAO = new ItemDAO();
    
    public Ambiente ambienteSelecionado;
    public List<Item> itensAmbienteSelecionado = new ArrayList();
    
    public void buscarItensAmbienteSelecionado(){
        itensAmbienteSelecionado = itensDAO.buscarItens(ambienteSelecionado.getIdAmbiente());
    }
    
    public void deletarItem(int idItem){
        itensDAO.excluirItem(idItem);
    }

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

    public List<Item> getItensAmbienteSelecionado() {
        return itensAmbienteSelecionado;
    }

    public void setItensAmbienteSelecionado(List<Item> itensAmbienteSelecionado) {
        this.itensAmbienteSelecionado = itensAmbienteSelecionado;
    }
    
    
}
