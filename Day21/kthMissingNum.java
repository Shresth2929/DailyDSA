package Day21;

public class kthMissingNum {
    //  if arr=[2,3,4,,7,11] and k=5 then 5th missing no from 1-11 is 9 

    // brute
    // Time: O(n + k)
    // Space: O(1)

    public static int kthMissingNumBrute(int[] arr, int k){
        int i=0;
        int current=1;

        while(k > 0){
            if(i<arr.length &&  arr[i] ==current){
                i++;
            }else {
                k--;
            if(k==0) return current;
        }
        current ++;
    }
    return current;
    }

    // optimal
    //   // Time: O(log n)
    // Space: O(1)

    public static int kthMissingNumOptimal(int[] arr, int k){
        int low=0;
        int high=arr.length;

        while(low <=high){
             int mid=(low + high )/2;

             int missing= arr[ mid] - (mid+1);

             if(missing < k){
                low= mid+1;
             }else{
                high=mid-1;
             }

        }
        return low+k;

    }



    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        System.out.println(kthMissingNumBrute(arr, 5));
        System.out.println(kthMissingNumOptimal(arr, 5));

    }


    
}
