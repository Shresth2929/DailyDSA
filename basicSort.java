package ArrQuestions;   // Folder name (package) where this file is stored


public class basicSort {

    // =================== BUBBLE SORT =====================
    public static void bubble(int [] arr, int n){

        boolean swapped = false;  // Check if any swap happened
        
        for(int i = 0; i < n - 1; i++){    // Outer loop → number of passes
            for(int j = 0; j < n - i - 1; j++){  // Inner loop → compare adjacent elements

                if(arr[j] > arr[j + 1]){    // If element is greater than next → swap
                    int t = arr[j];         // temp me arr[j] store
                    arr[j] = arr[j + 1];    // next element ko current position par lao
                    arr[j + 1] = t;         // temp value ko next position par store karo
                    swapped = true;         // at least 1 swap hua → array not sorted initially
                }
            }
        }

        if(!swapped){   // Agar ek bhi swap nahi hua, array already sorted hai
            System.out.println("Already sorted");
            return;     // Function yahin ruk jaata hai
        }

        // Final sorted output
        System.out.print("Bubble Sorted: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");  // Sorted array print
        }
        System.out.println();
    }



    // =================== SELECTION SORT =====================
    public static void selection(int [] arr, int n){

        for(int i = 0; i < n - 1; i++){     // Outer loop → har position par correct element rakhna
            int smallest = i;               // Assume current i index is smallest

            for(int j = i + 1; j < n; j++){ // Search smallest in remaining array
                if(arr[smallest] > arr[j]){ // If smaller element found
                    smallest = j;           // Update smallest index
                }
            }

            // Swap smallest element with arr[i]
            int t = arr[smallest];          // temp me smallest element store
            arr[smallest] = arr[i];         // arr[i] ko smallest ki jagah dalna
            arr[i] = t;                     // temp ko arr[i] me store karna → correct position
        }

        // Final sorted output
        System.out.print("Selection Sorted: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");  // Sorted array print
        }
        System.out.println();
    }



    // =================== INSERTION SORT =====================
    public static void insertion(int [] arr, int n){

        for(int i = 1; i < n; i++){      // Start from index 1 (first element sorted assume)
            int current = arr[i];        // Element to be placed at correct position
            int j = i - 1;               // Previous index pointer

            // Shift greater elements one position to the right
            while(j >= 0 && current < arr[j]){  // Jab tak left element bada hai
                arr[j + 1] = arr[j];            // Bigger element ko right shift karo
                j--;                            // Ek step aur left move karo
            }

            // Insert the current element at correct sorted position
            arr[j + 1] = current;               // Yaha current ko place karte hain
        }

        // Final sorted output
        System.out.print("Insertion Sorted: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");  // Sorted array print
        }
        System.out.println();
    }



    // =================== MAIN FUNCTION =====================
    public static void main(String[] args) {

        int[] arr = {22, 33, 42, 11, 5, 100};   // Input array
        int n = arr.length;                     // Length of array

        int[] a1 = arr.clone();    // clone array for bubble
        int[] a2 = arr.clone();    // clone for selection
        int[] a3 = arr.clone();    // clone for insertion

        bubble(a1, n);      // Call bubble sort
        selection(a2, n);   // Call selection sort
        insertion(a3, n);   // Call insertion sort
    }
}
