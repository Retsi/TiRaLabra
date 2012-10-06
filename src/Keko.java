import java.util.ArrayList;
 
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Lauri
 */
public class Keko {
 
   // private ArrayList<Integer> keko;
    private ArreiList keko;
 
    public Keko() {
        keko = new ArreiList();
    }
 
    public int vasen(int indeksi) {
        return 2 * indeksi + 1;
    }
 
    public int oikea(int indeksi) {
        return 2 * indeksi + 2;
    }
 
    public int parent(int indeksi) {
 
        if (indeksi <= 0) {
            return -1;
        }
 
        if (indeksi % 2 == 0) {
            return (indeksi / 2) - 1;
        } else {
            return (indeksi / 2);
        }
    }
 
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
 
    public int heapMax() {
        if (keko.size() == 0) {
            return -1;
        }
        int isoin = keko.get(0);
        return isoin;
 
    }
 
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
 
    public void heapify(int indeksi) {
        int vasen = vasen(indeksi);
        int oikea = oikea(indeksi);
 
        int suurin;
 
        if (oikea + 1 <= keko.size()) {
            if (keko.get(vasen) > keko.get(oikea)) {
                suurin = vasen;
            } else {
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
    }
 
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
 
    public void heapDecKey(int indeksi, int arvo) {
        if (indeksi >= 0 && indeksi < keko.size()) {
            if (arvo < keko.get(indeksi)) {
                keko.set(indeksi, arvo);
                heapify(indeksi);
            }
        }
    }
 
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
 
    public ArreiList getKeko() {
        return keko;
    }
}