package Day18;

public class howManyTimesArrayRotatedUnique {
     // find the min element and its index will tell the no of times arr is rotated 

    //  .optimal
    // time : O(log2 n)

    public static int noOfTimesArrRotated(int[] arr){
        int n=arr.length;

        int low=0;
        int high=n-1;
        int min=Integer.MAX_VALUE;
        int ansIdx=0;

        while(low<= high){

            if(arr[low] <= arr[high]){
                if(arr[low] < min){
                    min=arr[low];
                    ansIdx=low;
                }
                break;
            }

            int mid=(high+low)/2;
            if(arr[low] <= arr[mid] ){
                if(arr[low] < min){
                    min=arr[low];
                    ansIdx=low;

                }
                low=mid+1;
            }
            else{
                if(arr[mid] < min){
                    min=arr[mid];
                    ansIdx=mid;
                }
                high=mid-1;
            }

        }
        return ansIdx;
    }

    public static void main(String[] args){
        int[] arr={3,4,5,1,2};
        System.out.println(noOfTimesArrRotated(arr));




    }
    
}
