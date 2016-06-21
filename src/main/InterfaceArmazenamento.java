package main;

import java.util.List;
import java.util.Set;

public interface InterfaceArmazenamento {
    public void inserePontuacao(String usuario, String tipo, int quantidade);
    public int pegaPontuacaoUsuario(String usuario, String tipo) throws UsuarioNaoEncontradoException;
    public List<String> pegaUsuariosPontuados();
    public Set<String> pegaTiposDePontos();
}
