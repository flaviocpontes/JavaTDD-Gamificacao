package tests;

import main.InterfaceArmazenamento;
import main.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MockArmazenamento implements InterfaceArmazenamento {

    class ChamadaInsercao {
        String usuario;
        String tipo;
        Integer quantidade;

        public ChamadaInsercao(String usuario, String tipo, int quantidade){
            this.usuario = usuario;
            this.tipo = tipo;
            this.quantidade = quantidade;
        }

        public boolean equals(ChamadaInsercao other) {
            if (!other.usuario.equals(this.usuario)) return false;
            if (!other.tipo.equals(this.tipo)) return false;
            if (other.quantidade != this.quantidade) return false;
            return true;
        }
    }

    private List<ChamadaInsercao> chamadasInsercao = new ArrayList<>();

    public boolean veriricaChamadaInsercao(String usuario, String tipo, int quantidade){
        ChamadaInsercao chamada = new ChamadaInsercao(usuario, tipo, quantidade);
        for ( ChamadaInsercao c : chamadasInsercao) {
            if (c.equals(chamada)) return true;
        }
        return false;
    }

    @Override
    public void inserePontuacao(String usuario, String tipo, int quantidade) {
        chamadasInsercao.add(new ChamadaInsercao(usuario, tipo, quantidade));
    }

    @Override
    public int pegaPontuacaoUsuario(String usuario, String tipo) throws UsuarioNaoEncontradoException {
        return 0;
    }

    @Override
    public List<String> pegaUsuariosPontuados() {
        return null;
    }

    @Override
    public Set<String> pegaTiposDePontos() {
        return null;
    }
}
