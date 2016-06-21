package main;

public class Placar {

    InterfaceArmazenamento arm;

    public Placar (InterfaceArmazenamento arm) {
        this.arm = arm;
    }

    public void registraPontuacao(String usuario, String tipo, int pontos) {
        arm.inserePontuacao(usuario, tipo, pontos);
    }
}
