package Day21;
import java.util.*;

public class agressiveCows {
    // (min distance b/w cows ) is max 
    // You must place cows in stalls such that  Minimum distance between any two cows is maximum

    // brute 
    // time: O(n log n + n * maxDist)
    public static int agreesiveCowsBrute(int[] arr, int cows){
        Arrays.sort(arr);

        int n=arr.length;
        int maxDist=arr[n-1]-arr[0];
        int ans=0;
        for(int i=1;i <maxDist;i++){
            if (canPlace(arr,i,cows)){
                ans=i;
            }
        }

        return ans;
    }

    public static boolean canPlace(int[] arr, int dis, int cows){
        int count =1;
        int placeLast=arr[0];

        for(int i=1;i<arr.length;i++){
            if (arr[i] - placeLast >=dis){
                count++;
                placeLast=arr[i];
            }
            if(count >=cows){
                return true;
            }
        }
        return false;
    }


    // optimal :
    // time: (n log n + log(maxDis))

    public static int agressiveCowsOptimal(int[] arr, int cows){
        Arrays.sort(arr);

        int n=arr.length;

        int low=1;
        int high=arr[n-1]-arr[0];
        int ans=0;

        while(low <= high){
            int mid=(low+high)/2;

            if(canPlace(arr, mid, cows)){
                ans =mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;

    }


     public static void main(String[] args) {
        int[] arr={0,3,4,7,10,9};
        int cows=4;
        System.out.println(agreesiveCowsBrute(arr, cows));
        System.out.println(agressiveCowsOptimal(arr, cows));

    }
    
}
