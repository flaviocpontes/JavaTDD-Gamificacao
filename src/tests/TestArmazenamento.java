package tests;

import static org.junit.Assert.*;

import main.Armazenamento;
import main.UsuarioNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TestArmazenamento {

    private Armazenamento arm;

    @Before
    public void inicializaTeste(){
        File file = new File("pontuacao.xml");
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            System.out.println("Nao é possível deletar o arquivo de testes");
        }
        arm = new Armazenamento("pontuacao.xml");
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

    @Test
    public void testaPersistenciaPontuacao() throws UsuarioNaoEncontradoException {
        arm.inserePontuacao("guerra", "estrela", 5);
        arm.inserePontuacao("guerra", "moeda", 6);
        arm.inserePontuacao("fernandes", "estrela", 7);
        arm.inserePontuacao("fernandes", "curtida", 8);
        arm.inserePontuacao("fernandes", "comentario", 9);
        Armazenamento arm2 = new Armazenamento("pontuacao.xml");
        assertEquals(arm2.pegaPontuacaoUsuario("guerra", "estrela"), 5);
        assertEquals(arm2.pegaPontuacaoUsuario("guerra", "moeda"), 6);
        assertEquals(arm2.pegaPontuacaoUsuario("fernandes", "estrela"), 7);
        assertEquals(arm2.pegaPontuacaoUsuario("fernandes", "curtida"), 8);
        assertEquals(arm2.pegaPontuacaoUsuario("fernandes", "comentario"), 9);
    }

}
