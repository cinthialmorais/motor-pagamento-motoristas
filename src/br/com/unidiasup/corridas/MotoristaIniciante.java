package br.com.unidiasup.corridas;

/**
 * Motorista em início de jornada: paga 25% à plataforma e, se fizer
 * menos de 5 corridas no mês, sofre uma taxa de inatividade de R$ 50,00.
 */
public class MotoristaIniciante extends Motorista {

    private static final double PERCENTUAL_TAXA_PLATAFORMA = 0.25;
    private static final int MINIMO_CORRIDAS_SEM_PENALIDADE = 5;
    private static final double TAXA_INATIVIDADE = 50.00;

    public MotoristaIniciante(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double valorAposTaxa = descontarPercentualDaPlataforma(PERCENTUAL_TAXA_PLATAFORMA);
        if (estaAbaixoDoMinimoDeCorridas()) {
            return valorAposTaxa - TAXA_INATIVIDADE;
        }
        return valorAposTaxa;
    }

    @Override
    public String getCategoria() {
        return "Iniciante";
    }

    private boolean estaAbaixoDoMinimoDeCorridas() {
        return getQuantidadeCorridasNoMes() < MINIMO_CORRIDAS_SEM_PENALIDADE;
    }
}
