package tests;

import main.Placar;
import main.InterfaceArmazenamento;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestPlacar {

    @Test
    public void testeRegistraPontos(){
        MockArmazenamento arm = new MockArmazenamento();
        Placar p = new Placar(arm);
        p.registraPontuacao("guerra", "estrela", 10);
        assertTrue(arm.veriricaChamadaInsercao("guerra", "estrela", 10));
    }

    @Test
    public void testRecuperaPontuacaoUsuario(){
        MockArmazenamento arm = new MockArmazenamento();
        Placar p = new Placar(arm);
        p.registraPontuacao("guerra", "estrela", 10);
        p.registraPontuacao("guerra", "moeda", 8);
        p.registraPontuacao("guerra", "folha", 55);
        p.registraPontuacao("guerra", "acepipes", 0);
        HashMap<String, Integer> h = new HashMap<>();
        h.put("estrela", 10);
        h.put("moeda", 8);
        h.put("folha", 55);
        assertTrue(arm.veriricaChamadaInsercao("guerra", "estrela", 10));
        assertTrue(arm.veriricaChamadaInsercao("guerra", "moeda", 8));
        assertTrue(arm.veriricaChamadaInsercao("guerra", "folha", 55));
        assertEquals(h, p.recuperaPontuacaoUsuario("guerra"));
        assertTrue(arm.verificaChamadaTiposDePontos());
    }

}
