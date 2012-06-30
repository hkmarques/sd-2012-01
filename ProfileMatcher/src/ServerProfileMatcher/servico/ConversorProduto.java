package ServerProfileMatcher.servico;

import ComumProfileMatcher.interfaces.dados.DTOProduto;
import ServerProfileMatcher.negocio.Produto;

import java.lang.reflect.Field;

public class ConversorProduto {

    public Produto converta(DTOProduto dtoProduto) {
        Produto produto = new Produto(dtoProduto.getCodigo());
        copieValores(dtoProduto, produto);
        return produto;
    }

    public DTOProduto converta(Produto produto) {
        DTOProduto dtoProduto = new DTOProduto(produto.getCodigo());
        copieValores(produto, dtoProduto);
        return dtoProduto;
    }

    private static void copieValores(Object origem, Object destino) {
        Field[] campos = DTOProduto.class.getFields();
        for (Field campo : campos) {
            try {
                Produto.class.getField(campo.getName()).set(destino, campo.get(origem));
            } catch (Exception e) {
                System.err.println("Erro ao manipular dados: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
