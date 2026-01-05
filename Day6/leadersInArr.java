package Day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leadersInArr {

    // brute
    // public static List<Integer> leaders(int[] arr) {
    //     int n = arr.length;
    //     List<Integer> ans = new ArrayList<>();

    //     for (int i = 0; i < n; i++) {
    //         boolean isLeader = true;

    //         // Right side check
    //         for (int j = i + 1; j < n; j++) {
    //             if (arr[j] > arr[i]) {
    //                 isLeader = false;
    //                 break;
    //             }
    //         }

    //         if (isLeader) {
    //             ans.add(arr[i]);
    //         }
    //     }
    //     return ans;
    // }


    // optimal
    public static List<Integer> leaders(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int maxRight = arr[n - 1]; // last element hamesha leader
        ans.add(maxRight);

        // Right se left traverse
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                ans.add(arr[i]);
            }
        }

        // Reverse because right se add kiya
        Collections.reverse(ans);
        return ans;
    }
}
