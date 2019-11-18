package br.senai.junit;

import br.senai.dao.AmbienteDAO;
import br.senai.model.Ambiente;
import br.senai.model.Item;
import java.util.ArrayList;
import java.util.List;
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
        
        List<Ambiente> listAmbiente = new ArrayList();
        AmbienteDAO dao = new AmbienteDAO();
        
        listAmbiente = dao.buscarAmbientes();
        
        if(dao.buscarAmbientes() != null){
            for(Ambiente a: listAmbiente){
                System.out.println(a.getIdAmbiente());
            }    
        } else {
                fail("Busca de ambientes falhou! Você tem ideia do porquê? ");
            }
    }
        
    
}
