package br.senai.junit;

import br.senai.dao.AmbienteDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmbienteDAOUnit {
    
    @Test
    public void testeCriarAmbiente(){
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("Nome do ambiente", false, itensAmbiente);
        AmbienteDAO dao = new AmbienteDAO();
        
        if(dao.criarAmbiente(ambiente.getIdAmbiente())){
            System.out.println("Ambiente registrado com sucesso");
        } else {
            fail("Registro de ambiente falhou!");
        }
    }
    
}
