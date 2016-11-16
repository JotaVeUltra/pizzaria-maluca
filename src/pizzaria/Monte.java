package pizzaria;

import javax.swing.*;
import java.util.Random;

public class Monte {
    Ficha topo = null;

    public Monte(){
        int ficha1, ficha2, ficha3, ficha4, pilha;
        ficha1 = ficha2 = ficha3 = ficha4 = 5;
        pilha = 20;
        Random gerador = new Random();
        while (pilha > 0){
            int randint = gerador.nextInt(4);
            switch (randint){
                case 0:
                    if (ficha1 > 0) {
                        empilha(Ficha.PERDE_INGREDIENTE);
                        ficha1--;
                        pilha--;
                    }
                    break;
                case 1:
                    if (ficha2 > 0) {
                        empilha(Ficha.GANHA_DOIS_INGREDIENTES);
                        ficha2--;
                        pilha--;
                    }
                    break;
                case 2:
                    if (ficha3 > 0) {
                        empilha(Ficha.RETIRE_DE_OUTRO_JOGADOR);
                        ficha3--;
                        pilha--;
                    }
                    break;
                case 3:
                    if (ficha4 > 0) {
                        empilha(Ficha.QUEIMAR_A_PIZZA);
                        ficha4--;
                        pilha--;
                    }
                    break;
            }
        }
    }

    void sorteAzar(Jogador jogador){
        int f = desempilha();
        switch (f){
            case Ficha.PERDE_INGREDIENTE:
                Principal.lblInfo.setText(Principal.lblInfo.getText()+" teve azar, perdeu ingrediente");
                perdeIngrediente(jogador);
                break;
            case Ficha.GANHA_DOIS_INGREDIENTES:
                Principal.lblInfo.setText(Principal.lblInfo.getText()+" teve sorte, ganhou dois ingredientes");
                ganhaDoisIngredientes(jogador);
                break;
            case Ficha.RETIRE_DE_OUTRO_JOGADOR:
                Principal.lblInfo.setText(Principal.lblInfo.getText()+" teve sorte, retirou ingredientes");
                retiraDeOutroJogador(jogador);
                break;
            case Ficha.QUEIMAR_A_PIZZA:
                Principal.lblInfo.setText(Principal.lblInfo.getText()+" teve azar, queimou a pizza");
                queimarPizza(jogador);
                break;
        }
    }

    void perdeIngrediente(Jogador jogador) {
        if (jogador.pizza.tamanho() != 5) {
            if (jogador.pizza.tamanho() == 4) {
                jogador.pizza = new Pizza(jogador.pizza.tipo);
            } else {
                Pizza tempPizza = new Pizza(jogador.pizza.tipo);
                tempPizza.atual = tempPizza.primeiro;
                while (tempPizza.atual != null) {
                    jogador.pizza.atual = jogador.pizza.primeiro;
                    boolean temIngredinte = true;
                    while (jogador.pizza.atual != null) {
                        if (jogador.pizza.atual.tipo == tempPizza.atual.tipo)
                            temIngredinte = false;
                        jogador.pizza.atual = jogador.pizza.atual.proximo;
                    }
                    if (!temIngredinte)
                        tempPizza.atual = tempPizza.atual.proximo;
                    else
                        jogador.pizza.insere(new Ingrediente(tempPizza.atual.tipo));
                        break;
                }
            }
        }
    }

    void ganhaDoisIngredientes(Jogador jogador) {
        if (jogador.pizza.primeiro != null) {
            jogador.pizza.removePrimeiro();
            if (jogador.pizza.primeiro != null)
                jogador.pizza.removePrimeiro();
        }
    }

    void retiraDeOutroJogador(Jogador jogador) {
        boolean retirou = false;
        while (!retirou) {
            String nome = JOptionPane.showInputDialog(jogador.nome+", de qual jogador deseja retirar ingredientes?");
            Jogador tempJ = Principal.jogadores.primeiro;
            for (int i = 0; i < Principal.numeroJogadores; i++) {
                if (tempJ.nome.equalsIgnoreCase(nome)) {
                    perdeIngrediente(tempJ);
                    retirou = true;
                    Principal.lblInfo.setText(Principal.lblInfo.getText()+" "+nome);
                    break;
                } else {
                    tempJ = tempJ.proximo;
                }
            }
        }
    }

    void queimarPizza(Jogador jogador){
        jogador.pizza = new Pizza(jogador.pizza.tipo);
    }

    public void empilha(int f){
        Ficha novo = new Ficha(f);
        if(topo == null)
            topo = novo;
        else{
            novo.proximo = topo;
            topo = novo;
        }
    }

    public int desempilha(){
        int retVal = topo.tipo;
        topo = topo.proximo;
        return retVal;
    }

    boolean estaVazio(){
        return this.topo == null;
    }
}
