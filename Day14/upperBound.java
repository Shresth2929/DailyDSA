package Day14;

public class upperBound {
    // find smallest index such that arr[i] >x

    // brute: linear search
    // time: O(n)  space: O(1)

    public static int upperBoundBrute(int[] arr, int x){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > x){
                return i;
            }
        }
        return n;

    }

     // optimal : binary search(since arr is sorted )
    // time: O(log2 n)            space: O(1)

    public static int upperBoundOptimal(int[] arr, int x){
        int n=arr.length;
        int ans=n;

        int low=0;
        int high=n-1;

        while(low<= high){
            int mid=(high+low)/2;

            if(arr[mid] >x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;

    }


    public static void main(String[] args){
        int arr[]={2,3,6,7,8,8,11,11,11,12};
        int x=11;

        System.out.println(upperBoundBrute(arr,x));
        System.out.println(upperBoundBrute(arr,6));
        System.out.println(upperBoundBrute(arr,12));


        System.out.println(upperBoundOptimal(arr,x));
        System.out.println(upperBoundOptimal(arr,6));
        System.out.println(upperBoundOptimal(arr,12));



    }
    
}
