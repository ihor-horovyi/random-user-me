package me.random.user.service.impl;

import me.random.user.exception.RandomUserGeneratorException;
import me.random.user.service.HttpUrlService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Service for work with http
 *
 * @author ihor.horovyi
 */
public class HttpUrlServiceImpl implements HttpUrlService<String> {

    @Override
    public String sendGet(URL url) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(getHttpURLConnection(url).getInputStream()))) {
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            return response.toString();
        } catch (IOException ex) {
            throw new RandomUserGeneratorException(ex.getMessage(), ex);
        }
    }

    private HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }
}
