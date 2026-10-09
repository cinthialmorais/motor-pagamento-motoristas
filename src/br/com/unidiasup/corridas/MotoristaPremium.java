package br.com.unidiasup.corridas;

/**
 * Motorista de alto desempenho: paga apenas 15% à plataforma e recebe
 * um bônus fixo de R$ 2,00 por corrida, somado ao bruto antes da taxa.
 */
public class MotoristaPremium extends Motorista {

    private static final double PERCENTUAL_TAXA_PLATAFORMA = 0.15;
    private static final double BONUS_POR_CORRIDA = 2.00;

    public MotoristaPremium(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public void registrarCorrida(double valorCorrida) {
        super.registrarCorrida(valorCorrida + BONUS_POR_CORRIDA);
    }

    @Override
    public double calcularPagamentoLiquido() {
        return descontarPercentualDaPlataforma(PERCENTUAL_TAXA_PLATAFORMA);
    }

    @Override
    public String getCategoria() {
        return "Premium";
    }
}
