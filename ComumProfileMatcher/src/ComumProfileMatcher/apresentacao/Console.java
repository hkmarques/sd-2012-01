package ComumProfileMatcher.apresentacao;

import ComumProfileMatcher.interfaces.dados.DTOProduto;

public class Console {

    public static void exibaDadosProduto(DTOProduto produto) {
        System.out.printf("#%d", produto.getCodigo());
    }

}
