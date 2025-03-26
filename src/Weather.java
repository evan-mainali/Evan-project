import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {

    Weather(){}


    public String getWeather(){ // returns the result of the weather API
        String api="";

        try {

            String apiUrl = "https://api.weatherapi.com/v1/current.json?key=5e888cebd7084d2bbe5142331252503&q=London&aqi=no";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // stores the API response in the variable api
            api = "API Response: " + response.toString();


        } catch (IOException e) {
            e.printStackTrace();

        }
        return api; // returns the value of the API response.

    }
}
