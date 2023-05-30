import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelegramBot {

    private static final String API_TOKEN = "5938466999:AAHsOK5kLmMgoY0Hecwjjbq_fgnsC1HnAuw";
    private static final String BASE_URL = "https://web.telegram.org/k/#@Sambhavifirstbot" + 5938466999:AAHsOK5kLmMgoY0Hecwjjbq_fgnsC1HnAuw + "/";

    public static void main(String[] args) {
        try {
            // Get updates from the Telegram bot API
            String response = sendGetRequest(BASE_URL + "getUpdates");

            // Process the response
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Send a GET request to the specified URL and return the response
    private static String sendGetRequest(String url) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();

        try {
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }
}
