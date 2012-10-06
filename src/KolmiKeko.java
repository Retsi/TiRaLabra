import java.util.ArrayList;
 
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Lauri
 */
public class KolmiKeko {
 
   // private ArrayList<Integer> keko;
    private ArreiList keko;
 
    public KolmiKeko() {
        keko = new ArreiList();
    }
 
    public int vasen(int indeksi) {
        return 3 * indeksi + 1;
    }
 
    public int oikea(int indeksi) {
        return 3 * indeksi + 3;
    }
    
    public int keski(int indeksi){
        return 3 * indeksi + 2;
    }
 
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