package ServerProfileMatcher.interfaces;

import ServerProfileMatcher.negocio.Produto;

public interface IRepositorioProduto {

    Produto consulte(int codigo);

    Produto cadastre(Produto produto);

    Produto exclua(Produto produto);

    void atualize(Produto produto);

}
