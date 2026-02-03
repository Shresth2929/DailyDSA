package Day19;

public class peakElement {

    // element should be greater than its left and right element

    // brute
    public static int peakElementBrute(int[] arr){
        int n=arr.length;

        if(n==1) return arr[0];

        if(arr[0] > arr[1]) return arr[0];

        if(arr[n-1] > arr[n-2]) return arr[n-1];

        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    // optimal
    public static int peakElementOptimal(int[] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;

        while(low < high){
            int mid=(high+low)/2;

            if(arr[mid] > arr[mid+1]){
                // descending slope → peak on left
                high=mid;

            }else{
                // ascending slope → peak on right
                low=mid+1;
            }
        }

        // // low == high → peak index
        return arr[low];


}
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,5,1};
        System.out.println(peakElementBrute(arr));
        System.out.println(peakElementOptimal(arr));

    }
    
}
