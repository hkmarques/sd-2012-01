package ServerProfileMatcher;

import ComumProfileMatcher.interfaces.servicos.ProfileMatcher;
import ServerProfileMatcher.fabricas.FabricaDeServicos;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public void main(String[] args) {

        try {

            ProfileMatcher profileMatcher = FabricaDeServicos.crieProfileMatcher();
            profileMatcher = (ProfileMatcher) UnicastRemoteObject.exportObject(profileMatcher);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("ProfileMatcher", profileMatcher);

        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }

    }

}
