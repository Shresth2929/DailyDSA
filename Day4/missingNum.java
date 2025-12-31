package Day4;

import java.util.*;

public class missingNum {


    // brute force 
    // tc & sc O(n²) O(1)

//    public static int findMissingNum(int[] arr) {

//         int n = arr.length;  // Array ka size

//         // 0 se n tak har possible number check karenge
//         for(int num = 0; num <= n; num++){

//             boolean found = false;  // Flag reset har num ke liye

//             // Poora array search kar rahe hain
//             for(int i = 0; i < n; i++){

//                 if(arr[i] == num){
//                     found = true;   // Number mil gaya
//                     break;
//                 }
//             }

//             // Poora array check hone ke baad
//             // Agar number nahi mila → wahi missing
//             if(!found){
//                 return num;
//             }
//         }

//         return -1; // Safety
//     }


    // better: hashing
    // tc & sc -> O(n), O(n)
//     public static int findMissingNum(int [] arr){
//       int n = arr.length;  
//     // Array ka size nikal rahe hain
//     // Numbers ka range hoga: 0 se n tak

//     boolean[] seen = new boolean[n + 1];  
//     // Boolean array banaya to mark numbers present or not
//     // Index = number, value = true (present) / false (absent)

//     for(int i = 0; i < n; i++){
//         // Array ke har element ko mark kar rahe hain
//         seen[arr[i]] = true;  
//         // Jo number array me hai us index ko true mark kar do
//     }
//     for(int i = 0; i <= n; i++){
//         // 0 se n tak check kar rahe hain kaunsa number missing hai
//         if(!seen[i]){  
//             // Jo index false reh gaya wahi missing number hai
//             return i;
//         }
//     }
//     return -1;  
//     // Safety return (normally yahan nahi aata)
// }


    // optimal solution
    // tc & sc -> O(n), O(1)
    // 1: sum of n natural numbers

    // public static int findMissingNum(int [] arr){
    //     int n=arr.length;
    //     int nsum=(n*(n+1))/2;
    //     int s=0;
    //     for(int i:arr){
    //         s+=i;

    //     }
    //     return nsum-s;

    // }

    // 2. XOR method 
    public static int findMissingNum(int [] arr){
        int n=arr.length;
        int xor=0;
        for(int i=0;i<n;i++){
          xor ^= i;        // XOR with expected number
        xor ^= arr[i];  // XOR with actual array element
    }

    xor ^= n;  // last number include karo (0..n)

    return xor;  // missing number

    }



     public static void main(String[] args){
         int arr1[] ={0,1,2,4,5};
         System.out.println(findMissingNum(arr1));
         

        
     }
}
