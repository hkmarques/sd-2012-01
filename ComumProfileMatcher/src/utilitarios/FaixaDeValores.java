package utilitarios;

public class FaixaDeValores<Tipo> {

    private Tipo valorMinimo;

    private Tipo valorMaximo;

    public Tipo getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Tipo valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Tipo getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Tipo valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
}
