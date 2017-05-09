package br.usjt.provarafa.continentes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.continentes.continentes.R;

/**
 * Created by rafaela 201517003.
 */
public class ContinentAdapter extends BaseAdapter {
    Continente[] continentes;
    Activity context;

    /**
     *
     * @param context
     * @param continentes
     */
    public ContinentAdapter(Activity context, Continente[] continentes) {
        this.context = context;
        this.continentes = this.continentes;
    }

    @Override
    public int getCount() {
        return continentes.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < continentes.length) {
            return continentes[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     *
     * @param i
     * @param viewReciclada
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_continente, viewGroup, false);

            ImageView fotoContinente = (ImageView) view.findViewById(R.id.foto_continente);
            TextView nomeContinente = (TextView) view.findViewById(R.id.nome_continente);
            TextView capitalContinente = (TextView) view.findViewById(R.id.capital_continente);
            TextView areaContinente = (TextView) view.findViewById(R.id.area_continente);
            TextView populacaoContinente = (TextView) view.findViewById(R.id.populacao_continente);
            view.setTag(new ViewHolder(fotoContinente, nomeContinente, capitalContinente, areaContinente, populacaoContinente));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        holder.getNomeContinente().setText(continentes[i].getNome());
        holder.getCapitalContinente().setText(continentes[i].getCapital());
        holder.getAreaContinente().setText(continentes[i].getArea());
        holder.getPopulacaoContinente().setText(continentes[i].getPopulacao());


        return view;
    }
}
