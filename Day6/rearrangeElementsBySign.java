package Day6;

import java.util.ArrayList;
import java.util.Arrays;

public class rearrangeElementsBySign {

    // version 1: equal no of + and - negative numberss (total length even)
    //  only brute and optimal exists 

    // brute:
    // time: O(n)
    // Space: O(n)
    // public static int[] rearrangeElementsBySign(int [] arr){
    //     int n=arr.length;
    //     int[] pos=new int[n/2];
    //     int[] neg=new int[n/2];
    //     int p=0;
    //     int q=0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]>0){
    //             pos[p]=arr[i];
    //             p++;
    //         }else{
    //             neg[q]=arr[i];
    //             q++;
    //         }

    //     }
    //     int[] ans=new int[n];
    //     int a=0;
    //     for(int i=0;i<n/2;i++){
    //         ans[a++]=pos[i];
    //         ans[a++]=neg[i];
    //     }
    //     return ans;

    // }

    // optimal 
    // time: O(n)
    // Space: O(n)
    // No extra pos/neg arrays
    // Single traversal

    public static int[] rearrangeElementsBySign(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        int p=0,q=1;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[p]=arr[i];
                p=p+2;
            }else{
                ans[q]=arr[i];
                q=q+2;
            }
        }
        return  ans;
    }

    // version 2: odd size arr
    // brute
    // time: O(n)
    // Space: O(n)

    // public static int[] rearrangeElementsBySign2(int[] arr){
    //      ArrayList<Integer>pos=new ArrayList<>();
    //     //  becausse we dont know theexact size
    //     ArrayList<Integer>neg=new ArrayList<>();
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]>0){
    //             pos.add(arr[i]);
    //         }else{
    //             neg.add(arr[i]);
    //         }
    //     }
    //     int p=0;
    //     int q=0;
    //     int [] ans=new int[arr.length];
    //     int a=0;
    //     while(p<pos.size() && q<neg.size()){
    //         ans[a++]=pos.get(p++);
    //         ans[a++]=neg.get(q++);

    //     }
    //     while(p<pos.size()){
    //         ans[a++]=pos.get(p++);
    //     }
    //     while(q<neg.size()){
    //         ans[a++]=neg.get(q++);
    //     }
    //         return ans;

    // }

    // optimal
    // time: O(n)
    // Space: O(n)
    public static int[] rearrangeElementsBySign2(int[] arr){
          int n = arr.length;
        int[] ans = new int[n];

        int pos = 0, neg = 1;
        int i = 0;

        for (int x : arr) {
            if (x > 0 && pos < n) {
                ans[pos] = x;
                pos += 2;
            } else if (x < 0 && neg < n) {
                ans[neg] = x;
                neg += 2;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        // version 1
        int[] arr={3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeElementsBySign(arr)));
        // version 2
        int[] arr2={-1,2,-4,-5,3,6,-9,0,8,55,89,99};
         System.out.println(Arrays.toString(rearrangeElementsBySign2(arr2)));



    }
    
}
