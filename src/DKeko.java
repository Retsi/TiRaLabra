/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *D-Keko ilmentymä operaatioineen.
 * @author lmsainio
 */
public class DKeko {

    private ArreiList keko;
    private int d;

    /**
     * DKeko -luokan konstruktori. Alustaa d:n eli lapsien määrän halutuksi ja luo uuden ArreiListin.
     * @param d Haluttu lapsien määrä.
     */
    public DKeko(int d) {
        if (d > 0) {
            keko = new ArreiList();
            this.d = d;
        }
    }

    /**
     * Palauttaa indeksin vanhemman indeksin.
     * @param indeksi Indeksi jonka vanhemman indeksi halutaan.
     * @return Vanhemman indeksi.
     */
    public int parent(int indeksi) {
        if (indeksi <= 0) {
            return -1;
        }
        if (indeksi % d == 0) {
            return indeksi / d - 1;
        } else {
            return (indeksi / d);
        }
    }

    /**
     * Hakee indeksin isoimman lapsen indeksin.
     * @param indeksi Indeksin jonka isoin lapsi halutaan.
     * @return Isoimman lapsen indeksi.
     */
    public int getIsoinLapsi(int indeksi) {
        int isoin = -1;
        if (keko.size() == 0) {
            return isoin;
        }
        int ekanLapsenIndeksi = indeksi * this.d + 1;
        isoin = ekanLapsenIndeksi;
        if (ekanLapsenIndeksi >= keko.size()) {
            return -1;
        }
        for (int i = 1; i < d && ekanLapsenIndeksi + i < keko.size(); i++) {
            if (keko.get(ekanLapsenIndeksi + i) > keko.get(isoin)) {
                isoin = ekanLapsenIndeksi + i;
            }
        }
        return isoin;
    }

    /**
     * Palauttaa keon suurimman (huipulla olevan) arvon.
     * @return Keon suurin arvo.
     */
    public int heapMax() {
        if (keko.size() == 0) {
            return -1;
        } else {
            return keko.get(0);
        }
    }

    /**
     * Palauttaa keon.
     * @return ArreiList ilmentymä keosta.
     */
    public ArreiList getKeko() {
        return keko;
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
     * Siirtää indeksistä löytyvän arvon sen oikealle paikalle kekoon.
     * @param indeksi Indeksi jota siirretään.
     */
    public void heapify(int indeksi) {

        int suurin = getIsoinLapsi(indeksi);

        if (suurin != -1) {

            if (keko.get(indeksi) < keko.get(suurin)) {
                int luku = keko.get(indeksi);
                keko.set(indeksi, keko.get(suurin));
                keko.set(suurin, luku);
                heapify(suurin);
            }
        }
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
}
