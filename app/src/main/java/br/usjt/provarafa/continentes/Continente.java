package br.usjt.provarafa.continentes;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by rafaela 201517003.
 */
public class Continente implements Serializable, Comparable<Continente> {
    private Integer id;
    private String nome;
    private String capital;
    private String area;
    private String populacao;

    /**
     *
     * @param id
     * @param nome
     * @param area
     * @param populacao
     */
    public Continente(int id, String nome, String area, String populacao) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.populacao = populacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getImagem() {
        String imagem = nome.substring(0, 3);
        System.out.println("Imagem: " + imagem);
        return "https://restcountries.eu/data/" + nome + ".svg";
    }

    @Override
    public String toString() {
        return "Continente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", area='" + area + '\'' +
                ", populacao='" + populacao + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (populacao != null ? populacao.hashCode() : 0);
        //result = 31 * result + Arrays.hashCode(moeda);
        return result;
    }

    @Override
    public int compareTo(Continente continente) {
        return this.nome.compareTo(continente.getNome());
    }


}
