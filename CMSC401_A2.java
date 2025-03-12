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
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
            }
            
            // median y-coordinate with quickSelect
            int yMedian = quickSelect(y, 0, n - 1, n / 2);// y array, starting index = 0, ending index =n-1, median in array = n/2
            
            // Print median
            System.out.println(yMedian);
        }
        
        // Close scanner
        sc.close();
    }

    // Quickselect algorithm
    private static int quickSelect(int[] arr, int left, int right, int k) {
        while (left < right) { //while left bound is less than right bound
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, left, right);
            
            // If the pivot index is the k-th element, return it
            if (k == pivotIndex) {
                return arr[k];
            } 
            // If k is less than the pivot index, search in the left part
            else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } 
            // If k is greater than the pivot index, search in the right part
            else {
                left = pivotIndex + 1;
            }
        }
        // Return the k-th element
        return arr[left];
    }

    // Partition
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        
        // Move elements less than or equal to the pivot to the left
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // swap pivot to correct position
        swap(arr, i + 1, right);
        return i + 1;
    }

    // Swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
