package br.senai.junit;

import br.senai.dao.AmbienteDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmbienteDAOUnit {
    
    
    public void testeCriarAmbiente(){
        
        ArrayList<Item> itensAmbiente = new ArrayList();
        Ambiente ambiente = new Ambiente("Nome do ambiente", false, itensAmbiente);
        AmbienteDAO dao = new AmbienteDAO();
        
        if(dao.criarAmbiente(ambiente)){
            System.out.println("Ambiente registrado com sucesso");
        } else {
            fail("Registro de ambiente falhou!");
        }
    }
    
    @Test
    public void testeBuscaAmbientes(){
        
        AmbienteDAO dao = new AmbienteDAO();
        
        if(dao.buscarAmbientes() != null){
            System.out.println("Ambientes buscados com sucesso");
        } else {
            fail("Busca de ambientes falhou! Você tem ideia do porquê? ");
        }
        
        
    }
    
}
