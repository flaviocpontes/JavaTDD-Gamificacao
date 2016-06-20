package main;

import java.util.*;

public class Armazenamento {

    private HashMap<String, HashMap<String, Integer>> _pontuacao = new HashMap<>();

    public void inserePontuacao(String usuario, String tipo, int quantidade) {
        HashMap<String, Integer> pontosTipo = _pontuacao.get(usuario);
        if (pontosTipo == null) pontosTipo = new HashMap<>();
        pontosTipo.put(tipo, quantidade);
        _pontuacao.put(usuario, pontosTipo);
    }

    public int pegaPontuacaoUsuario(String usuario, String tipo) throws UsuarioNaoEncontradoException {
        HashMap<String, Integer> pontosTipo = _pontuacao.get(usuario);
        if (pontosTipo == null) throw new UsuarioNaoEncontradoException();
        return pontosTipo.get(tipo);
    }

    public List<String> pegaUsuariosPontuados() {
        ArrayList<String> usuarios = new ArrayList<>();
        for (String usuario : _pontuacao.keySet()) {
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Set<String> pegaTiposDePontos() {
        HashSet<String> tipos = new HashSet<>();
        for (String usuario : _pontuacao.keySet()) {
            tipos.addAll(_pontuacao.get(usuario).keySet());
        }
        return tipos;
    }
}
