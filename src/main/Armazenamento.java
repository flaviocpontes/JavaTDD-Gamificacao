package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Armazenamento {

    private HashMap<String, Integer> pontosTipo;
    private HashMap<String, HashMap<String, Integer>> pontuacao = new HashMap<>();

    public void gravaPontuacao(String usuario, String tipo, int quantidade) {
        pontosTipo = pontuacao.get(usuario);
        if (pontosTipo == null) pontosTipo = new HashMap<>();
        pontosTipo.put(tipo, quantidade);
        pontuacao.put(usuario, pontosTipo);
    }

    public int lePontuacao(String usuario, String tipo) throws UsuarioNaoEncontradoException {
        pontosTipo = pontuacao.get(usuario);
        if (pontosTipo == null) throw new UsuarioNaoEncontradoException();
        return pontosTipo.get(tipo);
    }

    public List<String> pegaUsuariosPontuados() {
        ArrayList<String> usuarios = new ArrayList<>();
        for (String usuario : pontuacao.keySet()) {
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Set<String> pegaTiposDePontos() {
        return null;
    }
}
