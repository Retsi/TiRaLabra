/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmsainio
 */
public class DKeko {
    
    private ArreiList keko;
    private int d;
    
    public DKeko(int d){
        keko = new ArreiList();
        this.d = d;
    }
    
    public int parent(int indeksi){
        if(indeksi <= 0){
            return -1;
        }
        if(indeksi%d == 0){
            return indeksi/d;
        }
        else
            return (indeksi/d)-1;
    }
    
    public int getIsoinLapsi(int indeksi){
        int isoin = -1;
        if (keko.size() == 0){
            return isoin;
        }
        int ekanLapsenIndeksi = indeksi*this.d+1;
        isoin = ekanLapsenIndeksi;
        if (ekanLapsenIndeksi >= keko.size())
            return -1;
        for(int i = 1; i < d && ekanLapsenIndeksi+i < keko.size(); i++){
            if(keko.get(ekanLapsenIndeksi+i)>keko.get(isoin)){
                isoin = ekanLapsenIndeksi+i;
            }
        }
        return isoin;
    }
    
    public int heapMax(){
        if (keko.size() == 0)
            return -1;
        else
            return keko.get(0);
    }
    
    public ArreiList getKeko() {
        return keko;
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
    
    public void heapify(int indeksi) {
 
        int suurin = getIsoinLapsi(indeksi);
 
            if (keko.get(indeksi) < keko.get(suurin)) {
                int luku = keko.get(indeksi);
                keko.set(indeksi, keko.get(suurin));
                keko.set(suurin, luku);
                heapify(suurin);
            }
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
    
}
