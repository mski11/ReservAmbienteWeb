package br.senai.junit;

import br.senai.dao.ItemDAO;
import br.senai.model.Item;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemDAOUnit {
    
    @Test
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
    
}
