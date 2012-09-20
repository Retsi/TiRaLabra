import java.util.ArrayList;
import java.util.Scanner;
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Lauri
 */
public class Main {
 
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
       
//        ArreiList arreilist = new ArreiList();
//        ArrayList<Integer> arraylist = new ArrayList<>();
//        arraylist.add(5);
//        arreilist.add(5);
//        arraylist.add(6);
//        arreilist.add(6);
//        System.out.println(arraylist);
//        System.out.println(arreilist);
//        System.out.println(arraylist.size());
//        System.out.println(arreilist.size());
//        arraylist.set(0, 4);
//        arreilist.set(0, 4);
//        arraylist.add(5);
//        arreilist.add(5);
//        arraylist.add(7);
//        arreilist.add(7);
//        System.out.println(arraylist);
//        System.out.println(arreilist);
//        arraylist.add(1, 8);
//        System.out.println(arraylist);
//        System.out.println(arreilist);
//        arraylist.remove(1);
//        arreilist.remove(1);
//        System.out.println(arraylist);
//        System.out.println(arreilist);
//        System.out.println(arraylist.size());
//        System.out.println(arreilist.size());
       
       
        Scanner numerot = new Scanner(System.in);
        ArrayList<Integer> kekoMateriaali = new ArrayList<>();
        Keko keko = new Keko();
        KolmiKeko kolmikeko = new KolmiKeko();
        keko.heapInsert(5);
        keko.heapInsert(6);
        keko.heapInsert(7);
        keko.heapInsert(2);
        keko.heapInsert(8);
        keko.heapInsert(9);
        System.out.println(keko.getKeko());
        kolmikeko.heapInsert(5);
        kolmikeko.heapInsert(6);
        kolmikeko.heapInsert(7);
        kolmikeko.heapInsert(2);
        kolmikeko.heapInsert(8);
        kolmikeko.heapInsert(9);
        System.out.println(kolmikeko.getKeko());
       
////        System.out.println("Syötä keon arvot, muu kuin int-arvo lopettaa.");
////        
////        while(numerot.hasNextInt()){
////            int luku = numerot.nextInt();
////            kekoMateriaali.add(luku);
////        }
//        
//        
////        for(int i = 0; i< kekoMateriaali.size(); i++){
////            keko.heapInsert(kekoMateriaali.get(i));
////        }
        long kekoKeonMuodostaminenAlussa = System.currentTimeMillis();
        for(int i = 0; i<1000; i++)
            keko.heapInsert((int) (Math.random() * 1001));
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDecKey(15, 1);
        keko.heapDecKey(856, 1002);
        keko.heapSort();
        long kekoKeonMuodostaminenLopussa = System.currentTimeMillis();
        long kekoAikaaKului = kekoKeonMuodostaminenLopussa-kekoKeonMuodostaminenAlussa;
        System.out.println("Aikaa kului kekoon: " + kekoAikaaKului + " ms");
        kekoKeonMuodostaminenAlussa = System.currentTimeMillis();
        for(int i = 0; i<1000; i++)
            kolmikeko.heapInsert((int) (Math.random() * 1001));
        kolmikeko.heapDelMax();
        kolmikeko.heapDelMax();
        kolmikeko.heapDelMax();
        kolmikeko.heapDecKey(15, 1);
        kolmikeko.heapDecKey(856, 1002);
        kolmikeko.heapSort();
        kekoKeonMuodostaminenLopussa = System.currentTimeMillis();
        kekoAikaaKului = kekoKeonMuodostaminenLopussa-kekoKeonMuodostaminenAlussa;
        System.out.println("Aikaa kului kolmikekoon: " + kekoAikaaKului + " ms");
    }
}