package pizzaria;

class Elemento {
    int tipo;
    Elemento proximo, anterior;

    Elemento(int tipo){
        super();
        this.tipo = tipo;
        this.proximo = null;
        this.anterior = null;
    }
}
