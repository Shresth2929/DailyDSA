package Day19;

public class singleElementSortedArr {


    // brute:
    // tiome: O(n)  space: O(1)
    public static int findSingleBrute(int[] arr){
        int n=arr.length;
        
        if(n==1) return arr[0];
        // first is single
        if(arr[0] != arr[1]) return arr[0];
        // last is single
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        // check middle elements
        for(int i=1;i<n;i++){
            if(arr[i] !=arr[i-1] && arr[i] !=arr[i+1] ){
                return arr[i];
            }
        }

        return -1;
    }


    // optimal:
    // tiome: O(log2 n)  space: O(1)

    public static int findSingleOptimal(int[] arr){
        int n= arr.length;
        int low=0;
        int high=n-1;

        while(low < high){
            int mid= (high+low)/2;

            if(mid %2 ==1){
                mid --;
            }

            if(arr[mid] == arr[mid+1]){
                low=mid+2;
            }else{
                high=mid;
            }
        }
        return arr[low];
    }


    public static void main(String[] args) {
        int[] arr= {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(findSingleBrute(arr));
        System.out.println(findSingleOptimal(arr));

    }

    
}
