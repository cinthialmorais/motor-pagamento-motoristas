package br.com.unidiasup.corridas;

/**
 * Motorista que aluga o veículo da própria plataforma: paga 20% de taxa e
 * tem R$ 800,00 de aluguel descontado. O pagamento nunca fica negativo.
 */
public class MotoristaParceiroFrotista extends Motorista {

    private static final double PERCENTUAL_TAXA_PLATAFORMA = 0.20;
    private static final double ALUGUEL_MENSAL_VEICULO = 800.00;
    private static final double PAGAMENTO_MINIMO = 0.0;

    public MotoristaParceiroFrotista(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double valorAposTaxa = descontarPercentualDaPlataforma(PERCENTUAL_TAXA_PLATAFORMA);
        double valorAposAluguel = valorAposTaxa - ALUGUEL_MENSAL_VEICULO;
        return Math.max(valorAposAluguel, PAGAMENTO_MINIMO);
    }

    @Override
    public String getCategoria() {
        return "Parceiro Frotista";
    }
}
