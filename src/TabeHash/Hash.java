package TabeHash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash {

    int tamanho = 0;
    private Map<Integer, ListaDuplicata> mapa = new HashMap<>();

    int Hash(int valor) {
        int gHash = valor % 10;
        return gHash;

    }

    public void inserir(int valor) {
        int chave = Hash(valor);
        ListaDuplicata ld = mapa.get(chave);
        if (ld == null) {
            ld = new ListaDuplicata();
            ld.inserir(valor);
            mapa.put(chave, ld);

        } else {
            ld.inserir(valor);

        }
    }

    public void remover(int valor, javax.swing.JTextArea txText2) {
        int chave = Hash(valor);
        ListaDuplicata ld = mapa.get(chave);
        if (ld != null) {
            ld.removerValor(valor, txText2);
        }
    }

    public void buscar(int valor, javax.swing.JTextArea txText2) {
        int chave = Hash(valor);
        ListaDuplicata ld = mapa.get(chave);
        if (ld != null) {
            int posicao = ld.RetornarPosicao(valor, txText2);
            txText2.append("O valor está na chave" + chave + " na posição: " + posicao + "\n");
        } else {
            txText2.append("Valor não encontrado!");
        }
    }

    public void print(javax.swing.JTextArea txText2) {

        Set<Integer> chaves = mapa.keySet();
        for (Integer chave : chaves) {
            txText2.append("\nChave: " + chave + "\n");
            ListaDuplicata ld = mapa.get(chave);
            ld.print(ld.cabeca, txText2);
        }
    }
}
