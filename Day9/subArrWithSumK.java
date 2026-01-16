import java.util.*;


public class subArrWithSumK{

    // brute: 
    // time: O(N3)
    // space: O(1)
    // public static int countSubarrays(int[] arr, int t){
    //     int c=0;
        
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i;j<arr.length;j++){
    //             int s=0;
    //             for(int k=i; k<=j;k++){
    //                 s+=arr[k];
    //             }
    //             if(s==t){
    //                 c++;
    //             }
    //         }
    //     }return c;

    // }

    // better
    // // time: O(N2)
    // space: O(1)
    // public static int countSubarrays(int[] arr, int t){
    //     int c=0;
    //     for(int i=0;i<arr.length;i++){
    //         int s=0;
    //         for(int j=i;j<arr.length;j++){
    //             s+=arr[j];
    //         if(s==t){
    //             c++;
    //         }}
    //     }

    //     return c;
    // }

    // optimal:prefix sum & hashmap
    // time: O(N)
    // space: O(n)

    public static int countSubarrays(int[] arr, int t){
        int c=0;
        int s=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            s+=arr[i];

            if(map.containsKey(s-t)){
                c+=map.get(s-t);
            }

            map.put(s,map.getOrDefault(s,0)+1);

        }

        return c;

    }



public static void main(String[] args){
    int[] arr={1,2,3,-3,1,1,1,4,2,-3};
    int t=3;
    System.out.println(countSubarrays(arr,t));




}
}