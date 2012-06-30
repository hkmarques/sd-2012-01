package interfaces.servicos;

import interfaces.dados.DTOProduto;
import interfaces.dados.DTORequisicao;

import java.util.Set;

public interface ProfileMatcher {

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ------------------------------------------ MANIPULAĆÃO DE PRODUTOS ----------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    void cadastreProduto(DTOProduto produto);

    void atualizeProduto(DTOProduto produto);

    DTOProduto consulteProduto(int codigo);

    DTOProduto excluaProduto(int codigo);

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ----------------------------------------------- PROFILE MATCHING ------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    Set<DTOProduto> consulteProdutosCompativeis(DTORequisicao requisicao);
}
