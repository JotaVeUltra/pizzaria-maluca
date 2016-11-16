package pizzaria;

import java.util.Random;

public class Jogadores {
    Jogador primeiro, ultimo, atual;

    Jogadores(int n){
        primeiro = ultimo = atual = null;
        Random gerador = new Random();
        insere(new Jogador(Principal.txtJogador1.getText(), gerador.nextInt(6)));
        insere(new Jogador(Principal.txtJogador2.getText(), gerador.nextInt(6)));
        if (n > 2) {
            insere(new Jogador(Principal.txtJogador3.getText(), gerador.nextInt(6)));
        }
        if (n > 3) {
            insere(new Jogador(Principal.txtJogador4.getText(), gerador.nextInt(6)));
        }
        if (n > 4) {
            insere(new Jogador(Principal.txtJogador5.getText(), gerador.nextInt(6)));
        }
        insere(primeiro);
    }

    private void insere(Jogador j){
        if (primeiro == null){
            primeiro = j;
            ultimo = j;
        } else {
            ultimo.proximo = j;
            ultimo = j;
        }
    }
}
