package org.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpUtil {
    public static String invoke(String urlString) {
        StringBuilder responseBuilder = new StringBuilder();
        try {
            var url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    responseBuilder.append(inputLine);
                }
                bufferedReader.close();
            } else {
                System.out.println(responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();
    }

    public static <T> T convertJsonToObjectByGson(String jsonString, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> T convertJsonToObjectByObjectMapper(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        try {
            object = objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
