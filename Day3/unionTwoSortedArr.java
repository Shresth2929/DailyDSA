
package Day3;
import java.util.*;

public class unionTwoSortedArr {
    
          public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {

        ArrayList<Integer> union = new ArrayList<>();   // Final union yaha store hoga

        int i = 0;  // Pointer for arr1 (left se start)
        int j = 0;  // Pointer for arr2 (left se start)

        // Jab tak dono arrays me elements present ho
        while (i < n && j < m) {

            // Union list ka last element nikaalna (duplicate avoid karne ke liye)
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);

            // CASE 1: Dono arrays ke elements same ho
            if (arr1[i] == arr2[j]) {

                // Duplicate avoid karo
                if (arr1[i] != last) 
                    union.add(arr1[i]);   // Add element

                i++;  // Dono pointers aage badhao
                j++;
            }

            // CASE 2: arr1 ka element chhota hai
            else if (arr1[i] < arr2[j]) {

                if (arr1[i] != last) 
                    union.add(arr1[i]);   // Duplicate nahi ho toh add

                i++;  // Pointer i badhao
            }

            // CASE 3: arr2 ka element chhota hai
            else {

                if (arr2[j] != last) 
                    union.add(arr2[j]);   // Duplicate avoid karke add

                j++;  // Pointer j badhao
            }
        }

        // Agar arr1 me elements bache ho (arr2 khatam ho gaya)
        while (i < n) {
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);

            if (arr1[i] != last) 
                union.add(arr1[i]);   // Unique ho toh add

            i++;  // Pointer i aage badhao
        }

        // Agar arr2 me elements bache ho (arr1 khatam ho gaya)
        while (j < m) {
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);

            if (arr2[j] != last) 
                union.add(arr2[j]);  // Unique ho toh add

            j++;  // Pointer j aage badhao
        }

        return union;  // Final union return
    }


    public static void main(String[] args){
         int arr1[] = {2,3,3,5,4,2,1,4};
        int arr2[] = {6,7,3,2,1,6,3};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<Integer> result =
            findUnion(arr1, arr2, arr1.length, arr2.length);

        System.out.println(result);

    }
    
}
