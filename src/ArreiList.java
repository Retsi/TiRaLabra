    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmsainio
 */
public class ArreiList {

    int[] arreilist;
    int koko;

    public ArreiList() {
        koko = 0;
    }

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

    public void add(int indeksi, int numero) {
        if (koko == 0 && indeksi == 0) {
            arreilist = new int[1];
            koko++;
        }
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

    public int size() {
        if (koko == 0) {
            return -1;
        }
        return koko;
    }

    public int get(int indeksi) {
        return arreilist[indeksi];
    }

    public void set(int indeksi, int arvo) {
        arreilist[indeksi] = arvo;
    }

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
