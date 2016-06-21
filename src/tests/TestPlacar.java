package tests;

import main.Placar;
import main.InterfaceArmazenamento;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPlacar {

    @Test
    public void testeRegistraPontos(){
        MockArmazenamento arm = new MockArmazenamento();
        Placar p = new Placar(arm);
        p.registraPontuacao("guerra", "estrela", 10);
        assertTrue(arm.veriricaChamadaInsercao("guerra", "estrela", 10));
    }

}
