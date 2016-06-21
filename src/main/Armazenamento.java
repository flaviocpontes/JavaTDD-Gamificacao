package main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class Armazenamento {

    private HashMap<String, HashMap<String, Integer>> _pontuacao = new HashMap<>();
    private static final File file = new File("pontuacao.xml");

    @SuppressWarnings("unchecked")
    public Armazenamento(){
        if (file.exists() && !file.isDirectory()) {
            try {
                FileInputStream f = new FileInputStream(file);
                XMLDecoder d = new XMLDecoder(new BufferedInputStream(f));
                _pontuacao = (HashMap<String, HashMap<String, Integer>>) d.readObject();
                d.close();
            } catch (FileNotFoundException e) {
                System.out.println("Não foi possível acessar o arquivo de pontuacao.");
                System.exit(1);
            }
        }
    }

    private void gravaInformacoes(){
        try {
            FileOutputStream f = new FileOutputStream(file);
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(f));
            e.writeObject(_pontuacao);
            e.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível gravar no arquivo de pontuacao.");
            System.exit(1);
        }
    }

    public void inserePontuacao(String usuario, String tipo, int quantidade) {
        HashMap<String, Integer> pontosTipo = _pontuacao.get(usuario);
        if (pontosTipo == null) pontosTipo = new HashMap<>();
        pontosTipo.put(tipo, quantidade);
        _pontuacao.put(usuario, pontosTipo);
        gravaInformacoes();
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
