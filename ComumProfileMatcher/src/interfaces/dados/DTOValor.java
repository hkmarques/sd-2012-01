package interfaces.dados;

import enumeradores.EnumTipoDeValor;
import utilitarios.FaixaDeValores;

import java.util.Set;

public class DTOValor<Tipo> {

    private EnumTipoDeValor tipoDeValor;

    private FaixaDeValores<Tipo> faixaDeValores;

    private Set<Tipo> listaDeValores;

    private Tipo valorEspecifico;

}
