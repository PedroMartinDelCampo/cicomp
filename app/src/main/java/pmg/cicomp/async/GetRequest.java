package pmg.cicomp.async;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pedro on 18/11/16.
 */

public class GetRequest extends AsyncTask<String, Integer, String> {

    public static String BASE_URL = "http://cicomp.herokuapp.com/api/";
    // public static String BASE_URL = "http://10.0.2.2:8000/api/";

    private String url;
    private Listener listener;

    public GetRequest(String url) {
        this.url = url;
    }

    public void setOnResult(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        String data = "";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            InputStream stream = connection.getInputStream();
            data = readData(stream);
            connection.disconnect();
            return data;
        } catch (IOException e) {
            if (connection != null) {
                connection.disconnect();
            }
        } finally {
            return data;
        }
    }

    private String readData(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line, out = "";
        while ((line = reader.readLine()) != null) {
            out += line;
        }
        return out;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        listener.onResult(result);
    }

    public static interface Listener {
        void onResult(String result);
    }
}
