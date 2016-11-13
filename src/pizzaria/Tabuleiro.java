package pizzaria;

public class Tabuleiro {

    // Constantes
    final int CEBOLA = 0;
    final int BROCOLIS = 1;
    final int QUEIJO = 2;
    final int CALABRESA = 3;
    final int TOMATE = 4;
    final int OVO = 5;
    final int PRESUNTO = 6;
    final int AZEITONA = 7;
    final int MILHO = 8;
    final int ERVILHA = 9;
    final int PERDE_TUDO = 10;
    final int SORTE_AZAR = 11;

    Elemento primeiro, ultimo, atual;

    public Tabuleiro() {
        primeiro = ultimo = atual = null;
        insere(new Elemento(PERDE_TUDO));
        insere(new Elemento(CEBOLA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(CALABRESA));
        insere(new Elemento(QUEIJO));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(TOMATE));
        insere(new Elemento(OVO));
        insere(new Elemento(AZEITONA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(MILHO));
        insere(new Elemento(ERVILHA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(PRESUNTO));
        insere(new Elemento(TOMATE));
        insere(new Elemento(MILHO));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(BROCOLIS));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(OVO));
        insere(new Elemento(CEBOLA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(CALABRESA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(PRESUNTO));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(QUEIJO));
        insere(new Elemento(ERVILHA));
        insere(new Elemento(SORTE_AZAR));
        insere(new Elemento(BROCOLIS));
        insere(new Elemento(AZEITONA));
        insere(new Elemento(SORTE_AZAR));
        insere(primeiro);
    }

    private void insere(Elemento e){
        if (primeiro == null){
            primeiro = e;
            ultimo = e;
        } else {
            ultimo.proximo = e;
            e.anterior = ultimo;
            ultimo = e;
        }
    }

    // Move para a posição indicada
    public void moveParaPosicao(int pos) {
        atual = primeiro;
        for (int i=1; i<pos; i++) {
            atual = atual.proximo;
        }
    }

    // Retorna o elemento na posição indicada
    public Elemento elementoNaPosicao(int pos) {
        moveParaPosicao(pos);
        return atual;
    }
}
