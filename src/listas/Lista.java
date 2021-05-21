/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

public class Lista {

    Nodo cabeca;
    Nodo cauda;
  
    public void inserir(int valor) {
        Nodo novoNodo = new Nodo();
        novoNodo.valor = valor;
        if (cabeca == null && cauda == null) {
            cabeca = novoNodo;
            cauda = novoNodo;
            return;
        }
        cauda.proximo = novoNodo;
        cauda = novoNodo;
    }

    public void removerCabeca() {
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
            return;
        }
        cabeca = cabeca.proximo;
        
    }

    public void print(Nodo nodoAtual,javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!!");
            return;
        } 
          
            do {
                txText2.append(nodoAtual.valor +"");
                nodoAtual = nodoAtual.proximo;
            } while (nodoAtual != null);
        
    }

    public void removerPosicao(Nodo nodoAtual, int posicao) {
        int posAux = 0;
        do {

            if (posicao - 1 == posAux) {
                nodoAtual.proximo = nodoAtual.proximo.proximo;
                
                return;
            }
            if (posicao == posAux) {
                removerCabeca();
               
            }
            nodoAtual = nodoAtual.proximo;
            posAux++;
        } while (nodoAtual != null);

    }

    public void removerValor(int valor,javax.swing.JTextArea txText2) {
        if(cabeca==null && cauda==null){
        txText2.setText("Lista vazia!");
        return;
        }
          Nodo nodoAtual = cabeca;
        do {

            if (valor == nodoAtual.proximo.valor) {
                nodoAtual.proximo = nodoAtual.proximo.proximo;
                return;
            }

            if (nodoAtual.proximo == null) {
                break;
            }

            if (valor == nodoAtual.valor) {
                removerCabeca();
                return;
            }

            nodoAtual = nodoAtual.proximo;

        } while (nodoAtual != null);

    }

    public void removerValores(Nodo nodoAtual, int valor, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("lista Vazia");
             return;
        } 
            do {
                if(valor == nodoAtual.valor) {
                    removerValor(valor,txText2);
 
                }
                nodoAtual = nodoAtual.proximo;
            } while (nodoAtual != null);

        
    }
}
