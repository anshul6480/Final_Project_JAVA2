/**
 * Make set operations between two sets of integers
 */
import java.util.Scanner;
public class SetOperations {
    public static void main(String[] args) { 
        final int MAX_SIZE = 100;
        
        int[] setA = new int[MAX_SIZE];
        int[] setB = new int[MAX_SIZE];
        int[] setDifference = new int[MAX_SIZE];
        int nA=0;
        int nB=0; 
        int nSetDifference=0;
        
        System.out.println("Reading set A");
        nA = readSet(setA);
        
        System.out.println("Reading set B");
        nB = readSet(setB);
        
        nSetDifference = computeSetDifference(setA, nA, setB, nB, setDifference);
            
        System.out.println("Printing set Difference");
        printSet(setDifference, nSetDifference);
        
    }
    
    //Return the number of elements of the array read 
    private static int readSet(int[] set){
        Scanner input = new Scanner(System.in);
        
        int n = readNumberOfElements();
        
        for(int i=0; i < n; i++) {
            System.out.print("Enter element " + i + ": ");
            set[i] = input.nextInt(); 
        }
        
        return n;
    }
    
    private static int readNumberOfElements(){
        Scanner input = new Scanner(System.in);
        boolean continueReading; 
        int n =0;
        
        do {
            try {
                continueReading = false;
                System.out.print("Enter number of elements: ");
                n = input.nextInt();
            }catch(Exception ex) {
                 continueReading = true;
                 System.out.println("You must enter an integer");
                 input.nextLine();
            }  
        }while (continueReading == true); 
        
        return n;
    }
    
    private static void printSet(int[] set, int n) {
        for(int i =0; i < n; i++) {
            System.out.println("Element " + i + " :" + set[i]);
        }
    }
    
    /* Take each element in the array SetA and comparte to
     * all the element in array setB.
     * If an element from the array setA does not exist in the
     * array setB, this element is copied to the array setDifference
     */
    private static int computeSetDifference(int[] setA, int nA, int[] setB, int nB, int[] setDifference){
        boolean existIntheOtherSet = false;
        int nSetDifference = 0;
        
        for(int i=0; i < nA; i++) {
            for (int j=0; j < nB; j++) {
                if (setA[i] == setB[j]) {
                    existIntheOtherSet = true;
                }
            }
            if (!existIntheOtherSet) {
                setDifference[nSetDifference] = setA[i];
                nSetDifference++;  
            }
        }
        return nSetDifference;
    }   
}
