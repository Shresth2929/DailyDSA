package Day20;

public class smallestDivisor {

    // brute
    // Time: O(max(arr) × n)
    // Space: O(1)
    public static int smallestDivisorBrute(int[] arr,int threshold){
        int max=0;

        for(int a: arr){
            max=Math.max(a,max);
        }
        for(int i=1;i<=max ; i++){
            int sum=0;

            for(int num: arr){
                sum +=Math.ceil((double) num/i);
            }
            if(sum <= threshold){
                return i;
            }
        }
        return -1;

    }


    // Optimal (Binary Search)
    // Time: O(n × log(max(arr)))
    // Space: O(1)

    public static int smallestDivisorOptimal(int[] arr, int threshold){
        int low=1;
        int high=0;

        for(int a: arr){
            high=Math.max(a,high);
        }

        int ans=-1;

        while( low <=high ){
            int mid=(low+high)/2;

            int sum=0;
            for( int num: arr){
                sum +=Math.ceil((double) num/mid);

            }
            if(sum <= threshold){
                ans=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return ans;
    }



    public static void main(String[] args){
        int[] arr={1,2,5,9};
        int threshold=6;
        System.out.println(smallestDivisorBrute(arr, threshold));
        System.out.println(smallestDivisorBrute(arr, threshold));


    }
    
}
