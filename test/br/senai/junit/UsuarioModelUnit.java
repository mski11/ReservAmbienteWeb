package br.senai.junit;

import br.senai.model.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioModelUnit {
    
    @Test
    public void testeGetter(){
        
        Usuario usuario = new Usuario(1, "Chrys", "1234", "chrysterafrz@hotmail.com", "91015929", "4321", false);
        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Chrys", usuario.getNome());
        assertEquals("1234", usuario.getMatricula());
        assertEquals("chrysterafrz@hotmail.com", usuario.getEmail());
        assertEquals("91015929", usuario.getTelefone());
        assertEquals("4321", usuario.getPass());
        assertEquals(false, usuario.isMestre());
        
    }
    
    @Test
    public void testeSetter(){
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNome("Chrys");
        usuario.setMatricula("1234");
        usuario.setEmail("chrysterafrz@hotmail.com");
        usuario.setTelefone("91015929");
        usuario.setPass("4321");
        usuario.setMestre(false);
        
        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Chrys", usuario.getNome());
        assertEquals("1234", usuario.getMatricula());
        assertEquals("chrysterafrz@hotmail.com", usuario.getEmail());
        assertEquals("91015929", usuario.getTelefone());
        assertEquals("4321", usuario.getPass());
        assertEquals(false, usuario.isMestre());

    }
    
}
