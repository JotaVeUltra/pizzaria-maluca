package pizzaria;

public class Pizza {
    Ingrediente primeiro, ultimo, atual;
    String nome;
    int tipo;

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
        this.tipo = p;
        switch (this.tipo) {
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

    void insere(Ingrediente i){
        if (primeiro == null){
            primeiro = i;
            ultimo = i;
        } else {
            ultimo.proximo = i;
            ultimo = i;
        }
    }

    int tamanho() {
        int countI = 0;
        this.atual = this.primeiro;
        while (this.atual != null) {
            this.atual = this.atual.proximo;
            countI++;
        }
        return countI;
    }

    int buscaIngredinte(int tipo) {
        int count = 0;
        this.atual = this.primeiro;
        while(this.atual != null && this.atual.tipo != tipo) {
            this.atual = this.atual.proximo;
            count ++;
        }
        if (this.atual != null)
            return count;
        return -1;
    }

    void moveParaPosicao(int pos) {
        atual = primeiro;
        for (int i=0; i<pos; i++) {
            atual = atual.proximo;
        }
    }

    void removePrimeiro() {
        primeiro = primeiro.proximo;
        if (primeiro == null)
            ultimo = null;
    }

    void removeIngrediente(int tipo) {
        int pos;
        Ingrediente temp;
        pos = buscaIngredinte(tipo);
        if (pos > -1) {
            temp = this.atual.proximo;
            pos--;
            moveParaPosicao(pos);
            atual.proximo=temp;
            Principal.lblInfo.setText(Principal.lblInfo.getText()+" ganhou um ingrediente");
        } else {
            Principal.lblInfo.setText(Principal.lblInfo.getText()+" não ganhou o ingrediente");
        }
    }

    @Override
    public String toString() {
        String string = this.nome+": ";
        atual = primeiro;
        while (atual != null) {
            switch (atual.tipo) {
                case CEBOLA:
                    string += "Cebola, ";
                    break;
                case BROCOLIS:
                    string += "Brócolis, ";
                    break;
                case QUEIJO:
                    string += "Queijo, ";
                    break;
                case CALABRESA:
                    string += "Calabresa, ";
                    break;
                case TOMATE:
                    string += "Tomate, ";
                    break;
                case OVO:
                    string += "Ovo, ";
                    break;
                case PRESUNTO:
                    string += "Presunto, ";
                    break;
                case AZEITONA:
                    string += "Azeitona, ";
                    break;
                case MILHO:
                    string += "Milho, ";
                    break;
                case ERVILHA:
                    string += "Ervilha, ";
                    break;
            }
            atual = atual.proximo;
        }
        return string;
    }
}
