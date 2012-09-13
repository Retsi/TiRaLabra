
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
        
//        Scanner numerot = new Scanner(System.in);
//        ArrayList<Integer> kekoMateriaali = new ArrayList<>();
        Keko keko = new Keko();
        
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
        keko.heapIncKey(856, 1002);
        keko.heapSort();
        long kekoKeonMuodostaminenLopussa = System.currentTimeMillis();
        long kekoAikaaKului = kekoKeonMuodostaminenLopussa-kekoKeonMuodostaminenAlussa;
        System.out.println("Aikaa kului: " + kekoAikaaKului + " ms");
    }
}
