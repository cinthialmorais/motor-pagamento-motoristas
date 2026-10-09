package br.com.unidiasup.corridas;

/**
 * Representa um motorista genérico da plataforma de mobilidade.
 * Cada categoria concreta define a sua própria regra de pagamento líquido.
 */
public abstract class Motorista {

    private final String nome;
    private final String placaVeiculo;
    private int quantidadeCorridasNoMes;
    private double valorBrutoArrecadado;

    protected Motorista(String nome, String placaVeiculo) {
        validarTextoObrigatorio(nome, "nome");
        validarTextoObrigatorio(placaVeiculo, "placa do veículo");
        this.nome = nome;
        this.placaVeiculo = placaVeiculo.toUpperCase();
        this.quantidadeCorridasNoMes = 0;
        this.valorBrutoArrecadado = 0.0;
    }

    public void registrarCorrida(double valorCorrida) {
        validarValorCorrida(valorCorrida);
        quantidadeCorridasNoMes++;
        valorBrutoArrecadado += valorCorrida;
    }

    public abstract double calcularPagamentoLiquido();

    public abstract String getCategoria();

    protected double descontarPercentualDaPlataforma(double percentualTaxa) {
        return valorBrutoArrecadado * (1 - percentualTaxa);
    }

    public String getNome() {
        return nome;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public int getQuantidadeCorridasNoMes() {
        return quantidadeCorridasNoMes;
    }

    public double getValorBrutoArrecadado() {
        return valorBrutoArrecadado;
    }

    private void validarValorCorrida(double valorCorrida) {
        if (valorCorrida <= 0) {
            throw new IllegalArgumentException("O valor da corrida deve ser maior que zero.");
        }
    }

    private void validarTextoObrigatorio(String texto, String descricaoCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("O campo " + descricaoCampo + " é obrigatório.");
        }
    }
}
