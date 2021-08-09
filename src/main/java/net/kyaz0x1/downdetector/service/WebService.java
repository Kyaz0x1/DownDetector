package net.kyaz0x1.downdetector.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class WebService {

    private static WebService INSTANCE;

    private WebService(){}

    public int getResponseCode(String link) throws IOException {
        final URL url = new URL(link);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode();
    }

    public static WebService getInstance(){
        if(INSTANCE == null){
            synchronized(WebService.class){
                if(INSTANCE == null){
                    INSTANCE = new WebService();
                }
            }
        }
        return INSTANCE;
    }

}