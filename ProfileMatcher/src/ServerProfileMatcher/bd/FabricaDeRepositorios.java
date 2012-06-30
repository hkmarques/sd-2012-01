package ServerProfileMatcher.bd;

import ServerProfileMatcher.interfaces.IRepositorioProduto;

public class FabricaDeRepositorios {

    private static IRepositorioProduto repositorioProduto;

    public static IRepositorioProduto crieRepositorioProduto() {
        if (repositorioProduto == null) {
            repositorioProduto = new RepositorioProduto();
        }

        return repositorioProduto;
    }

}
