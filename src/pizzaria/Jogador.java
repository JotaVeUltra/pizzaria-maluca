package pizzaria;

public class Jogador {
    Jogador proximo;
    String nome;
    Pizza pizza;

    Jogador(String nome, int p){
        this.nome = nome;
        this.proximo = null;
        this.pizza = new Pizza(p);
    }
}
