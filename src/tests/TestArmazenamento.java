package tests;

import static org.junit.Assert.*;

import main.Armazenamento;
import org.junit.Test;

public class TestArmazenamento {

    @Test
    public void testStoringPoints(){
        Armazenamento arm = new Armazenamento();
        arm.gravaPontuacao("guerra", "estrela", 10);
        assertEquals(arm.lePontuacao("guerra", "estrela"), 10);
    }

}
