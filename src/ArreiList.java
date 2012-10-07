    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *ArreiList joka vastaa jossainmäärin ArrayList<Integer>:iä.
 * @author lmsainio
 */
public class ArreiList {

    int[] arreilist;
    int koko;

    /**
     * Alustaa vain ArreiList taulukon kooksi 0.
     */
    public ArreiList() {
        koko = 0;
    }

    /**
     * Lisää taulukkoon halutun numeron. Taulukon täyttyessä kaksinkertaistaa sen koon. Ensimmäisellä lisäyksellä luo yhden kokoisen taulukon.
     * @param numero Lisättävä numero.
     */
    public void add(int numero) {
        if (koko == 0) {
            arreilist = new int[1];
            arreilist[0] = numero;
            koko++;
        } else {
            if (koko == arreilist.length) {
                int[] isompitaulukko = new int[arreilist.length * 2];
                for (int i = 0; i < arreilist.length; i++) {
                    isompitaulukko[i] = arreilist[i];
                }
                arreilist = isompitaulukko;
            }
            arreilist[koko] = numero;
            koko++;
        }

    }

    /**
     * Lisää numeron tiettyyn kohtaan taulukkoa siirtäen sen jälkeisiä arvoja taaksepäin.
     * @param indeksi Indeksi mihin kohtaan uusi luku lisätään.
     * @param numero Lisättävä luku.
     */
    public void add(int indeksi, int numero) {
        if (koko == 0 && indeksi == 0) {
            arreilist = new int[1];
            arreilist[0] = numero;
            koko++;
        }
        else{
        if (koko == arreilist.length) {
            int[] isompitaulukko = new int[arreilist.length * 2];
            for (int i = 0; i < arreilist.length; i++) {
                isompitaulukko[i] = arreilist[i];
            }
            arreilist = isompitaulukko;
        }
        int[] jalkeen = new int[koko-indeksi];
        
        for(int i = 0; i < jalkeen.length; i++){
            jalkeen[i] = arreilist[indeksi+i];
        }
        
        arreilist[indeksi] = numero;
        
        for(int i = 0; i < jalkeen.length; i++){
            arreilist[indeksi+i+1] = jalkeen[i];
        }
        koko++;
        }

    }

    /**
     * Palauttaa ArreiListin koon.
     * @return ArreiListin koko.
     */
    public int size() {
        if (koko == 0) {
            return -1;
        }
        return koko;
    }

    /**
     * Paulauttaa arvon halutusta indeksistä.
     * @param indeksi Haluttu indeksi.
     * @return Indeksistä löytyvä arvo.
     */
    public int get(int indeksi) {
        return arreilist[indeksi];
    }

    /**
     * Sijoittaa haluttuun indeksiin tietyn arvon korvaten indeksistä ennestään löytyneen arvon.
     * @param indeksi Indeksi jonne arvo sijoitetaan.
     * @param arvo Haluttu arvo.
     */
    public void set(int indeksi, int arvo) {
        arreilist[indeksi] = arvo;
    }

    /**
     * Poistaa arvon taulukosta halutusta kohdasta.
     * @param indeksi Indeksi josta arvo poistetaan.
     */
    public void remove(int indeksi) {
        int[] ennen = new int[indeksi];
        int[] jalkeen = new int[koko - indeksi - 1];
        for (int i = 0; i < ennen.length; i++) {
            ennen[i] = arreilist[i];
        }
        for (int i = 0; i < jalkeen.length; i++) {
            jalkeen[i] = arreilist[indeksi + 1 + i];
        }
        for (int i = 0; i < ennen.length; i++) {
            arreilist[i] = ennen[i];
        }
        for (int i = 0; i < jalkeen.length; i++) {
            arreilist[indeksi + i] = jalkeen[i];
        }
        koko--;
    }

    public String toString() {
        String tulostus = "[";
        for (int i = 0; i < koko; i++) {
            if (i == koko - 1) {
                tulostus = tulostus + arreilist[i];
            } else {
                tulostus = tulostus + arreilist[i] + ", ";
            }
        }

        return tulostus + "]";
    }
}
