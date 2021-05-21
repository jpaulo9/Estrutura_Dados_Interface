package listas;

public class ListaDuplicata {//lista duplamente tem um anterior e um posterior, cabeca tem anterior nulo sempre e na cauda o proximo sempre nulo.

    NodoD cabeca;
    NodoD cauda;

    int tamanho = 0;

    public void inserir(int valor) {
        NodoD novoNodo = new NodoD();
        novoNodo.valor = valor;
        tamanho++;

        if (cabeca == null && cauda == null) {//se a lista for vazia,
            cabeca = novoNodo;//cabeca e cauda vao ser o novo elemento.
            cauda = novoNodo;
            return;
        }

        cauda.proximo = novoNodo;//se estiver dois elementos o proximo vai ser a cauda.
        novoNodo.anterior = cauda;//anterior do novo nodo e a cauda.
        cauda = novoNodo;//caso mais de um elemnto.

    }

    public void removerCabeca() {
        boolean nulo = cabeca == null;
        if (nulo) {
            return;
        }
        cabeca = cabeca.proximo;
        cabeca.anterior = null;
        tamanho--;

    }

    public void removerValor(int valor, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista Vazia");
        } else {
            NodoD nodoAtual = cabeca;
            do {
                if (nodoAtual.valor == valor) {
                    NodoD anterior = nodoAtual.anterior;
                    NodoD proximo = nodoAtual.proximo;

                    if (nodoAtual != cabeca) {
                        anterior.proximo = proximo;
                    }
                    if (nodoAtual != cauda) {
                        proximo.anterior = anterior;
                    }

                    if (nodoAtual == cabeca) {
                        cabeca = proximo;
                    }

                    if (nodoAtual == cauda) {
                        cauda = anterior;
                    }

                    tamanho--;
                    return;
                }
                if (nodoAtual.proximo == null) {
                    break;
                }

                nodoAtual = nodoAtual.proximo;
            } while (nodoAtual != null);

        }
    }

    public void removerValores(NodoD nodoAtual, int valor, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");

        } else {

            do {
                if (valor == nodoAtual.valor) {
                    removerValor(valor, txText2);
                }
                nodoAtual = nodoAtual.proximo;

            } while (nodoAtual != null);
        }
    }

    public void removerPosicao(int posicao, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");

        } else {
            int posicaoAtual = 0;
            NodoD nodoAtual = cabeca;

            do {
                if (posicaoAtual == posicao) {
                    NodoD anterior = nodoAtual.anterior;
                    NodoD proximo = nodoAtual.proximo;

                    if (nodoAtual != cabeca) {
                        anterior.proximo = proximo;
                    }
                    if (nodoAtual != cauda) {
                        proximo.anterior = anterior;
                    }

                    if (nodoAtual == cabeca) {
                        cabeca = proximo;

                    }

                    if (nodoAtual == cauda) {
                        cauda = anterior;
                    }

                    tamanho--;
                    return;

                }
                nodoAtual = nodoAtual.proximo;

                posicaoAtual++;
            } while (nodoAtual != null);
        }
    }

    public void consultarDuplicatas(int valor, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia");
        } else {
            int achados = 0;
            NodoD nodoAtual = cabeca;

            do {
                if (nodoAtual.valor == valor) {
                    achados++;
                }

                //achados++;//incrementa.
                nodoAtual = nodoAtual.proximo;

            } while (nodoAtual != null);

            txText2.setText(achados + "");
        }
    }

    public void RetornarPosicao(int valor, javax.swing.JTextArea txText2) {

        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");
            return;
        }
        NodoD nodoAtual = cabeca;
        int posicao = 0;

        do {
            if ((nodoAtual.valor == valor) == true) {
                //txText2.setText(txText2.getText()+ posicao);
                txText2.append(posicao+" ");

            }
            posicao++;
            // System.out.println();

            nodoAtual = nodoAtual.proximo;

        } while (nodoAtual != null);

    }

    public int tamanho() {
        return tamanho;

    }

    public void print(NodoD nodoAtual, javax.swing.JTextArea txText2) {

        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");
            return;
        }
        int x = 1;
        do {
            txText2.setText(txText2.getText() + "Nodo " + x + " : " + nodoAtual.valor + " : ref anterior = "
                    + nodoAtual.anterior + "\tRef Atual = " + nodoAtual + "\n");
            /**///x contador de nodo.
            x++;//incrementa.
            nodoAtual = nodoAtual.proximo;

        } while (nodoAtual != null);

    }

    public void troca(int v1, int v2, javax.swing.JTextArea txText2) {

        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");
            return;
        }
        NodoD nodoAtual = cabeca;
        NodoD n1 = null;
        NodoD n2 = null;

        do {

            if (nodoAtual.valor == v1) {
                n1 = nodoAtual;
            }
            if (nodoAtual.valor == v2) {
                n2 = nodoAtual;
            }

            nodoAtual = nodoAtual.proximo;

        } while (nodoAtual != null);
        n1.valor = v2;
        n2.valor = v1;
    }

    public void inserirPosicao(int pos, int num, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");

        } else {
            int posicaoAtual = 0;
            NodoD nodoAtual = cabeca;
            NodoD novo = new NodoD();
            novo.valor = num;
            do {

                if (posicaoAtual == pos) {
                    NodoD nodoPx = nodoAtual.proximo;
                    nodoAtual.proximo = novo;
                    nodoPx.anterior = novo;
                    novo.proximo = nodoPx;
                    novo.anterior = nodoAtual;
                    tamanho++;
                    return;

                }
                posicaoAtual++;
                nodoAtual = nodoAtual.proximo;

            } while (nodoAtual != null);
        }
    }

}
