package br.usjt.provarafa.continentes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import br.usjt.continentes.continentes.R;

public class PaisActivity extends AppCompatActivity {

    TextView textViewNome, textViewArea, textViewPopulacao;
    ImageView imagemPais;
    ContinentesRequest clienteRequester;
    Continente continente;

    @Override
    /**
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        textViewNome = (TextView) findViewById(R.id.nome_continente);
        textViewArea = (TextView) findViewById(R.id.area_continente);
        textViewPopulacao = (TextView) findViewById(R.id.populacao_continente);
        imagemPais = (ImageView) findViewById(R.id.foto_continente);
        Intent intent = getIntent();
        continente = (Continente) intent.getSerializableExtra(ListarContinentes.PAIS);

        textViewNome.setText(continente.getNome());
        textViewArea.setText(continente.getArea());
        textViewPopulacao.setText(continente.getPopulacao());

        clienteRequester = new ContinentesRequest();

        new DownloadImage().execute(MainActivity.SERVIDOR
                + MainActivity.APPSTRING
                + "/img/" + continente.getImagem() + ".jpg");

    }

    /**
     *
     */
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return clienteRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result) {
            imagemPais.setImageBitmap(result);
        }
    }
}
