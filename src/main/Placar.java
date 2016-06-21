package main;

import java.util.HashMap;

public class Placar {

    InterfaceArmazenamento arm;

    public Placar (InterfaceArmazenamento arm) {
        this.arm = arm;
    }

    public void registraPontuacao(String usuario, String tipo, int pontos) {
        arm.inserePontuacao(usuario, tipo, pontos);
    }

    public HashMap<String, Integer> recuperaPontuacaoUsuario(String usuario){
        HashMap<String, Integer> resultado = new HashMap<>();
        for (String tipo : arm.pegaTiposDePontos()){
            try {
                Integer pontos = arm.pegaPontuacaoUsuario(usuario, tipo);
                if (pontos > 0) resultado.put(tipo, pontos);
            } catch (UsuarioNaoEncontradoException e) {
                return null;
            }
        }
        return resultado;
    }

}
