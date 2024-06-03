import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.CurrencySelector;
import web.MyHttpClient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static MyHttpClient client = new MyHttpClient();
    static CurrencySelector currencySelector = new CurrencySelector();
    static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Conversor conversor = new Conversor(client, currencySelector, gson, scanner);
            conversor.run();
        } catch (InputMismatchException ex) {
            System.out.println("Tipo inválido inserido na leitura. Encerrando programa.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }

    }
}