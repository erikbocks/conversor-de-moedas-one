import com.google.gson.Gson;
import schemas.ConvertedResponse;
import schemas.Currency;
import schemas.SelectedCurrencies;
import utils.CurrencySelector;
import utils.Menu;
import web.MyHttpClient;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    public static final int EXIT_CODE = 7;
    private final MyHttpClient client;
    private final CurrencySelector currencySelector;
    private final Gson gson;
    private final Scanner scanner;

    public Conversor(MyHttpClient client, CurrencySelector currencySelector, Gson gson, Scanner scanner) {
        this.client = client;
        this.currencySelector = currencySelector;
        this.gson = gson;
        this.scanner = scanner;
    }

    public void run() throws IOException, InterruptedException {
        while (true) {
            int option = getOption();
            if (option == EXIT_CODE) {
                break;
            } else if (option < 1 || option > EXIT_CODE) {
                System.out.println("\nInsira uma opção válida da lista.");
            } else {
                double value = getValue();
                makeConversion(option, value);
            }
        }
    }

    private int getOption() {
        Menu.mostrarMenuDeEscolha();
        return scanner.nextInt();
    }

    private double getValue() {
        Menu.perguntarValor();
        return scanner.nextDouble();
    }

    private void makeConversion(int option, double value) throws IOException, InterruptedException {
        SelectedCurrencies currencies = currencySelector.selectCurrencies(option - 1);

        Currency originCurrency = currencies.originCurrency();
        Currency targetCurrency = currencies.targetCurrency();

        String response = client.sendRequest(originCurrency, targetCurrency, value);
        ConvertedResponse convertedResponse = gson.fromJson(response, ConvertedResponse.class);

        Menu.mostrarConversao(originCurrency, targetCurrency, value, convertedResponse);
    }
}
