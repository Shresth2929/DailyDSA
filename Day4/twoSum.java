package Day4;

import java.util.Arrays;
import java.util.HashMap;



 public class twoSum {
    // brute 
//     public static int[] twoSum(int [] arr, int t){
//         for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 if(arr[i]+arr[j]==t){
//                     return new int[]{i,j};
//                 }

//             }
//         }
//         return new int[]{-1,-1};
//     }

//     // better : hashing
    // for returning indexes its optimal

//     public static int[] twoSum(int[] arr, int target) {

//     HashMap<Integer, Integer> map = new HashMap<>();

//     for (int i = 0; i < arr.length; i++) {

//         int complement = target - arr[i];

//         // Agar complement pehle mil chuka hai
//         if (map.containsKey(complement)) {
//             return new int[]{map.get(complement), i};
//         }

//         // Current number ko map me store karo
//         map.put(arr[i], i);
//     }

//     return new int[]{-1, -1};
// }


    // optimal:two pointers
    public static boolean twoSum(int[] arr, int target) {

    Arrays.sort(arr);

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {

        int sum = arr[left] + arr[right];

        if (sum == target) {
            return true;
        }
        else if (sum < target) {
            left++;
        }
        else {
            right--;
        }
    }

    return false;
}



    public static void main(String[] args) {
        int arr[]={2,6,5,8,11};
        int t=14;
        System.out.println(Arrays.toString(twoSum(arr,t)));
       
    }
    
}
