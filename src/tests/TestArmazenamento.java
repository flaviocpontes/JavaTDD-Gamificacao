package tests;

import static org.junit.Assert.*;

import main.Armazenamento;
import org.junit.Test;

public class TestArmazenamento {

    @Test
    public void testeArmazenandoUmTipoEmUmUsuario(){
        Armazenamento arm = new Armazenamento();
        arm.gravaPontuacao("guerra", "estrela", 10);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
    }

    @Test
    public void testeArmazenandoUmTipoEmDoisUsuarios(){
        Armazenamento arm = new Armazenamento();
        arm.gravaPontuacao("guerra", "estrela", 10);
        arm.gravaPontuacao("fernandes", "estrela", 14);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
        assertEquals(arm.lePontuacao("fernandes", "estrela"), 14);
    }

}
