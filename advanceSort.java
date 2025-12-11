package ArrQuestions;

// Merge Sort + Quick Sort ka combined code
public class advanceSort {

    // ====================== DIVIDE FUNCTION (MERGE SORT) ======================
    public static void divide(int arr[], int low, int high) {

        // Base case → Jab array me 1 hi element bacha ho
        if (low >= high) {
            return;  // Aur divide nahi ho sakta
        }

        // Middle index nikalna (overflow safe formula)
        int mid = low + (high - low) / 2;

        // Left half ko sort karo (low → mid)
        divide(arr, low, mid);

        // Right half ko sort karo (mid+1 → high)
        divide(arr, mid + 1, high);

        // Dono sorted halves ko merge karo
        merge(arr, low, mid, high);
    }


    // ====================== MERGE FUNCTION (MERGE SORT) ======================
    public static void merge(int arr[], int low, int mid, int high) {

        // Temporary array jisme result store karenge
        int temp[] = new int[high - low + 1];

        int left = low;      // Left half ka starting index
        int right = mid + 1; // Right half ka starting index
        int k = 0;           // Temp array ka index

        // Jab tak left aur right dono me elements bache ho
        while (left <= mid && right <= high) {

            // Agar left ka element chhota ya equal hai
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];   // Left wala element temp me daalo
            } 
            else {
                temp[k++] = arr[right++];  // Right wala element temp me daalo
            }
        }

        // Agar left half me elements bache ho
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Agar right half me elements bache ho
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Temp array ko original array me copy karna
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }


    // ====================== QUICK SORT FUNCTION ======================
    public static void quick(int []arr, int low, int high){

        // Base case → Jab ek ya 0 element ho
        if(low < high){

            // Partition function se pivot ki correct position mil jaayegi
            int partitionIndex = part(arr, low, high);

            // LEFT side ko sort karna (pivot ke left wale elements)
            quick(arr, low, partitionIndex - 1);

            // RIGHT side ko sort karna (pivot ke right wale elements)
            quick(arr, partitionIndex + 1, high);
        }
    }


    // ====================== PARTITION FUNCTION (Quick Sort ka heart) ======================
    public static int part(int[] arr, int low, int high){

        int pivot = arr[high];   // Pivot last element liya hai
        int i = low - 1;         // i ko “smaller elements region” dikhane ke liye use karte hain

        // Pure array ko traverse karte hain pivot ke alawa
        for(int j = low; j < high; j++){

            // Agar arr[j] pivot se chhota hai toh left part me aayega
            if(arr[j] < pivot){
                i++;  // Smaller region ko ek step badhao

                // Swap arr[i] & arr[j] → taaki chhota element left side rahe
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // Loop khatam → ab pivot ko uski correct sorted position par rakhna hai
        int t = arr[i + 1];    
        arr[i + 1] = arr[high];  // Pivot ko uske correct index par rakhna
        arr[high] = t;           // Pivot ki old value ko i+1 ke left me shift kiya

        return i + 1;  // Pivot ka final sorted index return karte hain
    }


    // ====================== MAIN FUNCTION ======================
    public static void main(String[] args) {

        // Unsorted array
        int arr[] = {22, 3, 55, 1, 24, 73, 31};
        int n = arr.length;

        // Quick Sort call (merge sort off rakha hai)
        quick(arr,0,n-1);

        // Final sorted array print
        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
