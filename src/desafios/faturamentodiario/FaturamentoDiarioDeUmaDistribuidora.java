package desafios.faturamentodiario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */
public class FaturamentoDiarioDeUmaDistribuidora {
    public static void main(String[] args) {
        try {

            String path = "src/desafios/faturamentodiario/faturamento.json";
            String content = new String(Files.readAllBytes(Paths.get(path)));

            JSONArray faturamentoDiario = new JSONArray(content);

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            // Iterar pelos dias de faturamento
            for (int i = 0; i < faturamentoDiario.length(); i++) {
                JSONObject dia = faturamentoDiario.getJSONObject(i);
                double valor = dia.getDouble("valor");

                // Ignorar dias sem faturamento
                if (valor > 0) {
                    menorFaturamento = Math.min(menorFaturamento, valor);
                    maiorFaturamento = Math.max(maiorFaturamento, valor);
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }


            double mediaFaturamento = somaFaturamento / diasComFaturamento;


            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentoDiario.length(); i++) {
                JSONObject dia = faturamentoDiario.getJSONObject(i);
                double valor = dia.getDouble("valor");

                if (valor > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }


            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}
