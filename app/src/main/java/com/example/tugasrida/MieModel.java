package com.example.tugasrida;

public class MieModel {
    private String namaMie, descMie, hargaMie;
    private int gambarMie;

    public MieModel(String namaMie, String descMie, String hargaMie, int gambarMie) {
        this.namaMie = namaMie;
        this.descMie = descMie;
        this.hargaMie = hargaMie;
        this.gambarMie = gambarMie;
    }

    public String getNamaMie() {

        return namaMie;
    }

    public void setNamaMie(String namaMie) {

        this.namaMie = namaMie;
    }

    public String getDescMie() {

        return descMie;
    }

    public void setDescMie(String descMie) {

        this.descMie = descMie;
    }

    public String getHargaMie() {

        return hargaMie;
    }

    public void setHargaMie(String hargaMie) {

        this.hargaMie = hargaMie;
    }

    public int getGambarMie() {

        return gambarMie;
    }

    public void setGambarMie(int gambarMie) {

        this.gambarMie = gambarMie;
    }
}
