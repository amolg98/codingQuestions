package Extra;

public class MergeSort {
    
    public void merge(int[] arr, int low, int mid, int high) {    
        // Calculate temp arrays size
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temp arrays
        for(int i=0; i<n1; i++)
            L[i] = arr[low+i];
        
        for(int j=0; j<n2; j++)
            R[j] = arr[mid+1+j];
        
        int k = low, x=0, y=0;
        while (x < n1 && y < n2 ) {
            if (L[x] <= R[y]) {
                arr[k] = L[x];
                x++;
            } else {
                arr[k] = R[y];
                y++;
            }
            k++;
        }
        
        while(x < n1) {
            arr[k] = L[x];
            x++;
            k++;
        }
        
        while(y < n2) {
            arr[k] = R[y];
            y++;
            k++;
        }       
        
    }
    
    public void sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high-low)/2;
            
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            
            merge(arr, low, mid, high);
        }
    }

    // Print array
    public void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        MergeSort mSort = new MergeSort();

        System.out.println("Given Array");
        mSort.printArray(arr);
 
        mSort.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        mSort.printArray(arr);
    }
}
