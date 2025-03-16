//Govan Henry 3/9/2025 CMSC 401 Assignment 2
import java.util.Scanner;

public class CMSC401_A2 {
    public static void main(String[] args) {
        //read input from stdin
        Scanner sc = new Scanner(System.in);
        
        //number of houses, first line
        int n = sc.nextInt();
        
        // input is N>=2, N<1000000
        if (n >= 2 || n < 1000000) {
            int[] y = new int[n];// first input read as size of y array
            
            // next inputs read into y array
            for (int j = 0; j < n; j++) {
                y[j] = sc.nextInt();
            }
            
            // median y-coordinate with quickSelect
            int yMedian = quickSelect(y, 0, n - 1, n / 2);// y array, starting index = 0, ending index =n-1, median in array = n/2
            
            // Print median
            System.out.println(yMedian);
        }
        
        // Close scanner
        sc.close();
    }

    // Quickselect
    private static int quickSelect(int[] arr, int leftb, int rightb, int k) {
        while (leftb < rightb) { //while left bound is less than right bound
            // Partition the array and get the pivot index
            int pivotInd = partition(arr, leftb, rightb);
            
            // If the pivot index is the k-th element, return it
            if (k == pivotInd) {
                return arr[k];
            } 
            // If k is less than the pivot index, search in the left part
            else if (k < pivotInd) {
                rightb = pivotInd - 1;
            } 
            // If k is greater than the pivot index, search in the right part
            else {
                leftb = pivotInd + 1;
            }
        }
    
        return arr[leftb];
    }

    // Partition
    private static int partition(int[] arr, int leftb, int rightb) {
        int piv = arr[rightb];
        int i = leftb - 1;
        
        // Move elements less than or equal to the pivot to the left
        for (int j = leftb; j < rightb; j++) {
            if (arr[j] <= piv) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // swap pivot to correct position
        swap(arr, i + 1, rightb);
        return i + 1;
    }

    // Swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
