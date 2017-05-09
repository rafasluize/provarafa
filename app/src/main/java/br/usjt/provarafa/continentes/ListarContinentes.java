package br.usjt.continentes.continentes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.continentes.continentes.R;

/**
 * Created by rafaela 201517003.
 */
public class ListarContinentes extends AppCompatActivity {
    ListView listView;
    Continente[] lista;
    public static final String PAIS = "br.usjt.continentes.continentes.nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_continentes);
        listView = (ListView) findViewById(R.id.lista_de_continentes);
        Intent intent = getIntent();
        //String chave = intent.getStringExtra(MainActivity.CHAVE);
        //lista = Data.buscaClientes(chave);
        ArrayList<Continente> clientes = (ArrayList<Continente>) intent.getSerializableExtra(MainActivity.LISTA);
        lista = clientes.toArray(new Continente[0]);
        BaseAdapter adapter = new ContinentAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Intent intent1 = new Intent(ListarContinentes.this, DetalhePaisActivity.class);
                intent1.putExtra(PAIS, lista[posicao]);
                startActivity(intent1);

            }
        });
    }

}
