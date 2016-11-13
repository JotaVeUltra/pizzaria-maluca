package pizzaria;

import javax.swing.*;
import java.util.Random;

public class Jogadores {
    Jogador primeiro, ultimo, atual;

    Jogadores(int n){
        primeiro = ultimo = atual = null;
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            int pizza = gerador.nextInt(6);
            insere(new Jogador(JOptionPane.showInputDialog("Nome"), pizza));
        }
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
