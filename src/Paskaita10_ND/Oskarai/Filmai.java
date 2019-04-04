package Paskaita10_ND.Oskarai;

import java.util.Arrays;

public class Filmai {

    private Filmas[] duomenys;

    public Filmai(Filmas[] duomenys) {
        this.duomenys = duomenys;
    }


    public Filmas[] seniausiasFilmas(){
        Integer metai = 3000;
        Filmas[] seniausi = new Filmas[0];
        for(Filmas obj : duomenys){
            if(obj.getSukurimoMetai() < metai){
                metai = obj.getSukurimoMetai();
            }
        }
        for(Filmas obj : duomenys){
            if(obj.getSukurimoMetai().equals(metai)){
                seniausi = pridetiElementa(seniausi, obj);
            }
        }
        return seniausi;
    }

    public Filmas[] naujausiasFilmas(){
        Integer metai = 0;
        Filmas[] naujausi = new Filmas[0];
        for(Filmas obj : duomenys){
            if(obj.getSukurimoMetai() > metai){
                metai = obj.getSukurimoMetai();
            }
        }
        for(Filmas obj : duomenys){
            if(obj.getSukurimoMetai().equals(metai)){
                naujausi = pridetiElementa(naujausi, obj);
            }
        }
        return naujausi;
    }

    // reiktu tobulinti kad neskaiciuotu tarpu tarp filmo zodziu
    public Filmas[] ilgiausiasPav(){
        Integer pavIlgis = 0;
        Filmas[] ilgiausiasPav = new Filmas[0];
        for(Filmas obj : duomenys){
            if(obj.getPavadinimas().length() > pavIlgis){
                pavIlgis = obj.getPavadinimas().length();
            }
        }
        for(Filmas obj : duomenys){
            if(pavIlgis.equals(obj.getPavadinimas().length())){
                ilgiausiasPav = pridetiElementa(ilgiausiasPav, obj);
            }
        }
        return ilgiausiasPav;
    }

    public Filmas[] ilgiausiaTrukme(){
        Integer trukme = 0;
        Filmas[] ilgiausiaTrukme = new Filmas[0];
        for(Filmas obj : duomenys){
            if(obj.getLaikas()[0]*60 + obj.getLaikas()[1] > trukme){
                trukme = obj.getLaikas()[0] + obj.getLaikas()[1];
            }
        }
        for(Filmas obj : duomenys){
            if(trukme.equals(obj.getLaikas()[0]*60 + obj.getLaikas()[1])){
                ilgiausiaTrukme = pridetiElementa(ilgiausiaTrukme, obj);
            }
        }
        return ilgiausiaTrukme;
    }

    public Filmas[] ziurimiausi(){
        Integer ziurovai = 0;
        Filmas[] ziurimiausi = new Filmas[0];
        for(Filmas obj : duomenys){
            if(obj.getZiurovai() > ziurovai){
                ziurovai = obj.getZiurovai();
            }
        }
        for(Filmas obj : duomenys){
            if(ziurovai.equals(obj.getZiurovai())){
                ziurimiausi = pridetiElementa(ziurimiausi, obj);
            }
        }
        return ziurimiausi;
    }




    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ STATINIAI METODAI ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static <T> T[] pridetiElementa(T[] masyvas, T skaicius) {
        masyvas = Arrays.copyOf(masyvas, masyvas.length + 1);
        masyvas[masyvas.length - 1] = skaicius;
        return masyvas;
    }

    public static String gautiFilmuMasyvoPav(Filmas[] masyvas){
        StringBuilder str = new StringBuilder();
        for(Filmas obj : masyvas){
            str.append(obj.getPavadinimas()).append(" ");
        }
        return str.toString();
    }

    public static String gautiFilmuMasyvoPavSuTrukme(Filmas[] masyvas){
        StringBuilder str = new StringBuilder();
        for(Filmas obj : masyvas){
            str.append(obj.getPavadinimas()).append(" ").append(obj.getLaikas()[0]).append("val.").append(obj.getLaikas()[1]).append("min.");
        }
        return str.toString();
    }

    public static String gautiFilmuMasyvoPavSuZiurovais(Filmas[] masyvas){
        StringBuilder str = new StringBuilder();
        for(Filmas obj : masyvas){
            str.append(obj.getPavadinimas()).append(" ").append(obj.getZiurovai()).append(" milijonai ziurovu. ");
        }
        return str.toString();
    }

    public static String gautiFilmuMasyvoPavSuMetais(Filmas[] masyvas){
        StringBuilder str = new StringBuilder();
        for(Filmas obj : masyvas){
            str.append(obj.getPavadinimas()).append(" ").append(obj.getSukurimoMetai()).append(" metai. ");
        }
        return str.toString();
    }








}
