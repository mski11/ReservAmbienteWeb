package br.senai.junit;


import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmbienteModelUnit {
    
    @Test
    public void testeGetter(){
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("Laboratório aberto", false, itensAmbiente);
        
        assertEquals("Laboratório aberto", ambiente.getIdAmbiente());
        assertEquals(false, ambiente.isStatus());
        assertEquals(itensAmbiente, ambiente.getItensAmbiente());
        
    }
    
    @Test
    public void testeSetter(){
        
        Ambiente ambiente = new Ambiente();
        ArrayList<Item> itensAmbiente = new ArrayList();
        
        ambiente.setIdAmbiente("Laboratório aberto");
        ambiente.setStatus("0");
        ambiente.setItensAmbiente(itensAmbiente);
        
        assertEquals("Laboratório aberto", ambiente.getIdAmbiente());
        assertEquals(false, ambiente.isStatus());
        assertEquals(itensAmbiente, ambiente.getItensAmbiente());   
        
    }
    
}
