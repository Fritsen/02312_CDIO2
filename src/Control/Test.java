package Control;

import Boundary.TUI;
import Entity.DieCup;

public class Test {
    final private int NUMBER_OF_ROLLS = 1000;
    
    private DieCup dieCup;
    
    /**
     * Constructor to create a new DieCup.
     */
    public Test() {
        dieCup = new DieCup();
    }
    
    /**
     * Start a test of the DieCup.
     */
    public void startTest() {
        
        int i, pairFrequency;
        int[] valueFrequency = new int[13];
        
        //Set all frequency vars to 0, so we can sum up
        pairFrequency = 0;
        for(i=0; i<13; i++) {
            valueFrequency[i] = 0;
        }
        
        //Roll alot of times and count the result
        for(i=0; i<NUMBER_OF_ROLLS; i++) {
            dieCup.shakeDieCup();
            valueFrequency[dieCup.getSum()]++;
            
            if(dieCup.getEns()) {
                pairFrequency++;
            }
        }
        
        //Write result to console
        TUI.printTestResult(NUMBER_OF_ROLLS, pairFrequency, valueFrequency);
    }
} 