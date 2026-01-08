package Day8;

import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSequence {
    

        // brute:
        // time: O(n3)
        // space: O(1)
        // 

        // public static int longestConsecutive(int[] arr) {
        //     int n = arr.length;
        //     int longest = 0;

        //     for (int i = 0; i < n; i++) {
        //         int x = arr[i];
        //         int count = 1;

        //         while (linearSearch(arr, x + 1)) {
        //             x = x + 1;
        //             count++;
        //         }

        //         longest = Math.max(longest, count);
        //     }
        //     return longest;
        // }

        // static boolean linearSearch(int[] arr, int target) {
        //     for (int x : arr) {
        //         if (x == target) return true;
        //     }
        //     return false;
        // }

        // better:
        // space: O(n log n)
    //         // time: O(1)
    // public static int longestConsecutive(int[] arr) {
    //     if (arr.length == 0) return 0;

    //     Arrays.sort(arr);

    //     int longest = 1;
    //     int count = 1;

    //     for (int i = 1; i < arr.length; i++) {

    //         // duplicate skip
    //         if (arr[i] == arr[i - 1]) continue;

    //         // consecutive
    //         if (arr[i] == arr[i - 1] + 1) {
    //             count++;
    //         } else {
    //             count = 1;
    //         }

    //         longest = Math.max(longest, count);
    //     }
    //     return longest;
    // }


    // optimal
    // space: O(n)
    // time: O(1)

    public static int longestConsecutive(int[] arr) {

    HashSet<Integer> set = new HashSet<>();
    for (int x : arr) set.add(x);

    int longest = 0;

    for (int x : set) {

        // sequence start point
        if (!set.contains(x - 1)) {

            int count = 1;
            int curr = x;

            while (set.contains(curr + 1)) {
                curr++;
                count++;
            }

            longest = Math.max(longest, count);
        }
    }
    return longest;
}





}