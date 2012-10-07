import java.util.ArrayList;
 
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *Kolmikeon ilmentymä operaatioineen.
 * @author Lauri
 */
public class KolmiKeko {
 
   // private ArrayList<Integer> keko;
    private ArreiList keko;
 
    /**
     * Keon konstruktori. Alustaa keon uudeksi ArreiListiksi.
     */
    public KolmiKeko() {
        keko = new ArreiList();
    }
 
    /**
     * Palauttaa indeksin vasemmanpuolisen indeksin.
     * @param indeksi Indeksi jonka vasemmanpuolisen lapsen indeksi halutaan.
     * @return Vasemmanpuolisen lapsen indeksi.
     */
    public int vasen(int indeksi) {
        return 3 * indeksi + 1;
    }
 
    /**
     * Palauttaa indeksin oikeanpuolisen indeksin.
     * @param indeksi Indeksi jonka oikeanpuolisen lapsen indeksi halutaan.
     * @return Oikeanpuolisen lapsen indeksi.
     */
    public int oikea(int indeksi) {
        return 3 * indeksi + 3;
    }
    
    /**
     * Palauttaa indeksin keskimmäisen indeksin.
     * @param indeksi Indeksi jonka keskimmäisen lapsen indeksi halutaan.
     * @return Keskimmäisen lapsen indeksi.
     */
    public int keski(int indeksi){
        return 3 * indeksi + 2;
    }
 
    /**
     * Palauttaa vanhemman indeksin.
     * @param indeksi Indeksi jonka vanhemman indeksi halutaan.
     * @return Vanhemman indeksi.
     */
    public int parent(int indeksi) {
 
        if (indeksi <= 0) {
            return -1;
        }
 
        if(indeksi%3 == 0){
            return indeksi/3-1;
        }
        else
            return indeksi/3;
    }
 
    /**
     * Lisää kekoon luvun.
     * @param luku Luku joka halutaan lisätä kekoon.
     */
    public void heapInsert(int luku) {
        int indeksi = keko.size();
        keko.add(luku);
 
        while (indeksi > 0 && keko.get(parent(indeksi)) < luku) {
            int apuluku = keko.get(parent(indeksi));
            keko.set(indeksi, apuluku);
            keko.set(parent(indeksi), luku);
            indeksi = parent(indeksi);
        }
    }
 
    /**
     * Palauttaa keon suurimman (huipulla olevan) arvon.
     * @return Keon suurin arvo.
     */
    public int heapMax() {
        if (keko.size() == 0) {
            return -1;
        }
        int isoin = keko.get(0);
        return isoin;
 
    }
 
    /**
     * Palauttaa keon suurimman (huipulla olevan) arvon ja poistaa sen keosta.
     * @return Keon suurin arvo.
     */
    public int heapDelMax() {
        int isoin = -1;
 
        if (keko.size() <= 0) {
            return -1;
        } else {
 
            int indeksi = keko.size() - 1;
            isoin = keko.get(0);
            keko.set(0, keko.get(indeksi));
            keko.remove(indeksi);
            heapify(0);
        }
        return isoin;
    }
 
    /**
     * Siirtää indeksistä löytyvän arvon sen oikealle paikalle kekoon.
     * @param indeksi Indeksi jota siirretään.
     */
    public void heapify(int indeksi) {
        int vasen = vasen(indeksi);
        int oikea = oikea(indeksi);
        int keski = keski(indeksi);
 
        int suurin;
 
        if (oikea + 1 <= keko.size()) {
            if (keko.get(vasen) > keko.get(oikea) && keko.get(vasen) > keko.get(keski)) {
                suurin = vasen;
            }
            else if(keko.get(keski) > keko.get(vasen) && keko.get(keski) > keko.get(oikea)){
                suurin = keski;
            }
                else {
                suurin = oikea;
            }
            if (keko.get(indeksi) < keko.get(suurin)) {
                int luku = keko.get(indeksi);
                keko.set(indeksi, keko.get(suurin));
                keko.set(suurin, luku);
                heapify(suurin);
            }
        } else if (vasen + 1 == keko.size() && keko.get(indeksi) < keko.get(vasen)) {
            int luku = keko.get(indeksi);
            keko.set(indeksi, keko.get(vasen));
            keko.set(vasen, luku);
        }
        else if(keski + 1 == keko.size() && keko.get(indeksi) < keko.get(keski)){
            int luku = keko.get(indeksi);
            keko.set(indeksi, keko.get(keski));
            keko.set(keski, luku);
        }
    }
 
    /**
     * Kasvattaa indeksistä löytävää arvoa.
     * @param indeksi Indeksi josta löytyvää arvoa kasvatetaan.
     * @param arvo Arvo joksi indeksistä löytyvä arvo kasvatetaan.
     */
    public void heapIncKey(int indeksi, int arvo) {
        if (indeksi >= 0 && indeksi < keko.size()) {
            if (arvo > keko.get(indeksi)) {
                keko.set(indeksi, arvo);
            }
            while (indeksi > 0 && keko.get(parent(indeksi)) < arvo) {
                int apuluku = keko.get(parent(indeksi));
                keko.set(indeksi, apuluku);
                keko.set(parent(indeksi), arvo);
                indeksi = parent(indeksi);
            }
        }
 
    }
 
    /**
     * Pienentää indeksistä löytyvää arvoa.
     * @param indeksi Indeksi josta löytyvää arvoa pienennetään.
     * @param arvo Arvo joksi indeksistä löytyvä arvo pienennetään.
     */
    public void heapDecKey(int indeksi, int arvo) {
        if (indeksi >= 0 && indeksi < keko.size()) {
            if (arvo < keko.get(indeksi)) {
                keko.set(indeksi, arvo);
                heapify(indeksi);
            }
        }
    }
 
    /**
     * Järjestää keon kasvavaan järjestykseen.
     * @return Palauttaa järjestetyn taulukon.
     */
    public ArreiList heapSort() {
        ArreiList sortattuKeko = new ArreiList();
        for (int i = keko.size() - 1; i >= 0; i--) {
            sortattuKeko.add(0, keko.get(0));
            keko.set(0, keko.get(keko.size() - 1));
            keko.remove(keko.size() - 1);
            heapify(0);
        }
        return sortattuKeko;
    }
 
    /**
     * Palauttaa keon.
     * @return ArreiList ilmentymä keosta.
     */
    public ArreiList getKeko() {
        return keko;
    }
}