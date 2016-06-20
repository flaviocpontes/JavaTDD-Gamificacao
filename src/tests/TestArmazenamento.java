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
        arm.inserePontuacao("guerra", "estrela", 10);
        assertEquals(arm.pegaPontuacaoUsuario("guerra", "estrela"), 10);
    }

    @Test
    public void testeArmazenandoUmTipoEmDoisUsuarios() throws UsuarioNaoEncontradoException {
        arm.inserePontuacao("guerra", "estrela", 10);
        arm.inserePontuacao("fernandes", "estrela", 14);
        assertEquals(arm.pegaPontuacaoUsuario("guerra", "estrela"), 10);
        assertEquals(arm.pegaPontuacaoUsuario("fernandes", "estrela"), 14);
    }

    @Test
    public void testeDoisTiposEmUmUsuario() throws UsuarioNaoEncontradoException {
        arm.inserePontuacao("guerra", "estrela", 10);
        arm.inserePontuacao("guerra", "moedas", 50);
        assertEquals(arm.pegaPontuacaoUsuario("guerra", "estrela"), 10);
        assertEquals(arm.pegaPontuacaoUsuario("guerra", "moedas"), 50);
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void testeLeUsuarioInexistente() throws UsuarioNaoEncontradoException {
        arm.pegaPontuacaoUsuario("guerra", "estrela");
    }

    @Test
    public void recuperaUsuariosComPontuacao(){
        arm.inserePontuacao("guerra", "estrela", 10);
        arm.inserePontuacao("fernandes", "estrela", 14);
        List<String> usuariosPontuados = new ArrayList<>();
        usuariosPontuados.add("guerra");
        usuariosPontuados.add("fernandes");
        assertTrue(usuariosPontuados.equals(arm.pegaUsuariosPontuados()));
    }

    @Test
    public void recuperaTiposPontuacao(){
        arm.inserePontuacao("guerra", "estrela", 10);
        arm.inserePontuacao("guerra", "moeda", 10);
        arm.inserePontuacao("fernandes", "estrela", 14);
        arm.inserePontuacao("fernandes", "curtida", 14);
        arm.inserePontuacao("fernandes", "comentario", 14);
        Set<String> tiposDePontuacao = new HashSet<>();
        tiposDePontuacao.add("estrela");
        tiposDePontuacao.add("moeda");
        tiposDePontuacao.add("curtida");
        tiposDePontuacao.add("comentario");
        assertTrue(tiposDePontuacao.equals(arm.pegaTiposDePontos()));
    }

}
