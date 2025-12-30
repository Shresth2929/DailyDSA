package Day3;

import java.util.*;

public class longestSubArrWithk {

    // basic(brute force )
    // Negative numbers ke saath bhi kaam karta hai
    // Time complexity = O(n2)
    // Bade arrays ke liye slow

    // public static int longestSubarray(int [] arr, int k){
    //     int maxlen=0;
    //     for(int i=0;i<arr.length;i++){
    //         int sum=0;
    //         for(int j=i;j<arr.length;j++){
    //             sum+=arr[j];
    //             if(sum==k){
    //                 maxlen=Math.max(maxlen,j-i+1);
    //             }
    //         }
    //     }
    //     return maxlen;
    // }

    // better approach 
    // works for negative numbers also
    // hashmap & prefix sum
    // Time: O(n) ✅
    // Space: O(n)

//     public static int longestSubarray(int[] arr, int k){

//     // HashMap banaya: 
//     // key   -> prefix sum
//     // value -> index jahan ye prefix sum pehli baar mila
//     HashMap<Integer, Integer> map = new HashMap<>();

//     int sum = 0;        // Ab tak ka prefix sum (start se current index tak)
//     int maxlen = 0;     // Longest subarray length ka answer

//     // Pure array ko ek baar traverse karenge
//     for(int i = 0; i < arr.length; i++){

//         // Current element ko sum me add kar rahe hain
//         sum += arr[i];

//         // CASE 1:
//         // Agar start (index 0) se i tak ka sum == k ho
//         // to subarray ki length = i + 1
//         if(sum == k){
//             maxlen = i + 1;
//         }

//         // CASE 2:
//         // Agar (sum - k) pehle map me mil chuka hai
//         // to uske baad se i tak ka subarray ka sum = k hoga
//         if(map.containsKey(sum - k)){
//             // Current length = i - oldIndex
//             maxlen = Math.max(maxlen, i - map.get(sum - k));
//         }

//         // Prefix sum ko sirf pehli baar store karte hain
//         // Kyunki pehla index longest subarray banata hai
//         if(!map.containsKey(sum)){
//             map.put(sum, i);
//         }
//     }

//     // Poora array check hone ke baad final answer return
//     return maxlen;
// }


    // optimal sol sliding window 
    // only for posotive numbers

  public static int longestSubarray(int [] arr, int k){

    int l = 0;          // Left pointer (window ka start)
    int r = 0;          // Right pointer (window ka end)
    int sum = 0;        // Current window ka sum
    int maxlen = 0;     // Ab tak ka longest subarray length

    // Jab tak right pointer array ke andar hai
    while(r < arr.length){

        // Right pointer ka element sum me add karo (window expand)
        sum += arr[r];

        // Agar sum k se bada ho gaya
        // to left se elements hatao (window shrink)
        while(sum > k){
            sum -= arr[l];  // Left element ko sum se hatao
            l++;            // Left pointer aage badhao
        }

        // Agar current window ka sum exactly k hai
        if(sum == k){
            // Window length calculate karo aur maxlen update karo
            maxlen = Math.max(maxlen, r - l + 1);
        }

        // Right pointer aage badhao (next element check karne ke liye)
        r++;
    }

    // Poora array check hone ke baad final answer return
    return maxlen;
}


     public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 1, 1, 1}; 
        int k = 3; 
        System.out.println(longestSubarray(arr, k));

        
     }
    }