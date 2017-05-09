package br.usjt.provarafa.continentes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rafaela 201517003.
 */
public class ContinentesRequest {

    OkHttpClient client = new OkHttpClient();

    /**
     * @param url
     * @param chave
     * @return
     * @throws IOException
     */
    public ArrayList<Continente> get(String url, String chave) throws IOException {
        ArrayList<Continente> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                int id = item.getInt("id");
                String nome = item.getString("nome");
                String capital = item.getString("capital");
                String area = item.getString("area");
                String populacao = item.getString("populacao");

                Continente continente = new Continente(id, nome, area, populacao);
                lista.add(continente);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public Bitmap getImage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();
        Bitmap img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }

    /**
     * @param context
     * @return
     */
    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}