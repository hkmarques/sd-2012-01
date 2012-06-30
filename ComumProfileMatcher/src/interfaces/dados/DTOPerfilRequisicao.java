package interfaces.dados;

import utilitarios.PalavrasChave;

import java.util.Set;

public class DTOPerfilRequisicao {

    private Set<PalavrasChave> palavrasChave;

    private DTOValor<Float> preco;

    private DTOValor<String> tamanho;

    private Set<String> cores;

    private Set<String> tipos;

    private Set<String> marcas;

    private Set<String> termosDescricao;

    public DTOPerfilRequisicao() {
    }
}
