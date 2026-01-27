package Day14;

public class lowerBound {
    // find smallest index such that arr[i] >=x

    // brute: linear search
    // time: O(n)  space: O(1)
    public static int lowerBoundBrute(int[] arr, int x){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if (arr[i] >=x){
                return i;
            }
        }
        return n;

    } 

    // optimal : binary search(since arr is sorted )
    // time: O(log2 n)            space: O(1)

    public static int lowerBoundOptimal(int[] arr, int x){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n; 

        while(low <=high){
            int mid= (low+high)/2;

            if(arr[mid] >=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

    return ans;

    }


    public static void main(String[] args){
        int arr[] ={3,5,8,15,19};
        int x=8;

        System.out.println(lowerBoundBrute(arr,x));
        System.out.println(lowerBoundOptimal(arr,x));


    }
    
}
