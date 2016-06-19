package main;

import java.util.HashMap;

public class Armazenamento {

    private HashMap<String, Integer> pontuacao = new HashMap<String, Integer>();

    public void gravaPontuacao(String usuario, String tipo, int quantidade) {
        pontuacao.put(usuario, quantidade);
    }

    public int lePontuacao(String usuario, String tipo) {
        return pontuacao.get(usuario);
    }
}
