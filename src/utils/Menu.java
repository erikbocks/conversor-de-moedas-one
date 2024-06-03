package utils;

import schemas.ConvertedResponse;
import schemas.Currency;

public class Menu {

    public static void mostrarMenuDeEscolha() {
        System.out.println("""
                \n*************************************
                                
                Boas vindas ao Conversor de Moedas do Bock!
                                
                1. Dólar Americano -> Peso Argentino
                2. Peso Argentino -> Dólar Americano
                3. Dólar Americano -> Real Brasileiro
                4. Real Brasileiro -> Dólar Americano
                5. Dólar Americano -> Peso Colombiano
                6. Peso Colombiano -> Dólar Americano
                7. Sair
                                
                **************************************
                                
                Escolha abaixo a opção desejada:
                """);
    }

    public static void mostrarConversao(Currency originCurrency, Currency desiredCurrency, double originValue, ConvertedResponse convertedResponse) {
        System.out.printf("""
                                                
                *******************************
                                                
                1 %s equivalem a %.2f %s
                %.2f %s equivalem a %.2f %s
                                                
                *******************************
                                                
                """, originCurrency, convertedResponse.conversion_rate(), desiredCurrency, originValue, originCurrency, convertedResponse.conversion_result(), desiredCurrency);
    }

    public static void perguntarValor() {
        System.out.println("\nDigite o valor que você deseja converter: \n");
    }
}
