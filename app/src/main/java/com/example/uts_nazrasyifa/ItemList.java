package com.example.uts_nazrasyifa;

public class ItemList {
    private String Image,Judul,Subjudul,Waktu;
    public ItemList(String imageUrl, String Judul, String Subjudul, String Waktu ){
        this.Image = imageUrl;
        this.Judul = Judul;
        this.Subjudul = Subjudul;
        this.Waktu = Waktu;
    }
    public String getImage() {
        return Image;
    }
    public String getJudul() {
        return Judul;
    }
    public String getSubjudul() {
        return Subjudul;
    }
    public String getWaktu() {
        return Waktu;
    }

    public void setImage(String image) {
        Image = image;
    }
    public void setJudul(String judul) {
        Judul = judul;
    }
    public void setSubjudul(String subjudul) {
        Subjudul = subjudul;
    }
    public void setWaktu(String waktu) {
        Waktu = waktu;
    }
}
