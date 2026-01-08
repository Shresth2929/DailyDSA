package Day8;

import java.util.*;

public class NextPermutation {

    // optimal
    // time: O(n)
    // space: O(1)

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;

        //  breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // Agar breakpoint nahi mila matlb last permutation
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Find just greater element from right
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }

        //  Reverse the right part
        reverse(arr, index + 1, n - 1);
    }

    
    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
