package Day5;

public class maxSubArrSum {

    // brute not good for large inputs 
    // Time: 0(n3) 
    // Space: 0(1)

    // public static int maxSubArrSum(int [] arr){
    //     int maxSum=Integer.MIN_VALUE;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i;j<arr.length;j++){
    //             int sum=0;
    //             for(int k=i;k<=j;k++){
    //                 sum+=arr[k];
    //             }
    //             maxSum=Math.max(maxSum,sum);
    //         }
    //     }
    //     return maxSum;
    // }

    // better :
    // Time: 0(n2) 
    // Space: 0(1)
    // public static int maxSubArrSum(int[] arr){
    //     int maxSum=Integer.MIN_VALUE;
    //     for(int i=0;i<arr.length;i++){
    //         int sum=0;
    //         for(int j=i;j<arr.length;j++){
    //             sum+=arr[j];
    //             maxSum=Math.max(maxSum,sum);
    //     }}
    //     return maxSum;
    // } 

    // optimal : Kadane's algorithm
    // Time: 0(n) 
    // Space: 0(1)

    public static int maxSubArrSum(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i: arr){
            currSum+=i;
            maxSum=Math.max(maxSum, currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }




    public static void main(String[] args) {
        int [] arr={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArrSum(arr));

    }
    
}
