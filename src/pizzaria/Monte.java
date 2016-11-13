package pizzaria;

import java.util.Random;

public class Monte {
    Ficha topo = null;

    public Monte(){
        int ficha1, ficha2, ficha3, ficha4, pilha = 20;
        ficha1 = ficha2 = ficha3 = ficha4 = 5;
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

    public void empilha(int v){
        Ficha novo = new Ficha(v);
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

    boolean monteVazio(){
        return this.topo == null;
    }
}
