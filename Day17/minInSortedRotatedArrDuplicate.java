package Day17;

public class minInSortedRotatedArrDuplicate {
    // find min element in rotated sorted arr with unique elements 

    // brute 
    public static int searchMinBrute(int[] arr, int x){
        int n=arr.length;
        int min=arr[0];

        for(int i=0;i<n;i++){
            if(arr[i] < min){
                min=arr[i];
            }

        }
        return min;


    }

    public static void main(String[] args){
        int[] arr={4,5,6,7,0,1,2};

        System.out.println(searchMinBrute(arr, 5));

    }
    
}
