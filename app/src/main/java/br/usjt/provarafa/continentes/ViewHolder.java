package br.usjt.provarafa.continentes;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafaela 201517003.
 */
public class ViewHolder {
    private ImageView fotoContinente;
    private TextView nomeContinente, capitalContinente, areaContinente, populacaoContinente;

    public ViewHolder(ImageView fotoContinente, TextView nomeContinente, TextView capitalContinente, TextView areaContinente, TextView populacaoContinente) {
        this.fotoContinente = fotoContinente;
        this.nomeContinente = nomeContinente;
        this.capitalContinente = capitalContinente;
        this.areaContinente = areaContinente;
        this.populacaoContinente = populacaoContinente;
    }

    public ImageView getFotoContinente() {
        return fotoContinente;
    }

    public void setFotoContinente(ImageView fotoContinente) {
        this.fotoContinente = fotoContinente;
    }

    public TextView getNomeContinente() {
        return nomeContinente;
    }

    public void setNomeContinente(TextView nomeContinente) {
        this.nomeContinente = nomeContinente;
    }

    public TextView getCapitalContinente() {
        return capitalContinente;
    }

    public void setCapitalContinente(TextView capitalContinente) {
        this.capitalContinente = capitalContinente;
    }

    public TextView getAreaContinente() {
        return areaContinente;
    }

    public void setAreaContinente(TextView areaContinente) {
        this.areaContinente = areaContinente;
    }

    public TextView getPopulacaoContinente() {
        return populacaoContinente;
    }

    public void setPopulacaoContinente(TextView populacaoContinente) {
        this.populacaoContinente = populacaoContinente;
    }
}
