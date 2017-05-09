package br.usjt.continentes.continentes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.continentes.continentes.R;

/**
 * Created by rafaela 201517003.
 */
public class MainActivity extends AppCompatActivity {
    EditText textNome;
    ArrayList<Continente> lista;
    ContinentesRequest continentesRequest;
    Intent intent;
    String chave;

    public static final String LISTA = "br.usjt.continentes.continentes.lista";
    public static final String CHAVE = "br.usjt.continentes.continentes.busca";
    public static final String SERVIDOR = "https://restcountries.eu";
    public static final String APPSTRING = "/rest/v2";
    public static final String RECURSO = "/regionalbloc/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_continentes);
    }

    /**
     * @param view
     */
    public void buscarContinente(View view) {
        // Intent intent = new Intent(this, ListarClientesActivity.class);
        intent = new Intent(this, ListarContinentes.class);
        //String nome = textNome.getText().toString();
        chave = textNome.getText().toString();
        //intent.putExtra(CHAVE, nome);
        continentesRequest = new ContinentesRequest();
        if (continentesRequest.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        chave = "eu";
                        lista = continentesRequest.get(SERVIDOR + APPSTRING + RECURSO, chave);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
