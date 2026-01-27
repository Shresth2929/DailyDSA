package Day14;

public class binarySearch {

    // iterative binary search
    // time: O(log2 n) space: O(1)
    public static int binarySearch(int[] arr, int t){
        int n=arr.length;
        int low=0;
        int  high=n-1;

        while(low <= high){
            int mid= (low+high)/2;

            if(arr[mid] == t){ 
                return mid;
            }
            else if(arr[mid] > t){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    // recursive 
    public static int recursiveBS(int[] arr, int low, int high, int t){
        int n=arr.length;

        if(low > high) return -1;

        int mid= (high+low)/2;

        if(arr[mid] == t){
            return mid;
        } else if(arr[mid] > t){
            return recursiveBS(arr, low, mid-1, t);
        }else{
            return recursiveBS(arr,mid+1, high, t );
        }
        
    }

    public static void main(String[] args){
        int arr[] ={3,4,6,7,9,12,16,17};
        int t=6;
        System.out.println(binarySearch(arr,t));

        System.out.println(recursiveBS(arr,0,arr.length-1, t));


    }
    
}
