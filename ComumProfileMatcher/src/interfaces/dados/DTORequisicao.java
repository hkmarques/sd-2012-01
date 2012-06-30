package interfaces.dados;

import java.util.HashSet;
import java.util.Set;

public class DTORequisicao {

    private String usuario;

    private Set<DTOPerfilRequisicao> perfisDaRequisicao;

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // ----------------------------------------- CONSTRUTORES ----------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    public DTORequisicao() {
        this.perfisDaRequisicao = new HashSet<DTOPerfilRequisicao>();
    }

    public DTORequisicao(Set<DTOPerfilRequisicao> perfis) {
        this.perfisDaRequisicao = perfis;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -------------------------------------- MÉTODOS PÚBLICOS ---------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    public void adicionePerfil(DTOPerfilRequisicao perfil) {
        this.perfisDaRequisicao.add(perfil);
    }

    public DTOPerfilRequisicao removaPerfil(DTOPerfilRequisicao perfil) {
        this.perfisDaRequisicao.remove(perfil);
        return perfil;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -------------------------------------- GETTERS / SETTERS --------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Set<DTOPerfilRequisicao> getPerfisDaRequisicao() {
        return perfisDaRequisicao;
    }

    public void setPerfisDaRequisicao(Set<DTOPerfilRequisicao> perfisDaRequisicao) {
        this.perfisDaRequisicao = perfisDaRequisicao;
    }
}
