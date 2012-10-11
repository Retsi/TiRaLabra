/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lmsainio
 */
public class KekoTest {
    
    public KekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void kekoTestit(){
        Keko keko = new Keko();
        
        keko.heapInsert(2);
        keko.heapInsert(3);
        keko.heapInsert(1);
        keko.heapInsert(5);
        keko.heapInsert(6);
        
        ArreiList ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 6);
        assertEquals(ilmentyma.get(1), 5);
        assertEquals(ilmentyma.get(2), 1);
        assertEquals(ilmentyma.get(3), 2);
        assertEquals(ilmentyma.get(4), 3);
        
        keko.heapIncKey(0, 5);
        ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 6);
        keko.heapDecKey(0, 0);
        ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 5);
        assertEquals(ilmentyma.get(4), 0);
        
        assertEquals(keko.heapDelMax(), 5);
        assertEquals(keko.heapDelMax(), 3);
        assertEquals(keko.heapDelMax(), 2);
        assertEquals(keko.heapMax(), 1);
        assertEquals(keko.heapDelMax(), 1);
        
        keko.heapInsert(5);
        keko.heapInsert(3);
        keko.heapInsert(6);
        
        ilmentyma = keko.heapSort();
        
        String tulostus = "" + ilmentyma;
        
        assertEquals(keko.vasen(0), 1);
        assertEquals(keko.oikea(0), 2);
        assertEquals(keko.vasen(1), 3);
        assertEquals(keko.oikea(1), 4);
        assertEquals(keko.vasen(2), 5);
        assertEquals(keko.oikea(2), 6);
        assertEquals(keko.vasen(3), 7);
        assertEquals(keko.oikea(3), 8);
        
        assertEquals(keko.parent(0), -1);
        assertEquals(keko.parent(3), 1);
        assertEquals(keko.parent(8), 3);
        
        assertEquals(tulostus, "[0, 3, 5, 6]");
    }
    
    @Test
    public void kolmiKekoTestit(){
        KolmiKeko keko = new KolmiKeko();
        
        keko.heapInsert(2);
        keko.heapInsert(3);
        keko.heapInsert(1);
        keko.heapInsert(5);
        keko.heapInsert(6);
        
        ArreiList ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 6);
        assertEquals(ilmentyma.get(1), 5);
        assertEquals(ilmentyma.get(2), 1);
        assertEquals(ilmentyma.get(3), 3);
        assertEquals(ilmentyma.get(4), 2);
        
        keko.heapIncKey(0, 5);
        ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 6);
        keko.heapDecKey(0, 0);
        ilmentyma = keko.getKeko();
        
        assertEquals(ilmentyma.get(0), 5);
        assertEquals(ilmentyma.get(4), 0);
        assertEquals(ilmentyma.get(3), 3);
        
        ilmentyma = keko.getKeko();
        
        assertEquals(keko.heapDelMax(), 5);
        
        ilmentyma = keko.getKeko();
        
        assertEquals(keko.heapDelMax(), 3);
        ilmentyma = keko.getKeko();
        assertEquals(keko.heapDelMax(), 2);
        assertEquals(keko.heapMax(), 1);
        assertEquals(keko.heapDelMax(), 1);
        
        keko.heapInsert(5);
        keko.heapInsert(3);
        keko.heapInsert(6);
        
        ilmentyma = keko.heapSort();
        
        String tulostus = "" + ilmentyma;
        
        assertEquals(keko.vasen(0), 1);
        assertEquals(keko.keski(0), 2);
        assertEquals(keko.oikea(0), 3);
        assertEquals(keko.vasen(1), 4);
        assertEquals(keko.keski(1), 5);
        assertEquals(keko.oikea(1), 6);
        assertEquals(keko.vasen(2), 7);
        assertEquals(keko.keski(2), 8);
        assertEquals(keko.oikea(2), 9);
        assertEquals(keko.vasen(3), 10);
        assertEquals(keko.keski(3), 11);
        assertEquals(keko.oikea(3), 12);
        
        assertEquals(keko.parent(0), -1);
        assertEquals(keko.parent(3), 0);
        assertEquals(keko.parent(8), 2);
        
        assertEquals(tulostus, "[0, 3, 5, 6]");
    }
    
    @Test
    public void ArreiListTestit(){
        ArreiList arreilist = new ArreiList();
        arreilist.add(4);
        arreilist.add(2);
        arreilist.add(5);
        arreilist.add(1);
        arreilist.add(6);
        arreilist.add(6);
        
        assertEquals(arreilist.get(0), 4);
        assertEquals(arreilist.get(1), 2);
        assertEquals(arreilist.get(2), 5);
        assertEquals(arreilist.get(3), 1);
        assertEquals(arreilist.get(4), 6);
        assertEquals(arreilist.get(5), 6);
        assertEquals(arreilist.size(), 6);
        arreilist.remove(4);
        assertEquals(arreilist.size(), 5);
        assertEquals(arreilist.get(4), 6);
        assertEquals(arreilist.get(3), 1);
        arreilist.set(3, 2);
        assertEquals(arreilist.get(3), 2);
        assertEquals(arreilist.get(4), 6);
        arreilist.add(3, 8);
        assertEquals(arreilist.get(3), 8);
        assertEquals(arreilist.get(4), 2);
        assertEquals(arreilist.size(), 6);
    }
}
