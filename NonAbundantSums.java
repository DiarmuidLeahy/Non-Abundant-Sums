import java.util.ArrayList;

public class NonAbundantSums {
    
    ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
    ArrayList<Integer> listOfNonSum = new ArrayList<Integer>();
    
    public NonAbundantSums() {
        findListOfNonSum();
        System.out.println("The sum is: " + getSumListOfNonSum());
        
    }
    
    private int getSumListOfNonSum() {
        int total = 0;
        for(int i : listOfNonSum) {
            total += i;
        }
        return total;
    }
    
    private void findListOfNonSum() {
        for(int i = 1; i < 28123; i++) {
            if(checkIfProductOfAbundant(i) == false) {
                listOfNonSum.add(i);
            }
            if(checkAbundance(i)) {
                abundantNumbers.add(i);
            }
        }
    }
    
    private boolean checkAbundance(int checkNum) {
        ArrayList<Integer> checkNumDivisors = new ArrayList<Integer>();
        int sumOfDivisors = 0;
        
        checkNumDivisors = divisorList(checkNum);
        
        for(int x : checkNumDivisors) {
            sumOfDivisors += x;
        }
        if(sumOfDivisors > checkNum) {
            return true;
        }
        return false;        
    }
    
    private boolean checkIfProductOfAbundant(int checkNum) {
        for(int x : abundantNumbers) {
            for(int y: abundantNumbers) {
                if((x + y) == checkNum) {
                    return true;
                }
            }
        }
        return false;    
    }
    
    private ArrayList<Integer> divisorList (int divisor) {
        
        ArrayList<Integer> dList = new ArrayList<Integer>();
        
        for(int i = 2; i <= divisor; i++) {
            if(divisor % i == 0) {
                dList.add(divisor / i);
            }
        }    
        return dList; 
    } //End divisorList method
}
