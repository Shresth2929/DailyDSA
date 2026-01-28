package Day15;

public class searchInsertPosition {

    // binary search
    // tc: O(log 2 n)

    public static int search(int[] arr, int t){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low <= high ){
            int mid= (low+high)/2;

            if(arr[mid] == t){
                ans=mid;
                break;
            } else if( arr[mid] > t){
                high=mid-1;

            }else{
                low=mid+1;
            }

        }
        return ans;

    }

    public static void main(String[] args){
        int[] arr={10,20,30,40,50};
        
        System.out.println(search(arr, 30));
        System.out.println(search(arr, 208));

        
    }
    
}
