package br.senai.junit;

import br.senai.dao.ItemDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemDAOUnit {
    
    
    public void testeAdicionarItem(){
        
        Item item = new Item("Nome", "Descricao", 1);
        ItemDAO dao = new ItemDAO();
        String idAmbiente = "ofilasi";
        
        if(dao.adicionarItem(item, idAmbiente)){
            System.out.println("Item inserido no ambiente com sucesso!");
        } else {
            fail("Erro! O item não foi inserido no ambiente.");
        }
        
    }
    
    @Test
    public void testePesquisarItens(){
        
        ItemDAO dao = new ItemDAO();
        List<Item> itens = new ArrayList();
        
        
        Ambiente ambiente = new Ambiente("AmbienteTeste", false, null);
        ambiente.setItensAmbiente(itens);
        
        for(Item i: ambiente.getItensAmbiente())
            System.out.println("Item: " + i.getNome());
    }
    
    
    public void teste(){
        Item item = new Item("Nome", "Descricao", 1);
        List<Item> itensAmbiente = new ArrayList();
        itensAmbiente.add(item);
        
        ItemDAO dao = new ItemDAO();
        String idAmbiente = "ambienteTeste";
        
        if(dao.inserirItemNovoAmbiente(itensAmbiente, idAmbiente)){
            System.out.println("Item inserido no ambiente com sucesso!");
        } else {
            fail("Erro! O item não foi inserido no ambiente.");
        }
    }
}
