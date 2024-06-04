import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.ConversionHistory;
import utils.CurrencySelector;
import web.MyHttpClient;

import java.nio.channels.UnresolvedAddressException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final MyHttpClient client = new MyHttpClient();
    private static final CurrencySelector currencySelector = new CurrencySelector();
    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConversionHistory conversionHistory = new ConversionHistory();

    public static void main(String[] args) {
        try {
            Conversor conversor = new Conversor(client, currencySelector, gson, scanner, conversionHistory);
            conversor.run();
        } catch (UnresolvedAddressException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Tipo inválido inserido na leitura. Encerrando programa.");
        } catch (Exception ex) {
            System.out.println("Erro de conexão. Verifique a URL da requisição e tente novamente.");
        } finally {
            System.out.println("Programa finalizado.");
        }

    }
}