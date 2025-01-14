package desafios.faturamentomensal;

/*
4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
• SP – R$67.836,43
• RJ – R$36.678,66
• MG – R$29.229,88
• ES – R$27.165,48
• Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  

 */

public class FaturamentoMensalDeUmaDistribuidora {
    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        System.out.printf("Percentual de SP: %.2f%%\n", (sp / total) * 100);
        System.out.printf("Percentual de RJ: %.2f%%\n", (rj / total) * 100);
        System.out.printf("Percentual de MG: %.2f%%\n", (mg / total) * 100);
        System.out.printf("Percentual de ES: %.2f%%\n", (es / total) * 100);
        System.out.printf("Percentual de Outros: %.2f%%\n", (outros / total) * 100);
    }
}
