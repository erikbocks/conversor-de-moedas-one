package utils;

import schemas.ConversionData;
import schemas.ConvertedResponse;

import java.util.List;

public class Menu {

    public static void mostrarMenuDeEscolha() {
        System.out.println("""
                \n*************************************
                                \s
                Boas vindas ao Conversor de Moedas do Bock!
                                \s
                1. Dólar Americano -> Peso Argentino
                2. Peso Argentino -> Dólar Americano
                3. Dólar Americano -> Real Brasileiro
                4. Real Brasileiro -> Dólar Americano
                5. Dólar Americano -> Peso Colombiano
                6. Peso Colombiano -> Dólar Americano
                7. Real Brasileiro -> Iene Japonês
                8. Iene Japonês -> Real Brasileiro
                9. Real Brasileiro -> Euro
                10. Euro -> Real Brasileiro
                11. Mostrar histórico de conversão
                12. Sair
                                \s
                **************************************
                                \s
                Escolha abaixo a opção desejada:
                """);
    }

    public static void mostrarConversao(ConversionData conversionData, ConvertedResponse convertedResponse) {
        System.out.printf("""
                                                \s
                **************************************
                                                \s
                1 %s equivalem a %.2f %s
                %.2f %s equivalem a %.2f %s
                                                \s
                **************************************
                \s""", conversionData.getOriginCurrency(), convertedResponse.conversion_rate(), conversionData.getTargetCurrency(), conversionData.getValue(), conversionData.getOriginCurrency(), convertedResponse.conversion_result(), conversionData.getTargetCurrency());
    }

    public static void perguntarValor() {
        System.out.println("\nDigite o valor que você deseja converter: \n");
    }

    public static void mostrarHistorico(List<ConversionData> conversionList) {
        System.out.println("\n**************************************");
        for (ConversionData data : conversionList) {
            System.out.println(data);
        }
        System.out.println("**************************************");
    }
}
