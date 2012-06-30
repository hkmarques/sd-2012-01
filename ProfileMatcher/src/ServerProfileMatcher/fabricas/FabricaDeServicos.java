package ServerProfileMatcher.fabricas;

import ComumProfileMatcher.interfaces.servicos.ProfileMatcher;
import ServerProfileMatcher.servico.ServicoProfileMatcher;

public class FabricaDeServicos {

    // TODO: TESTAR SEM LIMITAR INSTANCIAĆÃO
    private static ProfileMatcher profileMatcher;

    public static ProfileMatcher crieProfileMatcher() {
        if (profileMatcher == null) {
            profileMatcher = new ServicoProfileMatcher();
        }

        return profileMatcher;
    }

}
