package tests;

import static org.junit.Assert.*;

import main.Armazenamento;
import main.UsuarioNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestArmazenamento {

    Armazenamento arm;

    @Before
    public void inicializaTeste(){
        arm = new Armazenamento();
    }

    @Test
    public void testeArmazenandoUmTipoEmUmUsuario() throws UsuarioNaoEncontradoException {
        arm.gravaPontuacao("guerra", "estrela", 10);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
    }

    @Test
    public void testeArmazenandoUmTipoEmDoisUsuarios() throws UsuarioNaoEncontradoException {
        arm.gravaPontuacao("guerra", "estrela", 10);
        arm.gravaPontuacao("fernandes", "estrela", 14);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
        assertEquals(arm.lePontuacao("fernandes", "estrela"), 14);
    }

    @Test
    public void testeDoisTiposEmUmUsuario() throws UsuarioNaoEncontradoException {
        arm.gravaPontuacao("guerra", "estrela", 10);
        arm.gravaPontuacao("guerra", "moedas", 50);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
        assertEquals(arm.lePontuacao("guerra", "moedas"), 50);
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void testeLeUsuarioInexistente() throws UsuarioNaoEncontradoException {
        arm.lePontuacao("guerra", "estrela");
    }

    @Test
    public void recuperaUsuariosComPontuacao(){
        arm.gravaPontuacao("guerra", "estrela", 10);
        arm.gravaPontuacao("fernandes", "estrela", 14);
        List<String> usuariosPontuados = new ArrayList<>();
        usuariosPontuados.add("guerra");
        usuariosPontuados.add("fernandes");
        assertTrue(usuariosPontuados.equals(arm.pegaUsuariosPontuados()));
    }

    @Test
    public void recuperaTiposPontuacao(){
        arm.gravaPontuacao("guerra", "estrela", 10);
        arm.gravaPontuacao("guerra", "moeda", 10);
        arm.gravaPontuacao("fernandes", "estrela", 14);
        arm.gravaPontuacao("fernandes", "curtida", 14);
        arm.gravaPontuacao("fernandes", "comentario", 14);
        Set<String> tiposDePontuacao = new HashSet<>();
        tiposDePontuacao.add("estrela");
        tiposDePontuacao.add("moeda");
        tiposDePontuacao.add("curtida");
        tiposDePontuacao.add("comentario");
        assertTrue(tiposDePontuacao.equals(arm.pegaTiposDePontos()));
    }

}
