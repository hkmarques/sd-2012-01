package ServerProfileMatcher.servico;

import ComumProfileMatcher.interfaces.dados.DTOProduto;
import ComumProfileMatcher.interfaces.dados.DTORequisicao;
import ComumProfileMatcher.interfaces.servicos.ProfileMatcher;
import ServerProfileMatcher.fabricas.FabricaDeRepositorios;
import ServerProfileMatcher.interfaces.IRepositorioProduto;

import java.util.Set;

public class ServicoProfileMatcher implements ProfileMatcher {
    public void cadastreProduto(DTOProduto produto) {
        RepositorioProduto().cadastre(ConversorProduto.converta(produto));
    }

    public void atualizeProduto(DTOProduto produto) {
        RepositorioProduto().atualize(ConversorProduto.converta(produto));
    }

    public DTOProduto consulteProduto(int codigo) {
        return ConversorProduto.converta(RepositorioProduto().consulte(codigo));
    }

    public DTOProduto excluaProduto(int codigo) {
        return ConversorProduto.converta(RepositorioProduto().exclua(RepositorioProduto().consulte(codigo)));
    }

    public Set<DTOProduto> consulteProdutosCompativeis(DTORequisicao dtoRequisicao) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ------------------------------------- MÉTODOS AUXILIARES --------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    private IRepositorioProduto RepositorioProduto() {
        return FabricaDeRepositorios.crieRepositorioProduto();
    }
}
