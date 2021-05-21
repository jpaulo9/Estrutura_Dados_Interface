
package FilaPilha;
import listas.Nodo;
import listas.Nodo;

public class FilaProva {

    int tamanho = 0;
    Nodo cabeca;
    Nodo cauda;

    public void inserir(int valor) {
        Nodo novo = new Nodo();
        novo.valor = valor;
        if ((cabeca == null) && (cauda == null)) {
            cabeca = novo;
            cauda = novo;
            tamanho++;
            return;
        }
        cauda.proximo = novo;
        cauda = novo;
        tamanho++;
    }
     
    public void print(javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Lista vazia!!");
              return; 
        } 
        Nodo nodoAtual = cabeca;
            do {
                txText2.setText(txText2.getText() + nodoAtual.valor + " ");
                nodoAtual = nodoAtual.proximo;
               
            } while (nodoAtual != null);
        

    }
    /*public void print(int tamanho, javax.swing.JTextArea txText2) {
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
            txText2.setText("|"+array[i]+"|");

        }
    }*/

    public void removerCabeca(javax.swing.JTextArea txText2) {
        if (cabeca == null && cauda == null) {
            txText2.setText("Esta lista esta vazia!");
            return;
        }
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
            tamanho--;
            return;
        }
        cabeca = cabeca.proximo;
        tamanho--;
    }

    public void removerCauda(javax.swing.JTextArea txText2) {
        if ((cabeca == null) && (cauda == null)) {
            txText2.setText("Esta lista esta vazia!");
            return;
        }
         Nodo atual = cabeca;

        do {
            if (atual.proximo == cauda) {
                atual.proximo = null;
                cauda = atual;
                tamanho--;
                return;

            }
            atual = atual.proximo;

        } while (atual != null);
    }
   

   
}
