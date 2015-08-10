package entekrishi.com.krishitest.Rest;


import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Santhosh.Joseph on 07-08-2015.
 */
public class Api {
    private static Reader mReader;

    public static Reader getData(String url) {
        InputStream in = null;
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.connect();
            Log.i(".RestApi", "Response code = " + connection.getResponseCode());
            if (connection.getResponseCode() == 200) {
                in = new BufferedInputStream(connection.getInputStream());
                mReader = new InputStreamReader(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mReader;
    }
}
