package pizzaria;

public class Pizza {
    private Ingrediente primeiro, ultimo, atual;
    String nome;

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

    public Pizza(int p) {
        primeiro = ultimo = atual = null;
        switch (p) {
            case 0:
                nome = "vegetariana";
                insere(new Ingrediente(BROCOLIS));
                insere(new Ingrediente(TOMATE));
                insere(new Ingrediente(ERVILHA));
                insere(new Ingrediente(CEBOLA));
                insere(new Ingrediente(OVO));
                break;
            case 1:
                nome = "calabresa";
                insere(new Ingrediente(CALABRESA));
                insere(new Ingrediente(AZEITONA));
                insere(new Ingrediente(BROCOLIS));
                insere(new Ingrediente(OVO));
                insere(new Ingrediente(ERVILHA));
                break;
            case 2:
                nome = "romana";
                insere(new Ingrediente(QUEIJO));
                insere(new Ingrediente(CEBOLA));
                insere(new Ingrediente(MILHO));
                insere(new Ingrediente(PRESUNTO));
                insere(new Ingrediente(ERVILHA));
                break;

            case 3:
                nome = "portuguesa";
                insere(new Ingrediente(PRESUNTO));
                insere(new Ingrediente(AZEITONA));
                insere(new Ingrediente(QUEIJO));
                insere(new Ingrediente(OVO));
                insere(new Ingrediente(MILHO));
                break;
            case 4:
                nome = "toscana";
                insere(new Ingrediente(TOMATE));
                insere(new Ingrediente(PRESUNTO));
                insere(new Ingrediente(AZEITONA));
                insere(new Ingrediente(CALABRESA));
                insere(new Ingrediente(CEBOLA));
                break;
            case 5:
                nome = "marguerita";
                insere(new Ingrediente(CALABRESA));
                insere(new Ingrediente(BROCOLIS));
                insere(new Ingrediente(TOMATE));
                insere(new Ingrediente(QUEIJO));
                insere(new Ingrediente(MILHO));
                break;
        }
    }

    private void insere(Ingrediente i){
        if (primeiro == null){
            primeiro = i;
            ultimo = i;
        } else {
            ultimo.proximo = i;
            ultimo = i;
        }
    }
}
