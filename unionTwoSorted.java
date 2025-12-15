package ArrQuestions;

public class unionTwoSorted {


    public static void main(String[] args){
        int arr1[]={1,2,1,3,2,4,};
        int arr2[]={1,5,6,6,7,5,};
        
        int n1=arr1.length;
        int n2=arr2.length;

        
    
    
}


import java.util.*;

public class UnionSortedArrays {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0;  // pointer for arr1
        int j = 0;  // pointer for arr2

        while (i < n && j < m) {

            // If duplicate in union list, skip
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);

            if (arr1[i] == arr2[j]) {
                if (arr1[i] != last) union.add(arr1[i]);
                i++; j++;
            }
            else if (arr1[i] < arr2[j]) {
                if (arr1[i] != last) union.add(arr1[i]);
                i++;
            }
            else {
                if (arr2[j] != last) union.add(arr2[j]);
                j++;
            }
        }

        // If elements left in arr1
        while (i < n) {
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);
            if (arr1[i] != last) union.add(arr1[i]);
            i++;
        }

        // If elements left in arr2
        while (j < m) {
            int last = union.size() == 0 ? -1 : union.get(union.size() - 1);
            if (arr2[j] != last) union.add(arr2[j]);
            j++;
        }

        return union;
    }


    public static void main(String[] args){
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 5, 6};

        ArrayList<Integer> ans = findUnion(arr1, arr2, arr1.length, arr2.length);

        System.out.println(ans);
    }
}
