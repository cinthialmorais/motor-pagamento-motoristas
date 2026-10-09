package br.com.unidiasup.corridas;

import java.util.List;
import java.util.Locale;

/**
 * Simula o fechamento mensal de pagamentos dos motoristas da plataforma.
 */
public class Main {

    private static final Locale LOCALE_BRASIL = Locale.forLanguageTag("pt-BR");
    private static final String LINHA_SEPARADORA = "=".repeat(46);

    public static void main(String[] args) {
        Motorista iniciante = new MotoristaIniciante("Bruno Tavares", "QSD4E21");
        iniciante.registrarCorrida(32.40);
        iniciante.registrarCorrida(18.90);
        iniciante.registrarCorrida(45.00);

        Motorista premium = new MotoristaPremium("Camila Rocha", "RTY7B88");
        premium.registrarCorrida(58.00);
        premium.registrarCorrida(72.50);
        premium.registrarCorrida(41.30);
        premium.registrarCorrida(95.20);
        premium.registrarCorrida(63.00);

        Motorista frotistaComSaldo = new MotoristaParceiroFrotista("Diego Fontes", "PLM2C09");
        registrarCorridasRepetidas(frotistaComSaldo, 40, 35.75);

        Motorista frotistaSemSaldo = new MotoristaParceiroFrotista("Elaine Moura", "KJH5F13");
        frotistaSemSaldo.registrarCorrida(120.00);
        frotistaSemSaldo.registrarCorrida(87.60);

        List<Motorista> motoristas = List.of(iniciante, premium, frotistaComSaldo, frotistaSemSaldo);
        imprimirCabecalhoGeral();
        motoristas.forEach(Main::imprimirExtrato);
    }

    private static void registrarCorridasRepetidas(Motorista motorista, int quantidade, double valorCorrida) {
        for (int corridaAtual = 0; corridaAtual < quantidade; corridaAtual++) {
            motorista.registrarCorrida(valorCorrida);
        }
    }

    private static void imprimirCabecalhoGeral() {
        System.out.println(LINHA_SEPARADORA);
        System.out.println("   UNIDIASUP MOBILIDADE - FECHAMENTO MENSAL");
        System.out.println(LINHA_SEPARADORA);
        System.out.println();
    }

    private static void imprimirExtrato(Motorista motorista) {
        System.out.println("-------------- EXTRATO DO MOTORISTA --------------");
        imprimirLinha("Nome", motorista.getNome());
        imprimirLinha("Categoria", motorista.getCategoria());
        imprimirLinha("Placa", motorista.getPlacaVeiculo());
        imprimirLinha("Corridas no mês", String.valueOf(motorista.getQuantidadeCorridasNoMes()));
        imprimirLinha("Valor bruto", formatarMoeda(motorista.getValorBrutoArrecadado()));
        imprimirLinha("Líquido a receber", formatarMoeda(motorista.calcularPagamentoLiquido()));
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    private static void imprimirLinha(String rotulo, String valor) {
        System.out.printf("  %-20s: %s%n", rotulo, valor);
    }

    private static String formatarMoeda(double valor) {
        return String.format(LOCALE_BRASIL, "R$ %,.2f", valor);
    }
}
