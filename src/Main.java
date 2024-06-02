import web.MyHttpClient;

public class Main {
    public static void main(String[] args) {
        MyHttpClient client = new MyHttpClient();

        try {
            String responseJson = client.sendRequest();

            System.out.println(responseJson);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}