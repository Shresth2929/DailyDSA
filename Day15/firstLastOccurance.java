package Day15;

import java.util.Arrays;

public class firstLastOccurance {

    // brute
    // time: O(n)
    public static int[] firstLastOccuranceBrute(int[] arr, int x){
        int f=-1;
        int l=-1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == x){
                f=i;
                break;
            }
        }
        for(int i=arr.length-1; i>=0;i--){
            if(arr[i]==x){
                l=i;
                break;
            }
        }
        return new int[]{f,l};

    }

    // optimaal
    // time: O(log2 n);
    public static int firstOccuranceOptimal(int[] arr, int x){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;

        while( low <= high){
            int mid=(high+low)/2;

            if(arr[mid] ==x){
                ans=mid;
                high=mid-1;
            }else if(arr[mid] >x){
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return ans;
        
    }

    public static int lastOccuranceOptimal(int[] arr, int x){
         int n = arr.length;
    int low = 0, high = n - 1;
    int ans = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == x) {
            ans = mid;
            low = mid + 1;    // move right
        } else if (arr[mid] > x) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
        
}

    

    public static void  main(String[] args){
        int []arr={2,4,6,8,8,8,11,13};

        System.out.println(Arrays.toString(firstLastOccuranceBrute(arr, 8)));

        System.out.println(firstOccuranceOptimal(arr, 8));
        System.out.println(lastOccuranceOptimal(arr, 8));
        


    }
    
}
