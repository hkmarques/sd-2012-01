package ComumProfileMatcher.interfaces.servicos;

import ComumProfileMatcher.interfaces.dados.DTOProduto;
import ComumProfileMatcher.interfaces.dados.DTORequisicao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface ProfileMatcher extends Remote {

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ------------------------------------------ MANIPULAĆÃO DE PRODUTOS ----------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    void cadastreProduto(DTOProduto produto) throws RemoteException;

    void atualizeProduto(DTOProduto produto) throws RemoteException;

    DTOProduto consulteProduto(int codigo) throws RemoteException;

    DTOProduto excluaProduto(int codigo) throws RemoteException;

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ----------------------------------------------- PROFILE MATCHING ------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    Set<DTOProduto> consulteProdutosCompativeis(DTORequisicao requisicao) throws RemoteException;
}
