import com.google.gson.Gson;
import com.google.gson.JsonObject;
import schemas.ConversionData;
import schemas.ConvertedResponse;
import schemas.Currency;
import schemas.SelectedCurrencies;
import utils.ConversionHistory;
import utils.ConversionLog;
import utils.CurrencySelector;
import utils.Menu;
import web.MyHttpClient;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {
    private final int EXIT_CODE = 12;
    private final MyHttpClient client;
    private final CurrencySelector currencySelector;
    private final Gson gson;
    private final Scanner scanner;
    private final ConversionHistory conversionHistory;

    public Conversor(MyHttpClient client, CurrencySelector currencySelector, Gson gson, Scanner scanner, ConversionHistory conversionHistory) {
        this.client = client;
        this.currencySelector = currencySelector;
        this.gson = gson;
        this.scanner = scanner;
        this.conversionHistory = conversionHistory;
    }

    public void run() throws IOException, InterruptedException {
        while (true) {
            int option = getOption();

            int SHOW_HISTORY_CODE = 11;
            if (option == EXIT_CODE) {
                break;
            } else if (!isOptionValid(option)) {
                System.out.println("\nInsira uma opção válida da lista.");
            } else if (option == SHOW_HISTORY_CODE) {
                Menu.mostrarHistorico(conversionHistory.getConvertedValues());
            }else {
                double value = getValue();
                makeConversion(option, value);
            }
        }
    }

    private boolean isOptionValid(int option) {
        return option >= 1 || option <= EXIT_CODE;
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
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

        if (jsonObject.get("result").getAsString().equals("error")) {
            System.out.printf("Houve um erro ao fazer a requisição.\nMensagem: %s", jsonObject.get("error-type").getAsString());
            return;
        }

        ConvertedResponse convertedResponse = gson.fromJson(jsonObject, ConvertedResponse.class);
        ConversionData conversionData = new ConversionData(originCurrency, targetCurrency, value);

        ConversionLog.log(conversionData);
        conversionHistory.add(conversionData);
        Menu.mostrarConversao(conversionData, convertedResponse);
    }
}
