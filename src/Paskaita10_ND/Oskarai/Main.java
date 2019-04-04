package Paskaita10_ND.Oskarai;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String duomenuFailas = new File("").getAbsolutePath() + "/src/Paskaita10_ND/Oskarai/duomenys.txt";
        Filmas[] duomenys = gautiDuomenis(duomenuFailas);
        String rezultatuFailas = new File("").getAbsolutePath() + "/src/Paskaita10_ND/Oskarai/rezultatai.txt";
        rasyti(rezultatuFailas, duomenys);

    }

    private static Filmas[] gautiDuomenis(String failas) {
        Filmas[] arr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            Integer filmuKiekis = Integer.parseInt(br.readLine());
            arr = new Filmas[filmuKiekis];

            for (int i = 0; i < filmuKiekis; i++) {
                String[] duomenys = br.readLine().split("\\s+");

                Integer metai = Integer.parseInt(duomenys[0]);
                String pavadinimas = duomenys[1];
                Integer[] laikas = {Integer.parseInt(duomenys[2]), Integer.parseInt(duomenys[3])};
                Integer ziurovai = Integer.parseInt(duomenys[4]);

                Filmas obj = new Filmas(pavadinimas, metai, laikas, ziurovai);
                arr[i] = obj;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }


    private static void rasyti(String failas, Filmas[] duomenys) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {

            Filmai skaiciavimai = new Filmai(duomenys);
            output.write("Seniausias filmas: " + Filmai.gautiFilmuMasyvoPavSuMetais(skaiciavimai.seniausiasFilmas()) + "\n");
            output.write("Naujausias filmas: " + Filmai.gautiFilmuMasyvoPavSuMetais(skaiciavimai.naujausiasFilmas()) + "\n");
            output.write("Ilgiausias filmo pavadinimas: " + Filmai.gautiFilmuMasyvoPav(skaiciavimai.ilgiausiasPav()) + "\n");
            output.write("Ilgiausia filmo trukme: " + Filmai.gautiFilmuMasyvoPavSuTrukme(skaiciavimai.ilgiausiaTrukme()) + "\n");
            output.write("Ziurimiausias filmas: " + Filmai.gautiFilmuMasyvoPavSuZiurovais(skaiciavimai.ziurimiausi()) + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}