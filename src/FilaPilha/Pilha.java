package FilaPilha;

import java.util.Arrays;
import listas.Nodo;

public class Pilha {

    Nodo cabeca;
    Nodo cauda;
    int tamanho = 0;

    public void inserir(int valor) {
        Nodo novoNodo = new Nodo();
        novoNodo.valor = valor;
        if (cabeca == null && cauda == null) {
            cabeca = novoNodo;
            cauda = novoNodo;
            tamanho++;
            return;
        }
        cauda.proximo = novoNodo;
        cauda = novoNodo;
        tamanho++;
    }

    public void removerCauda(javax.swing.JTextArea txText2) {
          if(cabeca==null && cauda==null){
          txText2.setText("Lista vazia!!");
          return;
          }
          Nodo nodoAtual = cabeca;
        do {
            if (nodoAtual.proximo == cauda) {
                nodoAtual.proximo = null; //trabalha diretamente com a referencia.
                cauda = nodoAtual;
                tamanho--;
                return;
            }
            nodoAtual = nodoAtual.proximo;
        } while (nodoAtual != null);//cabeca = cabeca.proximo.proximo.
    }

    public void print(Nodo nodoAtual, javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!");

        } else {

            String saida = "";
            StringBuffer buffer = new StringBuffer();
            int [] vetPilha = new int[tamanho];
            int contV = 0;
            
            do {

                vetPilha[contV] = nodoAtual.valor;
                nodoAtual = nodoAtual.proximo;
                contV++;
            } while (nodoAtual != null);
            
            //ordenando em formato de pilha o último valor inserido será o de cima e o primeiro o último de baixo
             int i = 0;
             int f = tamanho-1;
            while (i<f) {                
                int posi = vetPilha[i];
                vetPilha[i] = vetPilha[f];
                vetPilha[f] = posi;
                i++; 
                f--;
            }
           for (int cont = 0; cont<vetPilha.length;cont++){
                      saida += vetPilha[cont] + "\n";
           }
              
            buffer.append(saida);
            buffer.reverse();
            txText2.setText(saida);
            
        }
    }
    /*public void print(javax.swing.JTextArea txText2) {
        if ((cabeca == null) && (cauda == null)) {
            txText2.setText("Esta lista esta vazia!");
            return;
        }
         Nodo atual = cabeca;
        int[] array = new int[tamanho];
       
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual.valor;
            atual = atual.proximo;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            txText2.setText("" + array[i] + "");

        }
    }*/

}
