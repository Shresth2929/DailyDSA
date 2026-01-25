package Day11;
import java.util.*;

public class subArrWithXOR {

    // find no of subarrays whose xor will give result k
    
    // brute
    // time: O(n2)     space: O(1)
    public static int countSubArrWithXORk(int[] arr, int k){
        int c=0;
        for(int i=0;i<arr.length;i++){
            int xor=0;
            for(int j=i;j<arr.length;j++){
                xor= xor^arr[j];
                if(xor == k){
                    c++;
                }
            }
        }
        return c;
    }


    // optimal: prefix xor + hashmap
    // time: O(n)     space: O(n)

   

    public static int countSubArrWithXORk3(int[] arr, int k){
        int c=0;
        int xor=0;
        Map<Integer, Integer>map=new HashMap<>();
        map.put(0,1);

        for(int i=0;i< arr.length;i++){
            xor=xor^arr[i];

            int required= xor^k;
            if(map.containsKey(required)){
                c +=map.get(required);

            }
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }

        return c;
    }



     // better  prefix xor 
       // time: O(n2)     space: O(n)

    public static int countSubArrWithXORk2(int[] arr, int k){
        int n=arr.length;
        int c=0;
        int[] prefix=new int[n];
        prefix[0]=arr[0];

        for(int i=1;i<n;i++){
            prefix[i]= prefix[i-1] ^ arr[i];

        }
        for(int i=0 ;i <n ;i++){
            if(prefix[i] ==k) c++;

            for(int j=0;j<i;j++){

            if((prefix[i] ^ prefix[j]) ==k) c++;
           
        }
        }


        return c;
    }








    public static void main(String[] args) {
        int arr[]={4, 2, 2, 6, 4};
        int k=6;
        
        // ans=4

        System.out.println(countSubArrWithXORk(arr, k));
         System.out.println(countSubArrWithXORk2(arr, k));
          System.out.println(countSubArrWithXORk3(arr, k));

    }
    
}
