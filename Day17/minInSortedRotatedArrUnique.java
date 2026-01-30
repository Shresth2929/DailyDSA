package Day17;

public class minInSortedRotatedArrUnique {

    // find min element in rotated sorted arr with unique elements 

    // brute 
    // time:O(n)
    public static int searchMinBrute(int[] arr){
        int n=arr.length;
        int min=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i] < min){
                min=arr[i];
            }

        }
        return min;

    }

    // optimal
    // time: O(log2 n)

    public static int searchMinOptimal(int [] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int min=Integer.MAX_VALUE;

        while(low <= high){

              // if current segment is already sorted
            if(arr[low] <=arr[high]){
                min=Math.min(min,arr[low]);
                break;
            }

            int mid=(low+high)/2;


        // left half sorted
            if(arr[low] <= arr[mid]){
                min=Math.min(min,arr[low]);

                low=mid+1;
            }
            
        // right half sorted
        else{
                min=Math.min(min,arr[mid]);
                high=mid-1;
            }


        }
        return min;

    }


    public static void main(String[] args){
        int[] arr={4,5,6,7,0,1,2};

        System.out.println(searchMinBrute(arr));
        System.out.println(searchMinOptimal(arr));

    }
    
}
