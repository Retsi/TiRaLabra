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
    
}
