package br.senai.junit;

import br.senai.model.Item;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemModelUnit {
    
   @Test
   public void testeGetter(){
       
       Item item = new Item("Cadeira", "Almofada azul", 1);
       
       assertEquals("Cadeira", item.getNome());
       assertEquals("Almofada azul", item.getDescricao());
       assertEquals(1, item.getQuantidade());
       
   }
   
   public void testeSetter(){
       
       Item item = new Item();
       
       item.setNome("Cadeira");
       item.setDescricao("Almofada azul");
       item.setQuantidade(1);
       
       assertEquals("Cadeira", item.getNome());
       assertEquals("Almofada azul", item.getDescricao());
       assertEquals(1, item.getQuantidade());
       
   }
    
}
