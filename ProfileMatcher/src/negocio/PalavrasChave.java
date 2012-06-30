package negocio;

import java.util.*;

public class PalavrasChave {

    private Set<String> palavrasChave;

    public PalavrasChave() {
        this.palavrasChave = new HashSet<String>();
    }

    public boolean contem(String palavra) {
        return palavrasChave.contains(palavra);
    }

    public void adicione(String palavra) {
        palavrasChave.add(palavra);
    }

    public String remova(String palavra) {
        palavrasChave.remove(palavra);
        return palavra;
    }

    public void adicione(List<String> palavras) {
        palavrasChave.addAll(palavras);
    }

    public void remova(List<String> palavras) {
        palavrasChave.removeAll(palavras);
    }
}
