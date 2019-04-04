package Paskaita10_ND.Oskarai;

public class Filmas {

    private String pavadinimas;
    private Integer sukurimoMetai;
    private Integer[] laikas;
    private Integer ziurovai;

    public Filmas(String pavadinimas, Integer sukurimoMetai, Integer[] Laikas, Integer ziurovai) {
        this.pavadinimas = pavadinimas;
        this.sukurimoMetai = sukurimoMetai;
        this.laikas = Laikas;
        this.ziurovai = ziurovai;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public Integer getSukurimoMetai() {
        return sukurimoMetai;
    }

    public Integer[] getLaikas() {
        return laikas;
    }

    public Integer getZiurovai() {
        return ziurovai;
    }

    @Override
    public String toString() {
        return sukurimoMetai + " " + pavadinimas + " " + laikas[0] + " " + laikas[1] + " " + ziurovai;
    }
}
