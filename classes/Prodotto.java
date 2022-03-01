package com.classes;

import java.util.Comparator;

public class Prodotto {
    String codice;
    String descrizione;
    String categoria;
    int quantita;
    double prezzo;

    //Getter
    public String getCodice() {
        return codice;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getQuantita() {
        return quantita;
    }
    public double getPrezzo() {
        return prezzo;
    }
    //Setter
    public void setCodice(String codice) throws Exception {
        if(codice.equals("")) throw new Exception("errore");
        this.codice = codice;
    }
    public void setDescrizione(String descrizione) throws Exception {
        if(descrizione.equals("")) throw new Exception("errore");
        this.descrizione = descrizione;
    }
    public void setCategoria(String categoria) throws Exception {
        if(categoria.equals("alimentare") || categoria.equals("utensile") || categoria.equals("tecnologico"))
            this.categoria = categoria;
        else
            throw new Exception("errore");
    }
    public void setQuantita(int quantita) throws Exception {
        if(quantita <0) throw new Exception("errore");
        this.quantita = quantita;
    }
    public void setPrezzo(double prezzo) throws Exception {
        if(prezzo<0) throw new Exception("errore");
        this.prezzo = prezzo;
    }

    //Costruttore
    public Prodotto(String codice, String descrizione, String categoria, double prezzo, int quantita) throws Exception {
        setCodice(codice);
        setDescrizione(descrizione);
        setCategoria(categoria);
        setQuantita(quantita);
        setPrezzo(prezzo);
    }

    @Override
    public String toString() {
        return "Prodotto {" +
                "codice = " + codice + '\'' +
                ", descrizione = " + descrizione + '\'' +
                ", categoria = " + categoria + '\'' +
                ", quantita = " + quantita +
                ", prezzo = " + prezzo +
                '}';
    }

    public static Comparator <Prodotto> costSorter = (o1, o2) -> (int) (o2.getPrezzo() - o1.getPrezzo());
}