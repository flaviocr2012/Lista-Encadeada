package listaligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;


    public void adicionaNoComeco(Object elemento) {
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        if (this.totalDeElementos == 0) {
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;
    }

    @Override
    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;

        for (int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");
            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }


    // adiciona no fim
    public void adiciona(Object elemento) {

        if (totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento, null);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            totalDeElementos++;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição Inexistente");
        }
        Celula atual = primeira;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    // adiciona no meio
    public void adiciona(int posicao, Object elemento) {

        Celula atual = primeira;
        Celula last = null;
        Celula nova = new Celula(elemento);
        int i = 0;

        while (atual != null) {
            atual = atual.getProximo();

            if (i == posicao) {
                last.setProximo(nova);
                nova.setProximo(atual);
                break;
            }
            i++;
            last = atual;
        }
        this.totalDeElementos++;
    }
//        if (posicao == 0) {
//            adicionaNoComeco(elemento);
//        } else if (posicao == totalDeElementos) {
//            adiciona(elemento);
//        } else {
//
//            Celula anterior = new Celula(this.pegaCelula(posicao - 1));
//            Celula nova = anterior.getProximo();
//            anterior.setProximo(nova);
//            this.totalDeElementos++;
//        }


        public Object pega (int posicao){
            return this.pegaCelula(posicao).getElemento();
        }

        public void removeDoComeco () {
            if(this.totalDeElementos == 0) {
                throw new IllegalArgumentException("lista vazia");
            }
            this.primeira = this.primeira.getProximo();
            totalDeElementos--;

            if(this.totalDeElementos == 0) {
                this.ultima = null;
            }
        }

        public void remove ( int posicao){
        }

        public int tamanho () {
            return this.totalDeElementos;
        }

        public boolean contem (Object o){
            return false;
        }

}
