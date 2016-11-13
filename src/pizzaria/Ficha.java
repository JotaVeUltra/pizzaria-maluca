package pizzaria;

public class Ficha {
    int tipo;
    Ficha proximo;

    // Constantes
    static final int PERDE_INGREDIENTE = 0;
    static final int GANHA_DOIS_INGREDIENTES = 1;
    static final int RETIRE_DE_OUTRO_JOGADOR = 2;
    static final int QUEIMAR_A_PIZZA = 3;

    Ficha(int tipo){
        this.tipo = tipo;
        this.proximo = null;
    }

}
