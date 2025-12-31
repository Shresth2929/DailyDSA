package Day4;

import java.util.HashMap;

public class appearsOnlyOnce {

    // brute force:
    // tc=O(n2) sc=O(1)
    // public static int appearsOnlyOnce(int[] arr){
    //    // Har element ko ek-ek karke check karenge
    // for (int i = 0; i < arr.length; i++) {
    //     int count = 0; // current element ka count
    //     // Poore array me arr[i] ka count
    //     for (int j = 0; j < arr.length; j++) {
    //         if (arr[i] == arr[j]) {
    //             count++;
    //         }
    //     }
    //     // Agar sirf ek baar aaya
    //     if (count == 1) {
    //         return arr[i];
    //     }}
    // return -1; // safety
    // }

    // better : hashing
    // doesn't work with big numbers
    // Time Complexity: O(n) ✅
    // Space Complexity: O(n) ❌ (extra memory)/

    // map.put(num, map.getOrDefault(num, 0) + 1);
    // Step 1: Current count nikaalo
    // Step 2: +1 karo
    // Step 3: Map me update karo
    public static int appearsOnlyOnce(int[] arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0 )+1);
            
        }
        for( int i: map.keySet()){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
    }

    // optimal : xor (same numbers will cancel each other)
    // Time Complexity: O(n) ✅
    // Space Complexity: O(1) ✅ (BEST)
    // public static int appearsOnlyOnce(int[] arr){
    //     int xor=0;
    //     for(int i:arr){
    //         xor=xor^arr[i];
    //     }
    //     return xor;

    // }

    public static void main(String[] args){
        int [] arr={1,1,2,3,3,4,4};
        System.out.println(appearsOnlyOnce(arr));



    }
    
}
