package Day15;



public class noOfOccurances {

    // count = lastOccurrence(x) - firstOccurrence(x) + 1

    public static int firstOccurance(int[] arr, int x){
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

    public static int lastOccurance(int[] arr, int x){
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


    public static int countOccurrences(int[] arr, int x) {
        int first = firstOccurance(arr, x);
        if (first == -1) return 0;

        int last = lastOccurance(arr, x);
        return last - first + 1;
    }

    public static void  main(String[] args){
        int []arr={2,4,6,8,8,8,11,13};
        System.out.println(countOccurrences(arr, 8));


    }
    
}
