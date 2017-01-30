package rs.aleph.android.example12.activities;

/**
 * Created by androiddevelopment on 30.1.17..
 */

public class Jelo {
    /*сликом, називом, описом, категоријом, састојцима,
калоријском вредношћу и ценом*/
    private int id;
    private String slika;
    private String naziv;
    private  String opis;
    private String kategorija;
    private String sastojci;
    private int kalorije;
    private float cena;

    public int getId() {
        return id;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public int getKalorije() {
        return kalorije;
    }

    public void setKalorije(int kalorije) {
        this.kalorije = kalorije;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public Jelo() {
    }

    public Jelo(String slika, String naziv, String opis, String kategorija, String sastojci, int kalorije, float cena) {
        this.slika = slika;
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.sastojci = sastojci;
        this.kalorije = kalorije;
        this.cena = cena;
    }
}
