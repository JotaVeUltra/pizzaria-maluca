package pizzaria;

class Ingrediente {
    int tipo;
    Ingrediente proximo;
    boolean coletado;

    Ingrediente(int tipo){
        super();
        this.tipo = tipo;
        this.proximo = null;
        this.coletado = false;
    }
}
