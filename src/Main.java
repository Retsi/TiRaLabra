
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Lauri
 */
public class Main {
    
    private static Keko keko;
    private static KolmiKeko kolmikeko;
    private static DKeko dkeko;
    
    private static long KekoOperaatiot(ArreiList numerot, Keko keko){
        long aikaAlussa = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            keko.heapInsert(numerot.get(i));
        }
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDecKey(15, 1);
        keko.heapIncKey(856, 1002);
        keko.heapSort();
        
        long aikaLopussa = System.currentTimeMillis();
        
        return aikaLopussa-aikaAlussa;
    }
    
    private static long KolmiKekoOperaatiot(ArreiList numerot, KolmiKeko keko){
        long aikaAlussa = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            keko.heapInsert(numerot.get(i));
        }
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDecKey(15, 1);
        keko.heapIncKey(856, 1002);
        keko.heapSort();
        
        long aikaLopussa = System.currentTimeMillis();
        
        return aikaLopussa-aikaAlussa;
    }
    
    private static long DKekoOperaatiot(ArreiList numerot, DKeko keko){
        long aikaAlussa = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            keko.heapInsert(numerot.get(i));
        }
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDelMax();
        keko.heapDecKey(15, 1);
        keko.heapIncKey(856, 1002);
        keko.heapSort();
        
        long aikaLopussa = System.currentTimeMillis();
        
        return aikaLopussa-aikaAlussa;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArreiList numerot = new ArreiList();
        Scanner scanner = new Scanner(System.in);
        keko = new Keko();
        kolmikeko = new KolmiKeko();
        int d = 0;

        System.out.println("Anna D-Keon lapsien määrä:");
        while(d <= 0){
            d = scanner.nextInt();
        }
        
        dkeko = new DKeko(d);

        for (int i = 0; i < 1000; i++) {
            numerot.add((int) (Math.random() * 1001));
        }
        
        System.out.println("Aikaa keko-operaatioihin kului: " + KekoOperaatiot(numerot, keko) + "ms");
        System.out.println("Aikaa kolmikeko-operaatioihin kului: " + KolmiKekoOperaatiot(numerot, kolmikeko) + "ms");
        System.out.println("Aikaa dkeko-operaatioihin kului: " + DKekoOperaatiot(numerot, dkeko) + "ms");
        
        
    }
}