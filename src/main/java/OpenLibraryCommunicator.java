import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenLibraryCommunicator {
    private String url;
    private HttpURLConnection connection;

    OpenLibraryCommunicator (String url) {
        this.url = url;
    }
    /**
     * Connects to OpenLibrary
     * Implement interfaces to work with different APIs
     * */


    public String find(){
        String result="";

        connection = connect();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))){

            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine())!=null){
                response.append(responseLine.trim());
            }
            result = response.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            connection.disconnect();
        }
        return result;
    }

    private HttpURLConnection connect(){
        try{
            URL url = new URL(this.url);
            this.connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.connection;
    }

}
